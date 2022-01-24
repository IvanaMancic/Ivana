package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.text.ParseException;

public class ProductAddReviewUpdateQuantityAddToCart extends BaseTest {

/*This test should verify that:
    - review of chosen product is added to the review list
    - quantity for chosen product is updated
    - product with the right quantity is added to the Cart
    - The Cart icon is changed according to the quantity

Preconditions:
    - It is necessary that user is logged in to send review.
    - The Cart must be empty.

Steps to reproduce (expected results):
    1. Open home Page url (HomePage is opened)
    2. User Login with valid credentials (User is logged in)
    3, User chooses Computer label from main manu and clicks on it (Computer many with labels is opened)
    4. User chooses Notebook label from Computer manu (list of products is shown)
    5. User chooses a product from the list by clicking on it (Chosen product is displayed with its buttons)
    6. User enters the quantity (the number is shown)
    7. User clicks 'add to cart' button (The right confirming notification is displayed and Cart icon number increases)
    8. User closes the confirming notification on the cancel button (x) (The notification is closed)
    9. User sends the review (review is displayed in review page and user is navigated to it)
    10. User opens the Cart (Cart page is opened and the right quantity of chosen product is in it)

 */

    @Test
    public void verifyProductQuantityReviewAndAddToCart() throws InterruptedException, ParseException {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

//assert login and empty cart before continuing
        LoginPage loginPage = clickLoginButton(driver);
        loginPage.login(data.validEmail, data.validPassword);
        loginPage.assertLogin();

        CartPage cartPage = new CartPage(driver);
        if (homePage.getCartIconIndex().equals("0")) {}
        else {clickCartButton(driver);
                cartPage.deleteAllFromCart();
                clickOnMainLogo(driver);}

//choose product
        homePage.chooseLabelAndActionFromMainManu(driver, HomePage.mainManuLabels.Computers, "click");
        Computers compPage = new Computers(driver);
        Products products = compPage.chooseLabelFromComputerManu(driver, HomePage.Computers.Notebooks);
        products.chooseProductFromList(driver, data.notepad1);

//assert quantity is updated
        SpecificProduct product = new SpecificProduct(driver);
        product.enterQuantity("3");
        product.addToCart();
        assert products.notificationText().equals(data.confirmAddToCartMessage);
        assert products.getConfirmingNotificationLink().isEnabled();
        product.closeNotification();
        assert homePage.getCartIconIndex().equals("3");

//assert review is added
        product.addReview();
        ProductReview review = new ProductReview(driver);
        review.sendReview(data.reviewTitle, data.reviewText, data.reviewRating);
        Assert.assertEquals("Confirmation message isn't displayed.",
                review.getReviewAddedField().getText(), data.confirmReviewIsAdded);
//        System.out.println(review.getNewReviewField().getText());
        assert review.getNewReviewField().getText().contains(data.reviewText)
                && review.getNewReviewField().getText().contains(data.reviewTitle);

//assert the right product and quantity in the cart
        clickCartButton(driver);
        cartPage.assertProductIsInTheCart(data.notepad1);
        Assert.assertEquals("The price for this quantity is not right. It should be: "
                        + cartPage.countTotalPrice(data.notepad1, 3)
                        + "but it is: " + cartPage.getTotalPrice(data.notepad1),
                cartPage.getTotalPrice(data.notepad1),
                cartPage.countTotalPrice(data.notepad1, 3));


    }
}
