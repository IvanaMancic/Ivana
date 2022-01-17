package data;

public class NotificationData {


    String confirmAddToCartMessage = "The product has been added to your wishlist";
    String noProductsInWishlistToAddToCart = "No products selected to add to cart.";



    String emptyWishlistMessageText = "The wishlist is empty!";

    public String getConfirmAddToCartMessage() {
        return confirmAddToCartMessage;
    }

    public String getNoProductsInWishlistToAddToCart() {
        return noProductsInWishlistToAddToCart;
    }

    public String getEmptyWishlistMessageText() {
        return emptyWishlistMessageText;
    }
}
