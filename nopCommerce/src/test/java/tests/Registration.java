package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.RegistrationPage;

public class Registration extends BaseTest {

//

    @Test
    public void verifyRegistrationWithValidCredentials() {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        RegistrationPage page = clickRegisterButton(driver);
        page.chooseGender(RegistrationPage.Gender.Female);
        page.fillInRequiredFields(contentData.getValidFirstName(), contentData.getValidLastName(), contentData.getValidEmail(), contentData.getValidPassword(), contentData.getValidConfirmPassword());
        page.enterDateOfBirth(contentData.getValidDateOfBirth(), contentData.getValidMonthOfBirth(), contentData.getValidYearOfBirth());
        page.uncheckNewsletter();
        page.enterCompanyName(contentData.getCompanyName());
        page.confirmRegistration();

    }
}
