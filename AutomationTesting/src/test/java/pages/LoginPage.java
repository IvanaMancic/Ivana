package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

//defining PRIVATE web elements of LoginPage
    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy (xpath = "//button[@class='error-button']")
    private WebElement errorMessageContainer;

    //constructor (for creating LoginPage objects in a new class)

    public LoginPage(ChromeDriver driver) {
        super(driver);
    }




// creating PUBLIC methods with web elements in LoginPage

    public void enterUsername (String userName){
        userNameInput.sendKeys(userName);
    }

    public void enterPassword (String password){
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton (){
        loginButton.click();
    }

    public String getErrorMessageText (){
        return errorMessageContainer.getText();
    }


    public HomePage login (String userName, String password){
        enterUsername(userName);
        enterPassword(password);
        clickLoginButton();
        return new HomePage();
    }


}
