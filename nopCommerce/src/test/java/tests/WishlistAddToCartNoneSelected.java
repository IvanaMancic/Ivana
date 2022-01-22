package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Computers;
import pages.Products;
import pages.WishListPage;

public class WishlistAddToCartNoneSelected extends BaseTest {

//This test should verify that after clicking Add to Cart in the Wishlist:
    //right notification message is shown when no products are selected
    //notification is closed by clicking cancel button
//Steps to reproduce (expected results):
    //1. Open home Page url (HomePage is opened)
    //2. Choose Computers -> Notebooks from dropdown menu (List of products is shown)
    //3. Click 'add to Wishlist' on a certain product from the list (Confirming notification is shown)
    //4. Open wishlist by clicking the link 'wishlist' in the notification (Wishlist is opened)
    //5. Click 'add to Cart' (Notification message 'No products selected to add to cart.' is displayed");
    //6. Close the notification by clicking cancel button (Notification disappears)
    @Test
    public void verifyAddToCartDosentWorkWithNoItemsSelected () throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        Computers compPage = new Computers(driver);
        Products products = compPage.openNotebooksProductsFromDropdown();
        products.addToWishlist(driver, data.notepad1);
        WishListPage wishListPage = products.goToWishlistFromNotification();
        wishListPage.addToCartFromWishlist();
        assert wishListPage.notificationText().equals(data.noProductsInWishlistToAddToCart);
        wishListPage.closeNotification();
        Thread.sleep(2000);
        assert !(wishListPage.isElementPresent(wishListPage.getNotification())):
                "Notification is still open";


    }
}
