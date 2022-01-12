package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class CartPage extends BasePage {

    @FindBy (xpath = "//div[@class='page-title']/h1")
    private WebElement pageTitle;

    public CartPage(ChromeDriver driver) {
        super(driver);
    }

    public String pageTitleText(){
        String text = pageTitle.getText();
        return text;
    }

    public ArrayList<WebElement> getListOfProductsInCart (){
        ArrayList<WebElement> listOfProductsInCart = (ArrayList<WebElement>) driver.findElementsByXPath("//tbody//child::tr//td[@class='product']");
        return listOfProductsInCart;
    }

    public ArrayList<String> getTitlesOfProductsInCart() {

        ArrayList<String> products = new ArrayList<>();

        for (WebElement product : getListOfProductsInCart()) {
            products.add(product.getText());
        }

        return products;
    }

    public void assertProductIsInTheCart(String productName) {
        if (getTitlesOfProductsInCart().contains(productName)) {
        } else {
            assert (getTitlesOfProductsInCart().contains(productName)) : " Product " + productName + " is not in the Wishlist. Products " + getTitlesOfProductsInCart() + " are in your list";
        }
    }
}
