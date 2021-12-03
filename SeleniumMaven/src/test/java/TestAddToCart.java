import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAddToCart {

    String loginUrl = "https://www.saucedemo.com/";
    String userName = "standard_user";
    String password = "secret_sauce";
    String homeUrl = "https://www.saucedemo.com/inventory.html";

    public String loginToHomePage (ChromeDriver driver){
        driver.get(loginUrl);
        WebElement userNameInput = driver.findElementById("user-name");
        userNameInput.sendKeys( userName);
        WebElement passwordInput = driver.findElementById("password");
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElementById("login-button");
        loginButton.click();
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;

    }


    public String addRemoveItemsAndGoToCheckoutForm (ChromeDriver driver) {
        String homeUrl = "https://www.saucedemo.com/inventory.html";
        String checkoutStepOneUrl = "https://www.saucedemo.com/checkout-step-one.html";
        driver.get(homeUrl);
        WebElement addToCartButton = driver.findElementById("add-to-cart-sauce-labs-backpack");
        addToCartButton.click();
        addToCartButton = driver.findElementById("add-to-cart-sauce-labs-bike-light");
        addToCartButton.click();

        WebElement removeFromCartButton = driver.findElementById("remove-sauce-labs-backpack");
        Assert.assertTrue("The actual text is " + removeFromCartButton.getText() + " The expected result is REMOVE", (removeFromCartButton.getText().equals("REMOVE")));

        WebElement cartIcon = driver.findElementById("shopping_cart_container");
        Assert.assertTrue("The Cart Icon Badge isn't right.", cartIcon.getText().equals("2"));
        cartIcon.click();

        WebElement itemName1 = driver.findElementById("item_4_title_link");
        WebElement itemName2 = driver.findElementById("item_0_title_link");
        Assert.assertTrue("Expected result is to have a product 'Sauce Labs Backpack' and 'Sauce Labs Bike Light' in a Cart. " + "Actual result is there is a product: " + itemName1.getText() + " and a product: " + itemName2.getText() , itemName1.getText().equals("Sauce Labs Backpack") && itemName2.getText().equals("Sauce Labs Bike Light"));

        WebElement removeFromCart = driver.findElementById("remove-sauce-labs-bike-light");
        removeFromCart.click();

//        System.out.println(cartIcon.getText());
//        System.out.println(driver.findElementById("shopping_cart_container").getText());

//  It doesn't work when you use defined element cartIcon (stale element error), but it works with the method findElement. WHY?

        Assert.assertTrue("The Cart Icon Badge isn't right.", driver.findElementById("shopping_cart_container").getText().equals("1"));
//        Assert.assertFalse ("Artical is not deleted from a Cart.", itemName2.isDisplayed());

        WebElement checkoutButton = driver.findElementById("checkout");
        checkoutButton.click();
        Assert.assertTrue("The user is not navigated to the checkout page. Expected result is to be navigated to 'https://www.saucedemo.com/checkout-step-one.html'. Actual result is: The user is navigate to " + driver.getCurrentUrl(), driver.getCurrentUrl().equals(checkoutStepOneUrl));

        String currentUrl = driver.getCurrentUrl();
        return currentUrl;

    }

    public String completeCheckout (ChromeDriver driver) {
        String firstName = "Ivana";
        String lastName = "M";
        String postalCode = "11000";
        String checkoutStepTwoUrl = "https://www.saucedemo.com/checkout-step-two.html";
        String checkoutCompleteUrl = "https://www.saucedemo.com/checkout-complete.html";

        WebElement firstNameField = driver.findElementById("first-name");
        firstNameField.sendKeys(userName);
        WebElement lastNameField = driver.findElementById("last-name");
        lastNameField.sendKeys(lastName);
        WebElement postalCodeField = driver.findElementById("postal-code");
        postalCodeField.sendKeys(postalCode);
        WebElement continueButton = driver.findElementById("continue");
        continueButton.click();
        Assert.assertTrue("The user is not navigated to confirm the checkout. Expected result is to be navigated to 'https://www.saucedemo.com/checkout-step-two.html'. Actual result is: The user is navigate to " + driver.getCurrentUrl(), driver.getCurrentUrl().equals(checkoutStepTwoUrl));

        WebElement finishCheckoutButton = driver.findElementById("finish");
        finishCheckoutButton.click();
        Assert.assertTrue("The user is not navigated to complete checkout page. Expected result is to be navigated to 'https://www.saucedemo.com/checkout-complete.html'. Actual result is: The user is navigate to " + driver.getCurrentUrl(), driver.getCurrentUrl().equals(checkoutCompleteUrl));

        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    @org.junit.Test
    public void LogIn(){
        ChromeDriver driver = new ChromeDriver();
        String currentUrl = loginToHomePage(driver);
        Assert.assertEquals("The user is not logged in. Current url is: " + currentUrl + " Expected url is: " + homeUrl,currentUrl, homeUrl);
        driver.close();

    }


       @org.junit.Test
    public void CompleteCheckoutPositiveFlow() {

        ChromeDriver driver = new ChromeDriver();
        loginToHomePage(driver);
        addRemoveItemsAndGoToCheckoutForm(driver);
        completeCheckout(driver);

//        driver.close();


    }
}
