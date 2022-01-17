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

    public Products chooseLabelFromComputerManu (ChromeDriver driver, HomePage.Computers item){
        for (int i=0; i<getComputerMenuList().size(); i++){
            if (getComputerMenuList().get(i).getText().contains(item.name())) {
                getComputerMenuList().get(i).click();
                break;}
        }
        return new Products(driver);
    }

    public Products openNotebooksProductsFromDropdown(){
        HomePage homePage = new HomePage(driver);
        homePage.chooseComputerSubItemAndAction(driver, HomePage.Computers.Notebooks, "click");
        return new Products(driver);
    }

    public Products openDesktopsProductsFromDropdown() {
        HomePage homePage = new HomePage(driver);
        homePage.chooseComputerSubItemAndAction(driver, HomePage.Computers.Desktops, "click");
        return new Products(driver);
    }

    public Products openSoftwareProductsFromDropdown() {
        HomePage homePage = new HomePage(driver);
        homePage.chooseComputerSubItemAndAction(driver, HomePage.Computers.Software, "click");
        return new Products(driver);
    }

}
