package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class HomePage extends BasePage {


    private String homePageUrl = "https://demo.nopcommerce.com/";

    @FindBy (xpath = "//div[@class='topic-block-title']/h2")
    private WebElement homePageTitleField;

    public HomePage(ChromeDriver driver) {
        super(driver);
        driver.get(homePageUrl);
    }

    public String getPageTitle (){
        return homePageTitleField.getText();
    }

    public ArrayList<WebElement> getMainManuList (){
        ArrayList <WebElement> mainManuList = (ArrayList<WebElement>) driver.findElementsByXPath("//ul[@class='top-menu notmobile']/li");
        return mainManuList;
    }

    public enum mainManuLabels {

        Computers("Computers"),
        Electronics("Electronics"),
        Apparel("Apparel"),
        DigitalDownloads("Digital downloads"),
        Books("Books"),
        Jewelry("Jewelry"),
        GiftCards("Gift cards");

        public String label;

        mainManuLabels(String label)  {
            this.label = label;
                }

    }

    public enum Computers {
        Desktops,
        Notebooks,
        Software;
    }

    public enum Electronics {
        Camera,
        Cell,
        Others;
    }

    public enum Apparel {
        Shoes,
        Clothes,
        Accessories;
    }




//This method finds main manu label and clicks or hover on it
    //1. parameter is driver
    //2. parameter is label (choose form HomePage enum mainManuLabels)
    //3. parameter is String "hover" or "click" (type)

    public void chooseLabelAndActionFromMainManu(ChromeDriver driver, HomePage.mainManuLabels item, String hoverClick) {

        for (int i = 0; i < getMainManuList().size(); i++) {
           if (getMainManuList().get(i).getText().contains(item.label)) {
                 switch (hoverClick) {
                        case "hover":
                            Actions action = new Actions(driver);
                            action.moveToElement(getMainManuList().get(i)).build().perform();
                            break;
                        case "click":
                            getMainManuList().get(i).click();
                            break;
                        default:
                            System.out.println("Type 'hover' or 'click' as third parameter");


                    }
               break;
                }
            }
        }

//The method finds SUB item (from flying manu) and clicks or hover on it
    //1. parameter is driver
    //2. parameter is Computer sub label (choose from enum HomePage.Computer)
    //3. parameter is String "hover" or "click" (type)
// the same principle for Electronics and Apparel

    public void chooseComputerSubItemAndAction (ChromeDriver driver, HomePage.Computers subItem, String hoverClick) {

        for (int i = 0; i < getMainManuList().size(); i++) {
            if (getMainManuList().get(i).getText().contains(mainManuLabels.Computers.label)) {
                Actions action = new Actions(driver);
                action.moveToElement(getMainManuList().get(i)).build().perform();
                ArrayList<WebElement> subMenuList = (ArrayList<WebElement>) getMainManuList().get(i).findElements(By.xpath(".//ul[@class='sublist first-level']/li"));

                for (int j = 0; j < subMenuList.size(); j++) {
                    if (subMenuList.get(j).getText().contains(subItem.name())) {
                        switch (hoverClick) {
                            case "hover":
                                action.moveToElement(subMenuList.get(j)).build().perform();
                                break;
                            case "click":
                                subMenuList.get(j).click();
                                break;
                            default:
                                System.out.println("Type 'hover' or 'click'.");
                        }
                        break;
                    }

                }

            }
        }
    }



    public void chooseElectronicsSubItemAndAction (ChromeDriver driver, HomePage.Electronics subItem, String hoverClick) {
        for (int i = 0; i < getMainManuList().size(); i++) {
            if (getMainManuList().get(i).getText().contains(mainManuLabels.Electronics.label)) {
                    Actions action = new Actions(driver);
                    action.moveToElement(getMainManuList().get(i)).build().perform();
                    ArrayList <WebElement> subMenuList = (ArrayList<WebElement>) getMainManuList().get(i).findElements(By.xpath(".//ul[@class='sublist first-level']/li"));

                    for (int j= 0; j<subMenuList.size(); j++) {
                          if (subMenuList.get(j).getText().contains(subItem.name())){
                                switch (hoverClick){
                                    case "hover":
                                        action.moveToElement(subMenuList.get(j)).build().perform();
                                        break;
                                    case "click":
                                        subMenuList.get(j).click();
                                        break;
                                    default:
                                        System.out.println("Type 'hover' or 'click'.");
                                }
                                break;
                            }

                        }

                    }
                  }
                }


    public void chooseApperalSubItemAndAction (ChromeDriver driver, HomePage.Apparel subItem, String hoverClick) {
        for (int i = 0; i < getMainManuList().size(); i++) {
            if (getMainManuList().get(i).getText().contains(mainManuLabels.Apparel.label)) {
                Actions action = new Actions(driver);
                action.moveToElement(getMainManuList().get(i)).build().perform();
                ArrayList <WebElement> subMenuList = (ArrayList<WebElement>) getMainManuList().get(i).findElements(By.xpath(".//ul[@class='sublist first-level']/li"));

                for (int j= 0; j<subMenuList.size(); j++) {
                    if (subMenuList.get(j).getText().contains(subItem.name())){
                        switch (hoverClick){
                            case "hover":
                                action.moveToElement(subMenuList.get(j)).build().perform();
                                break;
                            case "click":
                                subMenuList.get(j).click();
                                break;
                            default:
                                System.out.println("Type 'hover' or 'click'.");
                        }
                        break;
                    }

                }

            }
        }
    }


}
