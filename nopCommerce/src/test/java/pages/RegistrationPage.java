package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

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

        if (gender.toString().equals("Male"))
        {getGenderList().get(0).click();}
        if (gender.toString().equals("Female")) {
            getGenderList().get(1).click();
        }
    }

    public void fillInRequiredFields (String firstName, String lastName, String email, String password, String confirmPass){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPass);
    }


}
