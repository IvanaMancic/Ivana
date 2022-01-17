package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.RegistrationPage;

public class Registration extends BaseTest {

    @Test
    public void verifyRegistrationWithValidCredentials() {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        RegistrationPage page = clickRegisterButton(driver);
        page.chooseGender(RegistrationPage.Gender.Female);
        page.fillInRequiredFields("Ivana", "Mancic", "ivana@gmail.com", "123456", "123456");
        page.enterDateOfBirth("14", "6", "1988");
        page.uncheckNewsletter();
        page.enterCompanyName("company");
        page.confirmRegistration();

    }
}
