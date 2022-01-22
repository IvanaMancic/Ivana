package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegistrationPage;

public class RegistrationWithValidCredentials extends BaseTest {

//This test should verify that:
    //User successfully created an account with valid credentials
    //My account filed is filled in with right info

// Preconditions:
    // It is necessary that account with these credentials hasn't been created yet.

//Steps to reproduce (expected results):
    //1. Open home Page url (HomePage is opened)
    //2. Click on register icon (Registration page is opened)
    //3. Choose gender, fill in all fields with valid credentials
    //4. Uncheck newsletter (the box is unchecked)
    //5. Check newsletter (the box is checked)
    //6. Click register button (User is registered, the confirming notification is displayed, register icon is changed to 'my account')
    //7. Open My Account from my account icon (my account is open, with right info)

    @Test
    public void verifyRegistrationWithValidCredentials() {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        RegistrationPage page = clickRegisterButton(driver);
        page.chooseGender(RegistrationPage.Gender.Female);
        page.fillInRequiredFields (data.validFirstName, data.validLastName, data.validEmail, data.validPassword, data.validConfirmPassword);
        page.enterDateOfBirth(data.validDateOfBirth, data.validMonthOfBirth, data.validYearOfBirth);
        page.uncheckNewsletter();
        page.checkNewsletter();
        page.enterCompanyName(data.companyName);
        page.confirmRegistration();

//verify registration is complete
        Assert.assertEquals("Confirming registration message is not displayed or right.",
                            page.getConfirmRegistrationField().getText(),
                            data.confirmRegistration);
        Assert.assertTrue("My account button doesn't exist.",
                            page.isElementPresent(homePage.getMyAccountButton()));
//navigated to Home page
        page.continueToHome();
        Assert.assertEquals("User is not on the Homepage. The url of this page is : " + driver.getCurrentUrl(),
                    homePage.getPageTitle(), data.homePageTitle);

//verify my account info
        MyAccountPage myAccPage = clickMyAccountButton(driver);
        Assert.assertEquals(myAccPage.getPageTitleContainer().getText(),
                            data.myAccountPageTitle);

//        System.out.println("Acc name: " + myAccPage.getMyAccountNameText());
//        System.out.println("Acc last name: " + myAccPage.getMyAccountLastNameText());

        Assert.assertTrue("The name and last name in account are not correct. Acc name: " + myAccPage.getMyAccountNameText() + "Acc last name: " + myAccPage.getMyAccountLastNameText(),
                myAccPage.getMyAccountNameText().equals(data.validFirstName)
                && myAccPage.getMyAccountLastNameText().equals(data.validLastName));

    }
}
