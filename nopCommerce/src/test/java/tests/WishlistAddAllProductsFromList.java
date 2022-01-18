package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Computers;
import pages.Products;
import pages.WishListPage;

public class WishlistAddAllProductsFromList extends BaseTest {

    @Test
    public void verifyAllProductsAreInWishlist () throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        Computers computers = new Computers(driver);
        Products products = computers.openNotebooksProductsFromDropdown();
        products.addAllProductsFromListToWishlist();
        WishListPage wishlist = new WishListPage(driver);
        wishlist.assertAllProductsAreInWishlist();
    }
}
