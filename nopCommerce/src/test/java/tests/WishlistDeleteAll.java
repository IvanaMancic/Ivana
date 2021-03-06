package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;



public class WishlistDeleteAll extends BaseTest {


    //Solved! Changed for with do while
    // Test deletes 3 products (out of 5) and just continues to assert (without failing)

       @Test
    public void verifyAllProductsAreDeletedFromWishlist () throws InterruptedException {
            ChromeDriver driver = new ChromeDriver();
            Computers computers = new Computers(driver);
            Products products = computers.openNotebooksProductsFromDropdown();
            products.addAllProductsFromListToWishlist();
            WishListPage wishlist = clickWishListButton(driver);
            wishlist.deleteAllFromWishlist();
            assert wishlist.getListOfProductsInWishList().isEmpty():
                    "The Whishlist is not empty. There are these products in the Wishlist: " + wishlist.getTitlesOfProductsInWishlist();
        }











}
