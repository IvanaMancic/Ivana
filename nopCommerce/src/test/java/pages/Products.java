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


    @FindBy(xpath = "//select[@id='products-orderby']")
    private WebElement sortButton;


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

}
