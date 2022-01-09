package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;


public class Products extends BasePage {

    private String sortValueAtoZ = "5";
    private String SortValueZtoA = "6";
    private String SortValueAsc = "10";
    private String SortValueDesc = "11";
    private String SortValueCreatedOn = "15";
    private String display3 = "3";
    private String display6 = "6";
    private String display9 = "9";



    @FindBy(xpath = "//select[@id='products-orderby']")
    private WebElement sortButton;

    @FindBy(xpath = "//select[@id='products-pagesize']")
    private WebElement displayButton;

    @FindBy(xpath = "//a[@title='Grid']")
    private WebElement gridView;

    @FindBy(xpath = "//a[@title='List']")
    private WebElement listView;


    public Products(ChromeDriver driver) {
        super(driver);
    }

    public String getSortValueAtoZ() {
        return sortValueAtoZ;
    }

    public String getSortValueZtoA() {
        return SortValueZtoA;
    }

    public String getSortValueAsc() {
        return SortValueAsc;
    }

    public String getSortValueDesc() {
        return SortValueDesc;
    }

    public String getSortValueCreatedOn() {
        return SortValueCreatedOn;
    }

    public String getDisplay3() {
        return display3;
    }

    public String getDisplay6() {
        return display6;
    }

    public String getDisplay9() {
        return display9;
    }

//list of products for any page

    public ArrayList<WebElement> getListOfProducts() {
        ArrayList<WebElement> listOfProducts = (ArrayList<WebElement>) driver.findElementsByXPath("//div[@class='item-grid']//h2[@class='product-title']");
        return listOfProducts;
    }



//actions with products
    public void chooseProductFromList (ChromeDriver driver, String product){
        for (int i=0; i<getListOfProducts().size(); i++){
           if (getListOfProducts().get(i).getText().contains(product)){
            getListOfProducts().get(i).click();
            break;
           }
        }
    }

    public void sortProducts (String value){
        Select sort = new Select(sortButton);
        sort.selectByValue(value);
    }

    public void displayProducts (String number){
        Select sort = new Select(displayButton);
        sort.selectByValue(number);
    }

    public void chooseGridView(){
        gridView.click();
    }

    public void chooseListView(){
        listView.click();
    }


    public void addProductToCart (ChromeDriver driver, String productName) throws InterruptedException {
        Thread.sleep(5000);
        WebElement element = driver.findElementByXPath("//a[contains (text(), '" + productName + "')]//parent::h2//parent::div//button[@class='button-2 product-box-add-to-cart-button']");
//found this to change click(), because I had ElementClickInterceptedException, it didn't work with waitUntilclickable
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickToCompareProduct (ChromeDriver driver, String productName) throws InterruptedException {
        Thread.sleep(5000);
        WebElement element = driver.findElementByXPath("//a[contains (text(), '" + productName + "')]//parent::h2//parent::div//button[@class='button-2 add-to-compare-list-button']");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void addToWishlist (ChromeDriver driver, String productName) throws InterruptedException {
        Thread.sleep(5000);
        WebElement element = driver.findElementByXPath("//a[contains (text(), '" + productName + "')]//parent::h2//parent::div//button[@class='button-2 add-to-wishlist-button']");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }


}
