package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class TestExperiments extends BaseTest {


    @Test
    public void checkBaseTestMethods() {
        ChromeDriver driver = new ChromeDriver();
        enterHomePage(driver);
        clickRegisterButton(driver);
        clickLoginButton(driver);
        clickOnMainLogo(driver);
        search(driver, "computer");
        clickCartButton(driver);
        clickWishListButton(driver);
        selectCurrency(driver, BasePage.Currency.Euro);
    }

    @Test
    public void verifyRegistrationWithValidCredentials() {
        ChromeDriver driver = new ChromeDriver();
        enterHomePage(driver);
        RegistrationPage page = clickRegisterButton(driver);
        page.chooseGender(RegistrationPage.Gender.Female);
        page.fillInRequiredFields("Ivana", "Mancic", "ivana@gmail.com", "123456", "123456");
        page.enterDateOfBirth("14", "6", "1988");
        page.uncheckNewsletter();
        page.enterCompanyName("company");
        page.confirmRegistration();
    }

    @Test
    public void verifyLoginWithValidCredentials() {
        ChromeDriver driver = new ChromeDriver();
        enterHomePage(driver);
        LoginPage page = clickLoginButton(driver);
        page.enterLoginInfo("ivana@gmail.com", "123456");
        page.uncheckRememberMe();
        page.recoverPassword("ivana@gmail.com");
//        page.confirmLogin();

    }


    @Test
    public void checkMainManu (){
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
//        homePage.chooseLabelFromMainManu(driver, HomePage.mainManuLabels.Computers, "hover");
        homePage.chooseComputerSubItemAndAction(driver, HomePage.mainManuLabels.Computers, HomePage.Computer.Notebooks, "click");
        Computer compPage = new Computer(driver);


    }
}
