package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Cart {

    AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'cart_item_name')]")
    private AndroidElement first_product_title_in_cart;

    public String get_product_in_cart_text(){
        return first_product_title_in_cart.getText();
    }

    public Cart(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
