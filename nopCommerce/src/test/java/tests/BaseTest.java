package tests;

import enums.Currency;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;

public class BaseTest {



    public void enterHomePage(ChromeDriver driver) {
        HomePage page = new HomePage(driver);
    }

    public HomePage clickOnMainLogo (ChromeDriver driver) {
        BasePage page = new BasePage(driver);
        page.getMainLogo().click();
        return new HomePage(driver);
    }

    public RegistrationPage clickRegisterButton (ChromeDriver driver){
          BasePage page = new BasePage(driver);
          page.getregisterButton().click();
          return new RegistrationPage (driver);
    }


    public LoginPage clickLoginButton (ChromeDriver driver){
        BasePage page = new BasePage(driver);
        page.getLoginButton().click();
        return new LoginPage(driver);
    }

    public WishListPage clickWishListButton (ChromeDriver driver){
        BasePage page = new BasePage(driver);
        page.getWishListButton().click();
        return new WishListPage (driver);
    }

    public CartPage clickCartButton (ChromeDriver driver){
        BasePage page = new BasePage(driver);
        page.getCartButton().click();
        return new CartPage (driver);
    }

    public void search (ChromeDriver driver, String text){
        BasePage page = new BasePage(driver);
        page.getSearchInput().sendKeys(text);
        page.getSearchButton().click();
          }

    public void selectCurrency (ChromeDriver driver, BasePage.Currency options) {
        BasePage page = new BasePage(driver);
        Select currencySelector = new Select(page.getCurrencySelectorButton());
        currencySelector.selectByVisibleText(String.valueOf(options));

    }



}
