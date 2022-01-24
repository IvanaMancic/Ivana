package tests;

import data.Data;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Computers;
import pages.HomePage;
import pages.Products;

public class ProductsSortDisplayAddButtons extends BaseTest {


    //todo add asserts

/*
This test should verify that buttons for actions with products in the list work properly:
            -sort
            -display
            -add to cart
            -add to compare
            -add to wishlist

Steps to reproduce (expected results):
    1. Open home Page url (HomePage is opened)
    2, User chooses Computer label from main manu and clicks on it (Computer many with labels is opened)
    3. User chooses Notebook label from Computer manu (list of products is shown)
    4. Click sort button and choose descending order - from high to low price (Products should be by the price in descending order)
    5. Click display button and choose to display 9 products (Display 9 is shown beside the button and 9 products can be listed)
    6. Chose icon to show list view (Products are shown as list, not blocks)
    7. Click add to cart for a certain product (Add to cart icon number changed to 1, confirming notification is shown)
    8. Click compare product for a certain product "Samsung Series 9 NP900X4C Premium Ultrabook" (Confirming message is displayed)
    9. Click compare product for a certain product "Asus N551JK-XO076H Laptop" (Confirming message is displayed)
    10. Open comparing list from notification. (Two added products are in the list)
    11.Click 'add to Wishlist' on a certain product from the list "Asus N551JK-XO076H Laptop" (Confirming notification is shown, wishlist icon number increases by 1)

 */


    @Test
    public void verifySortDisplayAddWithProductsInTheList() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.chooseLabelAndActionFromMainManu(driver, HomePage.mainManuLabels.Computers, "click");
        Computers compPage = new Computers(driver);
        Products products = compPage.chooseLabelFromComputerManu(driver, HomePage.Computers.Notebooks);
        products.sortProducts(Data.SortValueDesc);
        products.displayProducts(Data.display9);
        products.chooseListView();
        products.addProductToCart(driver, data.notepad1);
        products.clickToCompareProduct(driver, data.notepad1);
        products.clickToCompareProduct(driver, data.notepad2);
        products.addToWishlist(driver, data.notepad2);
    }
}
