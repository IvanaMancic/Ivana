package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Computers;
import pages.Products;
import pages.WishListPage;

public class WishlistDeleteProducts extends BaseTest {

//This test should verify that:
    //products are successfully deleted from wishlist
    //the message "The wishlist is empty!" is shown when the wishlist is empty
//Steps to reproduce (expected results):
    //1. Open home Page url (HomePage is opened)
    //2. Choose Computers -> Notebooks from dropdown menu (List of products is shown)
    //3. Click 'add to Wishlist' on a certain product from the list (Confirming notification is shown)
    //4. Choose Computers -> Software from dropdown menu (List of products is shown)
    //5. Click 'add to Wishlist' on a certain product from the list (Confirming notification is shown)
    //6. Click wishlist icon to open wishlist (Wishlist is open and products added in previous steps are displayed)
    //7. Click delete button (x) to delete first product (Product is not in the wishlist anymore)
    //8. Click delete button (x) to delete second product (The wishlist is empty and the message is displayed: "The wishlist is empty!")

    @Test
    public void verifyProductsAreDeletedFromWishlistAndMessageDisplayed () throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        Computers compPage = new Computers(driver);
        Products products = compPage.openNotebooksProductsFromDropdown();
        products.addToWishlist(driver, productsData.getNotepad1());
        compPage.openSoftwareProductsFromDropdown();
        products.addToWishlist(driver, productsData.getSoftware1());
        Thread.sleep(2000);
        WishListPage wishListPage = clickWishListButton(driver);
        wishListPage.deleteProductFromWishlist (productsData.getNotepad1());
        Thread.sleep(5000);
        wishListPage.deleteProductFromWishlist (productsData.getSoftware1());
        assert wishListPage.getListOfProductsInWishList().isEmpty(): "The Whishlist is not empty. There are these products in the Wishlist: " + wishListPage.getTitlesOfProductsInWishlist();
        assert wishListPage.getEmptyWishlistMessage().equals(notificationData.getEmptyWishlistMessageText()): "The right text is not displayed. Expected text is : " + notificationData.getEmptyWishlistMessageText() + " The actual text is: " + wishListPage.getEmptyWishlistMessage();

    }

}
