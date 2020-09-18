package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Search {

    public static AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'search_title')]")
    private AndroidElement search_tap_to_activate;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'search_src_text')]")
    private AndroidElement search_field;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Изображение продукта\"]")
    private AndroidElement first_search_result_img;

    public void submit_search(String text){
        search_tap_to_activate.click();
        search_field.sendKeys(text);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void click_first_product_img() {
        first_search_result_img.click();
    }

    public Search(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
