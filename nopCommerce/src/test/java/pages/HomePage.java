package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends BasePage {

    private String homePageUrl = "https://demo.nopcommerce.com/";

    public HomePage(ChromeDriver driver) {
        super(driver);
        driver.get(homePageUrl);
    }


}
