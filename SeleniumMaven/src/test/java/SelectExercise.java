import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectExercise extends TestAddToCart {

    @Test
    public void checkSortingButton () throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        loginToHomePage(driver);
        List<WebElement> products =  driver.findElementsByXPath("//*[contains (@class, 'inventory_item_description')]");

        String firstElementOfUnsortedList = products.get(0).findElement(By.className("inventory_item_price")).getText();
        WebElement sortButton = driver.findElementByClassName("product_sort_container");
        Select sort = new Select(sortButton);
        sort.selectByValue("hilo");
        Thread.sleep(10000);
        products =  driver.findElementsByXPath("//*[contains (@class, 'inventory_item_description')]");
        String firstElementOfSortedList = products.get(0).findElement(By.className("inventory_item_price")).getText();
//        System.out.println(firstElementOfSortedList + firstElementOfUnsortedList);
        Assert.assertFalse("When list is unsorted, the first price is: " + firstElementOfUnsortedList + " and when the list is sorted by higher price, the first price is: " + firstElementOfSortedList,firstElementOfSortedList.equals(firstElementOfUnsortedList));
    }
}
