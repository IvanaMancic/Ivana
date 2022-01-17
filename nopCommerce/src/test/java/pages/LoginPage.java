package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy (xpath = "//div[@class='page-title']/h1")
    private WebElement pageTitleField;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    private WebElement loginButton;

    @FindBy(id = "RememberMe")
    private WebElement rememberMeCheckbox;

    @FindBy(className = "forgot-password")
    private WebElement forgotPasswordButton;

    @FindBy(xpath = "//input[@class='email']")
    private WebElement recoveryEmailField;

    @FindBy(xpath = "//button[@class='button-1 password-recovery-button']")
    private WebElement recoveryButton;


    public LoginPage(ChromeDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
       return pageTitleField.getText();
    }

    public void enterLoginInfo(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void confirmLogin() {
        loginButton.click();
    }

    public void checkRememberMe() {
        if (!rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }
    }

    public void uncheckRememberMe() {
        if (rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }

    }

    public void recoverPassword (String email){
        forgotPasswordButton.click();
        recoveryEmailField.sendKeys(email);
        recoveryButton.click();
    }

    public void login (String email, String password){
        enterLoginInfo(email, password);
        confirmLogin();
    }

}
