package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

    public void chooseProductFromList (ChromeDriver driver, ArrayList<WebElement> list, String product){
        for (int i=0; i<list.size(); i++){
           if (list.get(i).getText().contains(product)){
            list.get(i).click();
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

    public void addProductToCart (ChromeDriver driver, String productName){
    WebElement element = driver.findElementByXPath("//a[contains (text(), '" + productName + "')]//parent::h2//parent::div//button[@class='button-2 product-box-add-to-cart-button']");
        element.click();
    }


}
