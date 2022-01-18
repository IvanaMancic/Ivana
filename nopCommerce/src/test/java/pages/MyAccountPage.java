package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy (xpath = "//div[@class='page-title']")
    private WebElement pageTitleContainer;


    public MyAccountPage(ChromeDriver driver) {
        super(driver);
    }

    public WebElement getPageTitleContainer() {
        return pageTitleContainer;
    }

    public String getMyAccountNameText () {
        String firstNameXPath = "//label[text() ='First name:']//following-sibling::input";
        return driver.findElement(By.xpath(firstNameXPath)).getAttribute("value");
    }

    public String getMyAccountLastNameText() {
        String firstNameXPath = "//label[text() ='Last name:']//following-sibling::input";
        return driver.findElement(By.xpath(firstNameXPath)).getAttribute("value");
    }




}
