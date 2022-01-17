package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class ProductAddReviewUpdateQuantityAddToCart extends BaseTest {

//This test should verify that:
    //review of chosen product is added to the review list
    //quantity for chosen product is updated in the Wishlist
    //Wishlist icon is changed according to the quantity
    //product with the right quantity is added to Cart
    //Cart icon is changed according to the quantity

// It is necessary that user is logged in to send review.

//Steps to reproduce (expected results):
    //1. Open home Page url (HomePage is opened)
    //2. User Login with valid credentials (User is logged in)
    //3, User chooses VComputer label from main manu and clicks on it (Computer many with labels is opened)
    //4. User chooses Notebook label from Computer manu (list of products is shown)
    //5. User chooses a product from the list by clicking on it (Chosen product is displayed with its buttons)
    //6. User enters the quantity (the number is shown)
    //7. User clicks add to cart button (The right confirming notification is displayed and Cart icon number increases)
    //8. User closes the confirming notification on the cancel button (x) (The notification is closed)
    //8. User sends the review (review is displayed in review page and user is navigated to it)
    //9. User opens the Cart (Cart page is opened and the right quantity of chosen product is in it)

    @Test
    public void verifyQuantityAndReviewAreAddedAndAddedToCart() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = clickLoginButton(driver);
        loginPage.login(contentData.getValidEmail(), contentData.getValidPassword());
        homePage.chooseLabelAndActionFromMainManu(driver, HomePage.mainManuLabels.Computers, "click");
        Computers compPage = new Computers(driver);
        Products products = compPage.chooseLabelFromComputerManu(driver, HomePage.Computers.Notebooks);
        products.chooseProductFromList(driver, productsData.getNotepad1());
        SpecificProduct product = new SpecificProduct(driver);
        product.enterQuantity("3");
        product.addToCart();
        Thread.sleep(2000);
        product.closeNotification();
        assert homePage.cartIconIndex().equals("3");
        product.addReview();
        ProductReview review = new ProductReview(driver);
        review.sendReview(contentData.getReviewTitle(), contentData.getReviewText(), contentData.getReviewRating());
        clickCartButton(driver);

    }
}
