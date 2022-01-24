package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Computers;
import pages.Products;
import pages.WishListPage;

import java.util.ArrayList;

public class WishlistSharingLInk extends BaseTest {

/*
This test should verify that:
    -product is added to a Wishlist
    -link to share Wishlist is open in new Tab

Steps to reproduce (expected results):
    1. Open home Page url (HomePage is opened)
    2. Choose Computers -> Notebooks from dropdown menu (List of products is shown)
    3. Click 'add to Wishlist' on a certain product from the list (Confirming notification is shown)
    4. Open wishlist by clicking the link 'wishlist' in the notification (Wishlist is opened)
    5. Open link 'wishlist url for sharing' in new tab (Shared wishlist is open in new Tab)
    6. Go back to the Wishlist page

 */

    @Test
    public void verifyWishlistShareLinkIsOpen () throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        Computers computers = new Computers(driver);
        Products products = computers.openSoftwareProductsFromDropdown();
        products.addToWishlist(driver, data.software1);
        WishListPage wishlist = products.goToWishlistFromNotification();
        wishlist.assertProductIsInTheWishlist(data.software1);

        wishlist.openWishlistShareLinkInNewTab();
        assert !(products.isElementPresent(wishlist.getWhislistShareButton()))
                : "Sharing wishlist isn't open.";
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

    }

}
