import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WomanClothes {

    @Test
    public void sortTshirts () throws InterruptedException {
        String homeURL = "http://automationpractice.com/index.php";
        ChromeDriver driver = new ChromeDriver();
        driver.get(homeURL);
        WebElement womanMenu = driver.findElementByXPath("//a[@title=\"Women\"]");
        womanMenu.click();
        WebElement plusToOpenMenu = driver.findElementByXPath("//span[@class=\"grower CLOSE\"][1]");
        plusToOpenMenu.click();
        WebElement topButton = driver.findElementByXPath("//div[@class=\"block_content\"]//a[contains (@title, 'Choose from t-shirts')]");
        topButton.click();
        WebElement unorderedFirstTshirt = driver.findElementByXPath("//div[@class=\"right-block\"]//a[@title=\"Faded Short Sleeve T-shirts\"]");
        WebElement sortButton = driver.findElementById("selectProductSort");
        Select sort = new Select(sortButton);
        sort.selectByValue("price:desc");
//        Thread.sleep(10000);
//        WebElement orderedFirstTshirt = driver.findElementByXPath("//div[@class="right-block"]//a[@title="Blouse"]");


    }
}
