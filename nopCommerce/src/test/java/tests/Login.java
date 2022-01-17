package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

public class Login extends BaseTest {

    @Test
    public void verifyLoginWithValidCredentials() {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

//        enterHomePage(driver);
        LoginPage page = clickLoginButton(driver);
        page.enterLoginInfo("ivana@gmail.com", "123456");
        page.uncheckRememberMe();
//        page.recoverPassword("ivana@gmail.com");
        page.confirmLogin();

    }
}
