package data;

public class NotificationData {


    private String confirmAddToWishlistMessage = "The product has been added to your wishlist";

    private String confirmAddToCartMessage = "The product has been added to your shopping cart";

    private String noProductsInWishlistToAddToCart = "No products selected to add to cart.";

    private String emptyWishlistMessageText = "The wishlist is empty!";

    private String confrimReviewIsAdded = "Product review is successfully added.";

    private String confirmRegistration = "Your registration completed";

    private String registrationError = "The specified email already exists";



    public String getConfirmAddToWishlistMessage() {
        return confirmAddToWishlistMessage;
    }

    public String getConfirmAddToCartMessage() {
        return confirmAddToCartMessage;
    }

    public String getNoProductsInWishlistToAddToCart() {
        return noProductsInWishlistToAddToCart;
    }

    public String getEmptyWishlistMessageText() {
        return emptyWishlistMessageText;
    }

    public String getConfrimReviewIsAdded() {
        return confrimReviewIsAdded;
    }

    public String getConfirmRegistration() {
        return confirmRegistration;
    }

    public String getRegistrationError() {
        return registrationError;
    }
}
