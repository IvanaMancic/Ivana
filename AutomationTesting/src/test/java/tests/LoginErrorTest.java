package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginErrorTest {

    String loginUrl = "https://www.saucedemo.com/";
    String userName = "problem_user";
    String password = "secret_sauce";
    String errorMessage = "Epic sadface: Sorry, this user has been locked out.";
    String homeUrl = "https://www.saucedemo.com/inventory.html";
    ChromeDriver driver;

    @Test
    public void loginErrorTest() {
        driver = new ChromeDriver();
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);
        Assert.assertTrue("Expected result is that " + errorMessage + " is displayed. And user is on the " + homeUrl + ". Actual result is that user is on the " + driver.getCurrentUrl(), loginPage.getErrorMessageText().equals(errorMessage));


    }


}
