package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class RegistrationPage extends BasePage {

    @FindBy (id="FirstName")
    private WebElement firstNameField;

    @FindBy (id="LastName")
    private WebElement lastNameField;

    @FindBy (id="Email")
    private WebElement emailField;

    @FindBy (id="Password")
    private WebElement passwordField;

    @FindBy (id="ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy (xpath="//select[@name='DateOfBirthDay']")
    private WebElement dayOfBirthField;

    @FindBy (xpath="//select[@name='DateOfBirthMonth']")
    private WebElement monthOfBirthField;

    @FindBy (xpath="//select[@name='DateOfBirthYear']")
    private WebElement yearOfBirthField;

    @FindBy (id="register-button")
    private WebElement registerButton;

    @FindBy (className="button-1 register-continue-button")
    private WebElement continueToHomeButton;

    @FindBy (id="Newsletter")
    private WebElement newsletterCheckbox;

    @FindBy (id="Company")
    private WebElement companyNameField;


    public RegistrationPage(ChromeDriver driver){
        super(driver);
    }



    public ArrayList<WebElement> getGenderList(){
        ArrayList<WebElement> genderList = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@id='gender']//input"));
        return genderList;
    }

    public enum Gender {
        Male, Female
    }

    public void chooseGender (RegistrationPage.Gender gender){
        switch (gender){
            case Male -> {
                getGenderList().get(0).click();
            }
            case Female -> {
                getGenderList().get(1).click();
            }
        }

//if changed with switch case
//        if (gender.toString().equals("Male")) {
//            getGenderList().get(0).click();
//            }
//        if (gender.toString().equals("Female")) {
//            getGenderList().get(1).click();
//            }
    }

    public void fillInRequiredFields (String firstName, String lastName, String email, String password, String confirmPass){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPass);
    }

    public void enterDateOfBirth (String dayOfBirth, String monthOfBirth, String yearOfBirth){
        Select day = new Select(dayOfBirthField);
        day.selectByValue(dayOfBirth);
        Select month = new Select(monthOfBirthField);
        month.selectByValue(monthOfBirth);
        Select year = new Select(yearOfBirthField);
        year.selectByValue(yearOfBirth);
    }

    public void confirmRegistration (){
        registerButton.click();
        if (isElementPresent(continueToHomeButton)){
        continueToHomeButton.click();
        }
    }

    public void checkNewsletter (){
        if (!newsletterCheckbox.isSelected()){
            newsletterCheckbox.click();
        }
    }

    public void uncheckNewsletter (){
        if (newsletterCheckbox.isSelected()){
            newsletterCheckbox.click();
        }
    }

    public void enterCompanyName (String companyName){
        companyNameField.sendKeys(companyName);
    }


}
