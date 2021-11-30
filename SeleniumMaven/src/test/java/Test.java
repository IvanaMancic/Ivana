import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

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
    public void addtoCart() {
        ChromeDriver driver = new ChromeDriver();
        String currentUrl = loginToHomePage(driver);
        WebElement addToCartButton = driver.findElementById("add-to-cart-sauce-labs-backpack");
        addToCartButton.click();
        WebElement removeFromCartButton = driver.findElementById("remove-sauce-labs-backpack");
//        Assert.assertTrue("poruka", (driver.findElementById("remove-sauce-labs-backpack")).isDisplayed());
        Assert.assertTrue("The actual text is " + removeFromCartButton.getText() + " The expected result is REMOVE", (removeFromCartButton.getText().equals("REMOVE")));
//        WebElement cartIcon = driver

    }
}
