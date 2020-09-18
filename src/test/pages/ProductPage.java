package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private static AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'product_add_to_cart')]")
    private AndroidElement add_to_cart_btn;

    public void add_first_product_to_cart(){
        add_to_cart_btn.click();
    }

    public ProductPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
