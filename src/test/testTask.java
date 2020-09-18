import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class testTask {

    public static AndroidDriver driver;

    private ToolBar toolbar;
    private MainPage mainPage;
    private Search search;
    private ProductPage productPage;
    private Cart cartPage;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","pixel2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("appPackage", "ru.filit.mvideo.b2c");
        capabilities.setCapability("appActivity", "ru.filit.mvideo.b2c.ui.main.view.MainActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        mainPage = new MainPage(driver);
        search = new Search(driver);
        productPage = new ProductPage(driver);
        cartPage = new Cart(driver);
        toolbar = new ToolBar(driver);
    }

    @Test
    public void Search_product_and_add_to_card() {
        mainPage.approve_city("Москва");
        search.submit_search("10010788");
        search.click_first_product_img();
        productPage.add_first_product_to_cart();
        toolbar.navigate_to_cart();
        assert cartPage.get_product_in_cart_text().equals("Видеокамера экшн Sony HDR-AS300R/W");
    }

    @After
    public void teardown() { driver.quit(); }

}