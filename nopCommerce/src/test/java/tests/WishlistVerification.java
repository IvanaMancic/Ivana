package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.ArrayList;

public class WishlistVerification extends BaseTest {


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
    public void verifyWishlistNotificationAndIconNumberWorkProperly() throws InterruptedException {
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
            assert products.notificationText().equals("The product has been added to your wishlist"): products.notificationText();
            String number = String.valueOf(i);
            assert products.getWishListButton().findElement(By.className("wishlist-qty")).getText().contains(number) : "Whishlist number on wishlist icon is not changed.";
            WishListPage wishlist = products.goToWishlistFromNotification();
            wishlist.assertProductIsInTheWishlist(productName);
            computers.openNotebooksProductsFromDropdown();

            }
            WishListPage wishListPage = new WishListPage(driver);
            wishListPage.assertAllProductsAreInWishlist();


        }



    @Test
    public void verifyAllProductsAreinWishlist () throws InterruptedException {
            ChromeDriver driver = new ChromeDriver();
            Computers computers = new Computers(driver);
            Products products = computers.openNotebooksProductsFromDropdown();
            products.addAllProductsFromListToWishlist();
            WishListPage wishlist = new WishListPage(driver);
            wishlist.assertAllProductsAreInWishlist();
    }

    @Test
    public void verifyAllProductsAreDeletedFromWishlist () throws InterruptedException {
            ChromeDriver driver = new ChromeDriver();
            Computers computers = new Computers(driver);
            Products products = computers.openNotebooksProductsFromDropdown();
            products.addAllProductsFromListToWishlist();
            WishListPage wishlist = clickWishListButton(driver);
            wishlist.deleteAllFromWishlist();
            assert products.getListOfProductsInWishList() == null: "The Whishlist is not empty. There are these products in the Wishlist: " + wishlist.getTitlesOfProductsInWishlist();
        }


//This test should verify that:
    //product is added to a Wishlist
    //link to share Wishlist is open in new Tab
//Steps to reproduce (expected results):
    //1. Open home Page url (HomePage is opened)
    //2. Choose Computers -> Notebooks from dropdown menu (List of products is shown)
    //3. Click 'add to Wishlist' on a certain product from the list (Confirming notification is shown)
    //4. Open wishlist by clicking the link 'wishlist' in the notification (Wishlist is opened)
    //5. Open link 'wishlist url for sharing' in new tab (Shared wishlist is open in new Tab)
    //6. Go back to the Wishlist page

    @Test
    public void verifyWishlistShareLinkIsOpen () throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        Computers computers = new Computers(driver);
        Products products = computers.openSoftwareProductsFromDropdown();
        products.addToWishlist(driver, "Windows 8 Pro");
        WishListPage wishlist = products.goToWishlistFromNotification();
        wishlist.assertProductIsInTheWishlist("Windows 8 Pro");
        wishlist.openWishlistShareLinkInNewTab();
        assert !(products.isElementPresent(wishlist.getWhislistShareButton())): "Sharing wishlist isn't open.";
        ArrayList <String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

    }


//This test should verify that:
    // quantity is updated in the Wishlist.
    // product is successfully added to the Cart from Wishlist
//Steps to reproduce (expected results):
    //1. Open home Page url (HomePage is opened)
    //2. Choose Computers -> Notebooks from dropdown menu (List of products is shown)
    //3. Click 'add to Wishlist' on a certain product from the list (Confirming notification is shown)
    //4. Open wishlist by clicking the link 'wishlist' in the notification (Wishlist is opened)
    //5. Type number in 'product quantity field' (Number is displayed with a mouse pointer)
    //6. Click 'update wishlist'. (Number is displayed without mouse pointer and product price is updated)
    //7. Check 'add to cart' (Filed 'add to cart' is checked)
    //8. Click 'add to cart button'. (Shopping cart is opened, cart icon number is changed and product is displayed in a list)

    @Test
    public void verifyQuantityIsUpdatedAndProductAddedToCart () throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        Computers compPage = new Computers(driver);
        Products products = compPage.openNotebooksProductsFromDropdown();
        products.addToWishlist(driver, "Samsung Series 9 NP900X4C Premium Ultrabook");
        WishListPage wishListPage = products.goToWishlistFromNotification();
        wishListPage.changeProductQuantity("Samsung Series 9 NP900X4C Premium Ultrabook", "5");
        assert (wishListPage.getProductQuantityValue("Samsung Series 9 NP900X4C Premium Ultrabook").equals("5")): "Number of products is not right.";
        wishListPage.checkAddToCart("Samsung Series 9 NP900X4C Premium Ultrabook");
        CartPage cart = wishListPage.addToCartFromWishlist();
        assert cart.pageTitleText().equals("Shopping cart");
        assert cart.cartIcon().contains("5");
        assert cart.getTitlesOfProductsInCart().contains("Samsung Series 9 NP900X4C Premium Ultrabook"): wishListPage.getTitlesOfProductsInWishlist();
    }


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
        products.addToWishlist(driver, "Samsung Series 9 NP900X4C Premium Ultrabook");
        WishListPage wishListPage = products.goToWishlistFromNotification();
        wishListPage.addToCartFromWishlist();
        assert wishListPage.notificationText().equals("No products selected to add to cart.");
        wishListPage.closeNotification();
        assert !(wishListPage.isElementPresent(wishListPage.getWishListButton())): "Notification is still open";


    }



}
