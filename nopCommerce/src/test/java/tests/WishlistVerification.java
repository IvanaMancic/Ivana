package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Computers;
import pages.HomePage;
import pages.Products;

public class WishlistVerification extends BaseTest {

    @Test
    public void verifyProductsAreAddedToWishlistFromListOfProducts () throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.chooseLabelAndActionFromMainManu(driver, HomePage.mainManuLabels.Computers, "click");
        Computers compPage = new Computers(driver);
        compPage.chooseLabelFromComputerManu(driver, HomePage.Computers.Notebooks);
        Products products = new Products(driver);
        for (int i = 1; i < products.getListOfProducts().size(); i++) {
            String productName = products.getListOfProducts().get(i).getText();
            products.addToWishlist(driver, productName);
            Thread.sleep(3000);
            assert products.isElementPresent(products.getWishlistNotification()) : "Wishlist notification is not displayed.";
            String number = String.valueOf(i);
            assert products.getWishListButton().findElement(By.className("wishlist-qty")).getText().contains(number) : "Whishlist number on wishlist icon is not changed.";
            products.goToWishlistFromNotification();
            products.assertProductIsInTheWishlist(productName);
            homePage.chooseComputerSubItemAndAction(driver, HomePage.Computers.Notebooks, "click");
        }
    }

        @Test
        public void verifyOneProductIsAddedToWishlist () throws InterruptedException {
            ChromeDriver driver = new ChromeDriver();
            HomePage homePage = new HomePage(driver);
            homePage.chooseLabelAndActionFromMainManu(driver, HomePage.mainManuLabels.Computers, "click");
            Computers compPage = new Computers(driver);
            compPage.chooseLabelFromComputerManu(driver, HomePage.Computers.Notebooks);
            Products products = new Products( driver);
            products.addToWishlist(driver, "Samsung Series 9");
            Thread.sleep(3000);
            products.goToWishlistFromNotification();
            products.assertProductIsInTheWishlist("Samsung Series 9");
            homePage.chooseComputerSubItemAndAction(driver, HomePage.Computers.Notebooks, "click");
            products.addToWishlist(driver, "Asus");
            Thread.sleep(3000);
            products.goToWishlistFromNotification();
            products.assertProductIsInTheWishlist("Lenovo");

        }

}
