package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class SpecificProduct extends Products {

    @FindBy (xpath = "//button[@class='button-1 add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy (xpath ="//input[@aria-label='Enter a quantity']")
    private WebElement quantityField;

    @FindBy (xpath = "//a[contains (text(), 'Add your review')]")
    private WebElement addReviewButton;


    public SpecificProduct(ChromeDriver driver) {
        super(driver);
    }

    public void addToCart (){
        addToCartButton.click();
        waitUntilVisible(getNotification(), 5);

    }

    public void enterQuantity (String quantity){
        quantityField.clear();
        quantityField.sendKeys(quantity);
    }

    public void addReview (){
        addReviewButton.click();
    }
}
