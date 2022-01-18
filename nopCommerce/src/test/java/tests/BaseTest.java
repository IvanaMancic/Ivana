package tests;

import data.FieldsContentData;
import data.NotificationData;
import data.PageData;
import data.ProductsData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.*;

public class BaseTest {

    ProductsData productsData  = new ProductsData();
    NotificationData notificationData = new NotificationData();
    PageData pageData = new PageData();
    FieldsContentData contentData = new FieldsContentData();

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
          page.getRegisterButton().click();
          return new RegistrationPage (driver);
    }


    public LoginPage clickLoginButton (ChromeDriver driver){
        BasePage page = new BasePage(driver);
        page.getLoginButton().click();
        return new LoginPage(driver);
    }

    public WishListPage clickWishListButton (ChromeDriver driver) throws InterruptedException {
        BasePage page = new BasePage(driver);
        Thread.sleep(3000);
        page.getWishListButton().click();
        return new WishListPage (driver);
    }

    public CartPage clickCartButton (ChromeDriver driver){
        BasePage page = new BasePage(driver);
        page.getCartButton().click();
        return new CartPage (driver);
    }

    public Products search (ChromeDriver driver, String text){
        BasePage page = new BasePage(driver);
        page.getSearchInput().sendKeys(text);
        page.getSearchButton().click();
        return new Products(driver);
          }

    public void selectCurrency (ChromeDriver driver, BasePage.Currency options) {
        BasePage page = new BasePage(driver);
        Select currencySelector = new Select(page.getCurrencySelectorButton());
        currencySelector.selectByVisibleText(String.valueOf(options));

    }

    public String getSelectedCurrencyText (ChromeDriver driver){
        BasePage page = new BasePage(driver);
        System.out.println(page.getCurrencySelectorButton().findElement(By.xpath("//option[@selected]")).getText());
         return page.getCurrencySelectorButton().findElement(By.xpath("//option[@selected]")).getText();

    }

    public MyAccountPage clickMyAccountButton (ChromeDriver driver){
        BasePage page = new BasePage(driver);
        page.getMyAccountButton().click();
        return new MyAccountPage (driver);
    }



}
