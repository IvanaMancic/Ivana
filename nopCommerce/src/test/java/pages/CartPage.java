package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

public class CartPage extends Products {

    @FindBy(xpath = "//div[@class='page-title']/h1")
    private WebElement pageTitle;

    public CartPage(ChromeDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        String text = pageTitle.getText();
        return text;
    }

    public ArrayList<WebElement> getListOfProductsInCart() {
        ArrayList<WebElement> listOfProductsInCart = (ArrayList<WebElement>) driver.findElementsByXPath
                ("//tbody//child::tr//td[@class='product']");
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

    public Double countTotalPrice(String productName, double quantity) throws ParseException {
        String unitPriceString = new String();
        for (WebElement product : getListOfProductsInCart()) {
            if (product.getText().contains(productName)) {
                String price1 = product.findElement
                        (By.xpath("//parent::tr//span[@class='product-unit-price']")).getText();
                unitPriceString = price1.substring(1, price1.length() - 3);
            }
        }
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        Number number = format.parse(unitPriceString);
        double unitPrice = number.doubleValue();
//        System.out.println(unitPrice);

        double totalPrice = unitPrice * quantity;
        System.out.println("Total price we count is: " + totalPrice);

        return totalPrice;
    }

    public Double getTotalPrice (String productName) throws ParseException {
        String totalPriceString = new String();
        for (WebElement product : getListOfProductsInCart()) {
            if (product.getText().contains(productName)) {
                String price1 = product.findElement(By.xpath("//parent::tr//span[@class='product-subtotal']")).getText();
                totalPriceString = price1.substring(1, price1.length() - 3);
            }
        }
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        Number number = format.parse(totalPriceString);
        double totalPrice = number.doubleValue();
        System.out.println("Total price we get from WebElement is: " + totalPrice);

        return totalPrice;

    }

    public void deleteProductFromCart(String productName) throws InterruptedException {
        String removeButton = "//parent::tr//button[@class='remove-btn']";
        for (int i=0; i<getListOfProductsInCart().size(); i++) {
            if (getListOfProductsInCart().get(i).getText().contains(productName)) {
                getListOfProductsInCart().get(i).findElement(By.xpath(removeButton)).click();
            }
        }
    }

    public void deleteAllFromCart() {
        String removeButton = "//parent::tr//button[@class='remove-btn']";

        for (int i=0; i<getListOfProductsInCart().size(); i++) {
            getListOfProductsInCart().get(i).findElement(By.xpath(removeButton)).click();        }
    }





}