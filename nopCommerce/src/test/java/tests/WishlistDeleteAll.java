package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;



public class WishlistDeleteAll extends BaseTest {

       @Test
    public void verifyAllProductsAreDeletedFromWishlist () throws InterruptedException {
            ChromeDriver driver = new ChromeDriver();
            Computers computers = new Computers(driver);
            Products products = computers.openNotebooksProductsFromDropdown();
            products.addAllProductsFromListToWishlist();
            WishListPage wishlist = clickWishListButton(driver);
            wishlist.deleteAllFromWishlist();
            assert products.getListOfProductsInWishList().isEmpty(): "The Whishlist is not empty. There are these products in the Wishlist: " + wishlist.getTitlesOfProductsInWishlist();
        }











}
