package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy (className = "currency-selector")
    private WebElement currencySelectorButton;

    @FindBy (className = "button-1 search-box-button")
    private WebElement searchButton;

    @FindBy (className = "search-box-text ui-autocomplete-input")
    private WebElement searchInput;



    public BasePage (ChromeDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
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

}
