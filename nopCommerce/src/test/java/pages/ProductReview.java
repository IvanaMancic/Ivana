package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class ProductReview extends SpecificProduct {

    @FindBy (id = "AddProductReview_Title")
    private WebElement reviewTitleField;

    @FindBy (id = "AddProductReview_ReviewText")
    private WebElement reviewTextField;

    @FindBy (xpath = "//button[@name='add-review']")
    private WebElement reviewSubmitButton;


    public ProductReview(ChromeDriver driver) {
        super(driver);
    }

    public ArrayList<WebElement> getRatings (){
        ArrayList<WebElement> ratings = (ArrayList<WebElement>) driver.findElementsByXPath("//div[@class='rating-options']//input");
        return ratings;

    }
    public void sendReview (String title, String text, String rating){
        reviewTitleField.sendKeys(title);
        reviewTextField.sendKeys(text);
        for (int i=0; i<getRatings().size(); i++){
            if (getRatings().get(i).getAttribute("value").contains(rating)){
                getRatings().get(i).click();
                break;
            }

        }
        reviewSubmitButton.click();
    }




}
