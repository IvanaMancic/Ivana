package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class Desktops extends Computers {



    public Desktops(ChromeDriver driver) {
        super(driver);
    }

    public ArrayList<WebElement> getListOfDesktopProducts() {
        ArrayList<WebElement> listOfDesktopProducts = (ArrayList<WebElement>) driver.findElementsByXPath("//div[@class='item-grid']//h2[@class='product-title']");
        return listOfDesktopProducts;
    }


}
