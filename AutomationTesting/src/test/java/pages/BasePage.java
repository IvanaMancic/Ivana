package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    public ChromeDriver driver;

    public BasePage (ChromeDriver driver) {
        this.driver = driver;
    }
}
