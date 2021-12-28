package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="Email")
    private WebElement emailField;

    @FindBy (id="Password")
    private WebElement passwordField;

    @FindBy (xpath="//button[@class='button-1 login-button']")
    private WebElement loginButton;


    public LoginPage (ChromeDriver driver){
        super(driver);
    }

    public void enterLoginInfo (String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void confirmLogin (){
        loginButton.click();
    }
}
