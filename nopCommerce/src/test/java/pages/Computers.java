package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Computers extends Products {


    public Computers(ChromeDriver driver) {
        super(driver);
    }

    public ArrayList<WebElement> getComputerMenuList (){
        ArrayList<WebElement> computerMenuList = (ArrayList<WebElement>) driver.findElementsByXPath("//div[@class='item-grid']//h2");
        return computerMenuList;
    }


    public void chooseLabelFromComputerManu (ChromeDriver driver, HomePage.Computer item){
        for (int i=0; i<getComputerMenuList().size(); i++){
            getComputerMenuList().get(i).getText().contains(item.name());
            getComputerMenuList().get(i).click();
            break;
        }
    }

}
