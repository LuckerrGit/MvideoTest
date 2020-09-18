package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'button2')]")
    private AndroidElement city_ok_btn;

    private AndroidElement get_city_radiobtn_xpath(String city_name){
        return (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='" + city_name + "']"));
    }

    public void approve_city(String city){
        this.city_ok_btn.click();
        get_city_radiobtn_xpath(city).click();
    }

    public MainPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
