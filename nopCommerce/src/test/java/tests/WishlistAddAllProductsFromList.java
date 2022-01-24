package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Computers;
import pages.Products;
import pages.WishListPage;

public class WishlistAddAllProductsFromList extends BaseTest {

/*
This test should verify that:
    - all products from the list of products are added to the Wishlist

Steps to reproduce (expected results):
    1. Open home Page url (HomePage is opened)
    2. Choose Computers -> Notebooks from dropdown menu (List of products is shown)
    3. CLick 'add to Wishlist' on a product (Confirming notification 'The product has been added to your wishlist' with a clickable link is displayed, wishlist icon number is increased by 1)
    4. Repeat previous action for each product.
    5. Click wishlist icon (Wishlist page with all products is open)
    */

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
