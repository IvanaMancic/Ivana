package tests;

import data.Data;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class HomePageHeaderButtons extends BaseTest {

/*
This test should verify that home page header buttons work properly:
       - (login, register, wishlist, cart, search, currency selector)

Steps to reproduce (expected results):
    1. Click on register button (User is navigated to registration page)
    2. Click on login button (User is navigated to login page)
    3. Click on main logo (User is navigated to home page)
    4. Enter the word in search field. (The world is visible in search field with a cursor)
    5. Click search button. (The list of products found is displayed)
    6. Click on shopping cart button (User is navigated to shopping cart page)
    7. Click on wishlist button (User is navigated to wishlist page)
    8. Change currency from US Dollar to Euro. (Euro currency is displayed)
*/

    @Test
    public void verifyHomePageHeaderButtonsWorkProperly() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        RegistrationPage registration = clickRegisterButton(driver);
        assert registration.getPageTitle().equals(Data.registrationPageTitle);
        LoginPage login = clickLoginButton(driver);
        assert login.getPageTitle().equals(Data.loginPageTitle);
        clickOnMainLogo(driver);
        assert homePage.getPageTitle().equals(data.homePageTitle);
        Products products = search(driver, "computer");
        for (String product: products.getTitlesOfProducts()){
                if (product.contains("computer")) {}
                else assert (product.contains("computer")):
                        "The product in the list doesn't contain the word from search. The products in list are: " + products.getTitlesOfProducts();
            }
        CartPage cartPage = clickCartButton(driver);
        assert cartPage.getPageTitle().equals(data.cartPageTitle);
        WishListPage wishListPage = clickWishListButton(driver);
        assert wishListPage.getPageTitle().equals(data.wishlistPageTitle);
        selectCurrency(driver, BasePage.Currency.Euro);
        assert getSelectedCurrencyText(driver).equals(BasePage.Currency.Euro.name());

    }
}
