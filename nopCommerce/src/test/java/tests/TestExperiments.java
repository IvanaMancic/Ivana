package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class TestExperiments extends BaseTest{

    @Test
    public void ClickOnMainLogo (){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        clickRegisterButton(driver);
        clickLoginButton(driver);
        clickOnMainLogo(driver);

    }


}
