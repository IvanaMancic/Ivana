package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

public class WishListPage extends Products {

    @FindBy(xpath = "//div[@class='page-title']/h1")
    private WebElement wishlistTitleField;

    @FindBy(xpath = "//div[@class='share-info']/a")
    private WebElement wishlistShareButton;

    @FindBy(xpath = "//tbody//child::tr//input[@class='qty-input']")
    private WebElement productQuantityField;

    @FindBy(xpath = "//button[@class='button-2 update-wishlist-button']")
    private WebElement updateWishlistButton;

    @FindBy (xpath = "//button[@class = 'button-2 wishlist-add-to-cart-button']")
    private WebElement addToCart;

    @FindBy (xpath = "//div[@class='no-data']")
    private WebElement emptyWishlistNotification;



    public WishListPage(ChromeDriver driver) {
        super(driver);
    }


    public WebElement getWhislistShareButton() {
        return wishlistShareButton;
    }

    public String getPageTitle (){
        return wishlistTitleField.getText();
    }


    public ArrayList<WebElement> getListOfProductsInWishList (){
        ArrayList<WebElement> listOfProductsInWishlist = (ArrayList<WebElement>) driver.findElementsByXPath
                ("//tbody//child::tr//td[@class='product']");
        return listOfProductsInWishlist;
    }

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


    public void deleteAllFromWishlist() throws InterruptedException {
        String removeButton = "//parent::tr//button[@class='remove-btn']";
            do {
                getListOfProductsInWishList().get(0).findElement(By.xpath(removeButton)).click();
            }
            while (!getListOfProductsInWishList().isEmpty());
        }


    public void deleteProductFromWishlist(String productName) throws InterruptedException {
        String removeButton = "//parent::tr//button[@class='remove-btn']";
        for (int i=0; i<getListOfProductsInWishList().size(); i++) {
               if (getListOfProductsInWishList().get(i).getText().contains(productName)) {
                  getListOfProductsInWishList().get(i).findElement(By.xpath(removeButton)).click();
               }
        }
    }

    public void openWishlistShareLinkInNewTab() {
        String link = getWhislistShareButton().getAttribute("href");
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

    public String getEmptyWishlistMessage (){
        return emptyWishlistNotification.getText();
    }

    public Double countTotalPrice(String productName, double quantity) throws ParseException {
        String unitPriceString = new String();
        for (WebElement product : getListOfProductsInWishList()) {
            if (product.getText().contains(productName)) {
                String price1 = product.findElement
                        (By.xpath("//parent::tr//span[@class='product-unit-price']")).getText();
                unitPriceString = price1.substring(1, price1.length() - 3);
            }
        }
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        Number number = format.parse(unitPriceString);
        double unitPrice = number.doubleValue();
//        System.out.println(unitPrice);

        double totalPrice = unitPrice * quantity;
        System.out.println("Total price we count is: " + totalPrice);

        return totalPrice;
    }

    public Double getTotalPrice (String productName) throws ParseException {
        String totalPriceString = new String();
        for (WebElement product : getListOfProductsInWishList()) {
            if (product.getText().contains(productName)) {
                String price1 = product.findElement(By.xpath("//parent::tr//span[@class='product-subtotal']")).getText();
                totalPriceString = price1.substring(1, price1.length() - 3);
            }
        }
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        Number number = format.parse(totalPriceString);
        double totalPrice = number.doubleValue();
        System.out.println("Total price we get from WebElement is: " + totalPrice);

        return totalPrice;

    }





}



