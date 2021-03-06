package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;


public class Products extends BasePage {

    //sort and view

    @FindBy(xpath = "//select[@id='products-orderby']")
    private WebElement sortButton;

    @FindBy(xpath = "//select[@id='products-pagesize']")
    private WebElement displayButton;

    @FindBy(xpath = "//a[@title='Grid']")
    private WebElement gridView;

    @FindBy(xpath = "//a[@title='List']")
    private WebElement listView;

    //buttons

    @FindBy(xpath = "//button[@class='button-2 add-to-wishlist-button']")
    private WebElement addToWishlist;

    //notifications

    @FindBy(xpath = "//div[@class='bar-notification success']//a")
    private WebElement confirmingNotificationLink;

    @FindBy(xpath = "//span[@class='close']")
    private WebElement closeNotificationButton;

    @FindBy (xpath = "//p[@class='content']")
    private WebElement notification;


    public Products(ChromeDriver driver) {
        super(driver);
    }


    public WebElement getConfirmingNotificationLink() {
        return confirmingNotificationLink;
    }

    public WebElement getNotification() {
        return notification;
    }

//list of products for any page

    public ArrayList<WebElement> getListOfProducts() {
        ArrayList<WebElement> listOfProducts =
                (ArrayList<WebElement>) driver.findElementsByXPath
                        ("//div[@class='item-grid']//h2[@class='product-title']");
        return listOfProducts;
    }

    public ArrayList<String> getTitlesOfProducts() {

        ArrayList<String> products = new ArrayList<>();

        for (WebElement product : getListOfProducts()) {
            products.add(product.getText());
        }

        return products;
    }


//actions with products
    public void chooseProductFromList(ChromeDriver driver, String product) {
        for (int i = 0; i < getListOfProducts().size(); i++) {
            if (getListOfProducts().get(i).getText().contains(product)) {
                getListOfProducts().get(i).click();
                break;
            }
        }
    }

    public void sortProducts(String sortValue) {
        Select sort = new Select(sortButton);
        sort.selectByValue(sortValue);
    }

    public void displayProducts(String display) {
        Select sort = new Select(displayButton);
        sort.selectByValue(display);
    }

    public void chooseGridView() {
        gridView.click();
    }

    public void chooseListView() {
        listView.click();
    }


    public void addProductToCart(ChromeDriver driver, String productName) throws InterruptedException {
        Thread.sleep(5000);
        WebElement element = driver.findElementByXPath
                ("//a[contains (text(), '" + productName + "')]//parent::h2//parent::div//button[@class='button-2 product-box-add-to-cart-button']");
//found this to change click(), because I had ElementClickInterceptedException, it didn't work with waitUntilClickable
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickToCompareProduct(ChromeDriver driver, String productName) throws InterruptedException {
        Thread.sleep(5000);
        WebElement element = driver.findElementByXPath
                ("//a[contains (text(), '" + productName + "')]//parent::h2//parent::div//button[@class='button-2 add-to-compare-list-button']");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void addToWishlist(ChromeDriver driver, String productName) throws InterruptedException {
        Thread.sleep(3000);
        WebElement element = driver.findElementByXPath("//a[contains (text(), '" + productName + "')]//parent::h2//parent::div//button[@class='button-2 add-to-wishlist-button']");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        Thread.sleep(2000);

    }


    public void addAllProductsFromListToWishlist () throws InterruptedException {
        for (int i = 1; i < getListOfProducts().size(); i++) {
            String productName = getListOfProducts().get(i).getText();
            addToWishlist(driver, productName);
            closeNotification();
        }
    }

//notification methods

    public WishListPage goToWishlistFromNotification() throws InterruptedException {
        Thread.sleep(2000);
        confirmingNotificationLink.click();
        return new WishListPage(driver);
    }

    public String getNotificationText(){
        String message = notification.getText();
        return message;
    }

    public void closeNotification (){
        closeNotificationButton.click();
    }


    }








