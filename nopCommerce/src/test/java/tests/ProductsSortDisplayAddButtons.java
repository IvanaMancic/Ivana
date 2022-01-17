package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Computers;
import pages.HomePage;
import pages.Products;

public class ProductsSortDisplayAddButtons extends BaseTest {

    @Test
    public void verifySortDisplayAddWithProductsInTheList() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.chooseLabelAndActionFromMainManu(driver, HomePage.mainManuLabels.Computers, "click");
        Computers compPage = new Computers(driver);
        Products products = compPage.chooseLabelFromComputerManu(driver, HomePage.Computers.Notebooks);
        products.sortProducts(products.getSortValueDesc());
        products.displayProducts(products.getDisplay9());
        products.chooseListView();
//        products.chooseProductFromList(driver, "Apple MacBook");
        products.addProductToCart(driver, productsData.getNotepad1());
        products.clickToCompareProduct(driver, productsData.getNotepad1());
        products.clickToCompareProduct(driver, productsData.getNotepad2());
        products.addToWishlist(driver, productsData.getNotepad2());
    }
}
