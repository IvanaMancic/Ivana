package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class WishListPage extends Products {


    @FindBy(xpath = "//div[@class='share-info']/a")
    private WebElement wishlistShareButton;

    @FindBy(xpath = "//tbody//child::tr//input[@class='qty-input']")
    private WebElement productQuantityField;

    @FindBy(xpath = "//button[@class='button-2 update-wishlist-button']")
    private WebElement updateWishlistButton;

    @FindBy (xpath = "//button[@class = 'button-2 wishlist-add-to-cart-button']")
    private WebElement addToCart;



    public WishListPage(ChromeDriver driver) {
        super(driver);
    }


    public WebElement getWhislistShareButton() {
        return wishlistShareButton;
    }



    //wishlist methods


    public ArrayList<String> getTitlesOfProductsInWishlist() {

        ArrayList<String> products = new ArrayList<>();

        for (WebElement product : getListOfProductsInWishList()) {
            products.add(product.getText());
        }

        return products;
    }

    public void assertProductIsInTheWishlist(String productName) {
        if (getTitlesOfProductsInWishlist().contains(productName)) {
        } else {
            assert (getTitlesOfProductsInWishlist().contains(productName)) : " Product " + productName + " is not in the Wishlist. Products " + getTitlesOfProductsInWishlist() + " are in your list";
        }
    }

    public void assertAllProductsAreInWishlist() throws InterruptedException {
        ArrayList<String> products = new ArrayList<>();
        Products page = new Products(driver);
        for (WebElement product : page.getListOfProducts()) {
            products.add(product.getText());
        }
        Thread.sleep(3000);
        getWishListButton().click();

        assert products.equals(getTitlesOfProductsInWishlist()) : "Products in the list and Wishlist don't match. Products in the list are: " + products + " Products in the Wishlist are: " + getTitlesOfProductsInWishlist();
    }


    public void deleteAllFromWishlist() {
        String removeButton = "//parent::tr//button[@class='remove-btn']";
        for (WebElement product : getListOfProductsInWishList()) {
            product.findElement(By.xpath(removeButton)).click();
        }
    }

    public void deleteProductFromWishlist(String productName) {
        String removeButton = "//parent::tr//button[@class='remove-btn']";
        for (WebElement product : getListOfProductsInWishList()) {
            if (product.getText().contains(productName)) {
                product.findElement(By.xpath(removeButton)).click();
            }
        }
    }

    public String getWishlistShareLink() {
        System.out.println(getWhislistShareButton().getAttribute("href"));
        return getWhislistShareButton().getAttribute("href");
    }


    public void openWishlistShareLinkInNewTab() {
        String link = getWhislistShareButton().getAttribute("href");
        ;
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(link);
    }

    public void changeProductQuantity(String productName, String quantity) {
        for (WebElement product : getListOfProductsInWishList()) {
            if (product.getText().contains(productName)) {
                productQuantityField.clear();
                productQuantityField.sendKeys(quantity);
                updateWishlistButton.click();
            }
        }
    }

    public String getProductQuantityValue(String productName) {
        String value = new String();
        for (WebElement product : getListOfProductsInWishList()) {
            if (product.getText().contains(productName)) {
                value = product.findElement(By.xpath("//parent::tr//td[@class='quantity']/input")).getAttribute("value");

            }
        }
        return value;
    }

    public void checkAddToCart(String productName) {
        for (WebElement product : getListOfProductsInWishList()) {
            if (product.getText().contains(productName)) {
                product.findElement(By.xpath("//parent::tr//td[@class='add-to-cart']/input")).click();
            }
        }
    }

    public CartPage addToCartFromWishlist (){
        addToCart.click();
        return new CartPage(driver);
    }





}



