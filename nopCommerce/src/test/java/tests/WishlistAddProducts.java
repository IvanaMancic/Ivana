package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Computers;
import pages.Products;
import pages.WishListPage;

public class WishlistAddProducts extends BaseTest {

//This test should verify that:
    //product is added to a Wishlist
    //confirming notification 'The product has been added to your wishlist', with the link to the Wishlist is displayed
    //notification link navigates to the Wishlist page
    //wishlist icon number is increased by 1 every time a new product is added
//Steps to reproduce (expected results):
    //1. Open home Page url (HomePage is opened)
    //2. Choose Computers -> Notebooks from dropdown menu (List of products is shown)
    //3. CLick 'add to Wishlist' on a product (Confirming notification 'The product has been added to your wishlist' with a clickable link is displayed, wishlist icon number is increased by 1)
    //4. Click notification link 'wishlist' (Wishlist page is open with a chosen product in it)
    //5. Choose Computers -> Notebooks from dropdown menu (List of products is shown)
    //6. Do 1 to 5 for each product in a list.
    //7. Click whilst icon (Wishlist page with all products is open)
    @Test
    public void verifyProductsAreAddedToWishlistWIthRightNotificationAndIconNumber () throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        Computers computers = new Computers(driver);
        Products products = computers.openNotebooksProductsFromDropdown();
//        for (int i = 1; i < products.getListOfProducts().size(); i++) {
        for (int i = 1; i<3; i++) {
            String productName = products.getListOfProducts().get(i).getText();
            products.addToWishlist(driver, productName);
            Thread.sleep(2000);
            assert products.isElementPresent(products.getNotificationLink()) : "Wishlist notification is not displayed.";
            assert products.getNotificationLink().getText().equals("wishlist"): "The link text isn't right.";
            assert products.notificationText().equals(notificationData.getConfirmAddToCartMessage()): products.notificationText();
            String number = String.valueOf(i);
            assert products.getWishListButton().findElement(By.className("wishlist-qty")).getText().contains(number) : "Whishlist number on wishlist icon is not changed.";
            WishListPage wishlist = products.goToWishlistFromNotification();
            wishlist.assertProductIsInTheWishlist(productName);
            computers.openNotebooksProductsFromDropdown();

        }
        WishListPage wishListPage = new WishListPage(driver);
        wishListPage.assertAllProductsAreInWishlist();


    }
}
