package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ToolBar {
    AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Корзина\"]")
    private AndroidElement navigate_to_cart_btn;

    public void navigate_to_cart(){
        navigate_to_cart_btn.click();
    }

    public ToolBar(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
