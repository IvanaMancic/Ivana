import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class SwitchToExercise {

    String windowsUrl = "https://demoqa.com/browser-windows";


    public ChromeDriver getDriverWithOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "disable-popup-blocking");
        ChromeDriver driver = new ChromeDriver(options);
        return driver;
    }

    public void openTheUrl(ChromeDriver driver, String url) {
        driver.get(url);
    }

    public void openNewTabAndGoToTheParentTab (ChromeDriver driver){
        WebElement tabButton = driver.findElementById("tabButton");
        tabButton.click();
        ArrayList <String> tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertTrue("It is expected that driver opens new tab 'https://demoqa.com/sample', but driver is on the page: " + driver.getCurrentUrl(), driver.findElementById("sampleHeading").getText().equals("This is a sample page"));
        driver.close();
        driver.switchTo().window(tabs.get(0));
//        return driver;
    }

    public void openNewWindowAndGoToTheParentWindow (ChromeDriver driver) throws InterruptedException {
        WebElement windowButton = driver.findElementById("windowButton");
        windowButton.click();
        String parentWindow = driver.getWindowHandle();
        ArrayList <String> windows = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        Thread.sleep(5000);
//        System.out.println(driver.findElementById("sampleHeading").getText());

        Assert.assertTrue("It is expected that driver opens new tab 'https://demoqa.com/sample', but driver is on the page: " + driver.getCurrentUrl(), driver.findElementById("sampleHeading").getText().equals("This is a sample page"));
        driver.close();
        driver.switchTo().window(parentWindow);
    }

    public void openNewWindowWithMessage (ChromeDriver driver) throws InterruptedException {
        WebElement windowMessageButton = driver.findElementById("messageWindowButton");
        windowMessageButton.click();
        String parentWindow = driver.getWindowHandle();
        ArrayList <String> windows = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        Thread.sleep(5000);

//        Assert.assertTrue("It is expected that driver opens new tab 'https://demoqa.com/sample', but driver is on the page: " + driver.getCurrentUrl(), driver.findElementByTagName("body").getText().equals("Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."));
        System.out.println(driver.findElementByTagName("body").getAttribute("inner HTML"));

        driver.close();
        driver.switchTo().window(parentWindow);
    }

    @Test
        public void openCloseTabWindowAndMessageWindow () throws InterruptedException {
        final ChromeDriver driver = getDriverWithOptions();
        openTheUrl(driver, windowsUrl);
        openNewTabAndGoToTheParentTab(driver);
        openNewWindowAndGoToTheParentWindow(driver);
        openNewWindowWithMessage(driver);

    }


}
