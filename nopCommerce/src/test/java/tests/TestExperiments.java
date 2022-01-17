package tests;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class TestExperiments extends BaseTest {




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
        products.sortProducts(products.getSortValueDesc());
        products.displayProducts(products.getDisplay9());
        products.chooseListView();
        products.chooseProductFromList(driver, "Apple MacBook");
        products.addProductToCart(driver, "Digital Storm");
       products.clickToCompareProduct(driver, "Digital Storm");
        products.clickToCompareProduct(driver, "Lenovo");
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
