package tests;

import enums.Currency;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.RegistrationPage;

public class TestExperiments extends BaseTest{


//this test checks methods from BaseTest
    @Test
    public void checkBaseTestMethods () {
        ChromeDriver driver = new ChromeDriver();
        eneterHomePage(driver);
        clickRegisterButton(driver);
        clickLoginButton(driver);
        clickOnMainLogo(driver);
        search(driver, "computer");
        clickCartButton(driver);
        clickWishListButton(driver);
        selectCurrency(driver, BasePage.Currency.Euro);
    }

        @Test
        public void verifyRegistrationWithValidCredentials (){
        ChromeDriver driver = new ChromeDriver();
        eneterHomePage(driver);
        RegistrationPage page = clickRegisterButton(driver);
        page.chooseGender(RegistrationPage.Gender.Male);
        page.fillInRequiredFields("Ivana", "Mancic", "ivana@gmail.com", "123456", "123456");
        page.enterDateOfBirth("14", "6", "1988");
        page.confirmRegistration();
    }



}
