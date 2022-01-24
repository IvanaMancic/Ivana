package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

public class LoginWithValidCredentials extends BaseTest {

/*
This test should verify that:
    - User is logged in successfully with valid credentials
    - Checkbox 'remember me' can be checked and unchecked

Preconditions:
    - It is necessary that user already has an account.

Steps to reproduce (expected results):
    1. Open home Page url (HomePage is opened)
    2. Click on login icon (Login page is opened)
    3. Enter email and password
    4. Check remember me (the box is checked)
    5. Uncheck remember me (the box is unchecked)
    6. Click login button (User is logged in, login icon is changed to 'logout', user is on the Home page)

 */

    @Test
    public void verifyLoginWithValidCredentials() {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        LoginPage page = clickLoginButton(driver);
        page.enterLoginInfo(data.validEmail, data.validPassword);
        page.checkRememberMe();
        page.uncheckRememberMe();
//        page.recoverPassword("ivana@gmail.com");
        page.confirmLogin();
        Assert.assertEquals("User is not on the Homepage. The url of this page is : " + driver.getCurrentUrl(),
                            homePage.getPageTitle(), data.homePageTitle);
        Assert.assertTrue("User is not logged in. Log out button is not found.",
                            page.isElementPresent(page.getLogoutButton()));
    }
}
