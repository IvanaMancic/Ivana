import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAddToCart {

    String loginUrl = "https://www.saucedemo.com/";
    String userName = "problem_user";
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

    @org.junit.Test
        public void LogIn(){
        ChromeDriver driver = new ChromeDriver();
        String currentUrl = loginToHomePage(driver);
        Assert.assertEquals("The user is not logged in. Current url is: " + currentUrl + " Expected url is: " + homeUrl,currentUrl, homeUrl);
        driver.close();

    }

    @org.junit.Test
    public void addtoCartAndRemoveFromCart() {
        ChromeDriver driver = new ChromeDriver();
        String currentUrl = loginToHomePage(driver);

        WebElement addToCartButton = driver.findElementById("add-to-cart-sauce-labs-backpack");
        addToCartButton.click();
        addToCartButton = driver.findElementById("add-to-cart-sauce-labs-bike-light");
        addToCartButton.click();

        WebElement removeFromCartButton = driver.findElementById("remove-sauce-labs-backpack");
        Assert.assertTrue("The actual text is " + removeFromCartButton.getText() + " The expected result is REMOVE", (removeFromCartButton.getText().equals("REMOVE")));

        WebElement cartIcon = driver.findElementById("shopping_cart_container");
        String cartIconBadge = cartIcon.getText();
        Assert.assertTrue("The Cart Icon Badge isn't right.", cartIconBadge.equals("2"));
        cartIcon.click();

        WebElement itemName1 = driver.findElementById("item_4_title_link");
        WebElement itemName2 = driver.findElementById("item_0_title_link");
        Assert.assertTrue("Expected result is to have a product 'Sauce Labs Backpack' and 'Sauce Labs Bike Light' in a Cart. " + "Actual result is there is a product: " + itemName1.getText() + " and a product: " + itemName2.getText() , itemName1.getText().equals("Sauce Labs Backpack") && itemName2.getText().equals("Sauce Labs Bike Light"));

        WebElement removeFromCart = driver.findElementById("remove-sauce-labs-bike-light");
        removeFromCart.click();
        Assert.assertFalse ("Artikal nije izbrisan iz korpe.", itemName2.isDisplayed());




    }
}
