package tests;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class TestExperiments extends BaseTest {


    @Test
    public void checkBaseTestMethods() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        enterHomePage(driver);
        clickRegisterButton(driver);
        clickLoginButton(driver);
        clickOnMainLogo(driver);
        search(driver, "computer");
        clickCartButton(driver);
        clickWishListButton(driver);
        selectCurrency(driver, BasePage.Currency.Euro);
    }

    @Test
    public void verifyRegistrationWithValidCredentials() {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

//        enterHomePage(driver);
        RegistrationPage page = clickRegisterButton(driver);
        page.chooseGender(RegistrationPage.Gender.Female);
        page.fillInRequiredFields("Ivana", "Mancic", "ivana@gmail.com", "123456", "123456");
        page.enterDateOfBirth("14", "6", "1988");
        page.uncheckNewsletter();
        page.enterCompanyName("company");
        page.confirmRegistration();








    }

    @Test
    public void verifyLoginWithValidCredentials() {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

//        enterHomePage(driver);
        LoginPage page = clickLoginButton(driver);
        page.enterLoginInfo("ivana@gmail.com", "123456");
        page.uncheckRememberMe();
//        page.recoverPassword("ivana@gmail.com");
        page.confirmLogin();

    }


    @Test
    public void checkMainManu () throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
//        LoginPage page = clickLoginButton(driver);
//        page.login("ivana@gmail.com", "123456");

        homePage.chooseLabelAndActionFromMainManu(driver, HomePage.mainManuLabels.Computers, "click");
//        homePage.chooseComputerSubItemAndAction(driver, HomePage.Computers.Notebooks, "click");
        Computers compPage = new Computers(driver);
        compPage.chooseLabelFromComputerManu(driver, HomePage.Computers.Notebooks);
        Products products = new Products( driver);
//        desktopsPage.sortProducts(desktopsPage.getSortValueDesc());
//        desktopsPage.displayProducts(desktopsPage.getDisplay9());
//        desktopsPage.chooseListView();
//        products.chooseProductFromList(driver, "Apple MacBook");
//        products.addProductToCart(driver, "Digital Storm");
//       products.clickToCompareProduct(driver, "Digital Storm");
//        products.clickToCompareProduct(driver, "Lenovo");
        products.addToWishlist(driver, "Asus N551JK-XO076H");
//        products.chooseProductFromList(driver, "Samsung Series 9 ");
//        SpecificProduct product = new SpecificProduct(driver);
//        product.enterQuantity("3");
//        product.addToCart();
//        product.addReview();
//        ProductReview review = new ProductReview(driver);
//        review.sendReview("my title", "my text", "3");




    }

}
