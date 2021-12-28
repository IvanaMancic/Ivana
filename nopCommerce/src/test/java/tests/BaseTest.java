package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class BaseTest {

      public HomePage clickOnMainLogo (ChromeDriver driver) {
        BasePage page = new BasePage(driver);
        page.getMainLogo().click();
        return new HomePage(driver);
    }

    public RegistrationPage clickRegisterButton (ChromeDriver driver){
          BasePage page = new BasePage(driver);
          page.getregisterButton().click();
          return new RegistrationPage (driver);
    }

    public LoginPage clickLoginButton (ChromeDriver driver){
        BasePage page = new BasePage(driver);
        page.getLoginButton().click();
        return new LoginPage(driver);
    }

}
