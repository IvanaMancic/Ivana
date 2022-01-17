package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.Computers;
import pages.Products;
import pages.WishListPage;

import java.text.ParseException;

public class WishlistUpdateQuantityAddToCart extends BaseTest {


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
    public void verifyQuantityIsUpdatedAndProductAddedToCartFromWishlist () throws InterruptedException, ParseException {
        ChromeDriver driver = new ChromeDriver();
        Computers compPage = new Computers(driver);
        Products products = compPage.openNotebooksProductsFromDropdown();
        products.addToWishlist(driver, productsData.getNotepad1());
        WishListPage wishListPage = products.goToWishlistFromNotification();
        wishListPage.changeProductQuantity(productsData.getNotepad1(), "5");
        assert (wishListPage.getProductQuantityValue(productsData.getNotepad1()).equals("5")): "Number of products is not right.";
        assert wishListPage.countTotalPrice(productsData.getNotepad1(), 5).equals(wishListPage.getTotalPrice(productsData.getNotepad1()));
        wishListPage.checkAddToCart(productsData.getNotepad1());
        CartPage cartPage = wishListPage.addToCartFromWishlist();
        assert cartPage.getPageTitle().equals(pageData.cartPageTitle);
        assert cartPage.cartIconIndex().equals("5");
        assert cartPage.getTitlesOfProductsInCart().contains(productsData.getNotepad1()): "Your product is not in Cart. Products in Cart are: " + cartPage.getTitlesOfProductsInCart();
        assert cartPage.countTotalPrice(productsData.getNotepad1(), 5).equals(cartPage.getTotalPrice(productsData.getNotepad1()));
    }

}
