package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BasePage {

    ChromeDriver driver;



    @FindBy (xpath = "//div[@class='header-logo']/a")
    private WebElement mainLogo;

    @FindBy (className = "ico-register")
    private WebElement registerButton;

    @FindBy (className = "ico-login")
    private WebElement loginButton;

    @FindBy (className = "ico-wishlist")
    private WebElement wishListButton;

    @FindBy (className = "ico-cart")
    private WebElement cartButton;

    @FindBy (id = "customerCurrency")
    private WebElement currencySelectorButton;

    @FindBy (xpath = "//button[@class='button-1 search-box-button']")
    private WebElement searchButton;

    @FindBy (xpath = "//input[@aria-label='Search store']")
    private WebElement searchInput;



    public BasePage (ChromeDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
            }

    public boolean isElementPresent (WebElement element){
        try {
            return element.isDisplayed();
        } catch (final Exception e) {
            return false;
        }
    }


    public WebElement getMainLogo() {
        return mainLogo;
    }

    public WebElement getregisterButton() {
        return registerButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getWishListButton() {
        return wishListButton;
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    public WebElement getCurrencySelectorButton() {
        return currencySelectorButton;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public enum Currency {
        Dollar ("US Dollar"),
        Euro ("Euro");

        public String currency;

        Currency (String currency){
            this.currency=currency;
        }
    }



}
