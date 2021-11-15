package advancedconfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AdvancedConfig {
    protected AppiumDriver<MobileElement> driver;

    Logger logger = LoggerFactory.getLogger(AdvancedConfig.class);

    @BeforeSuite
    public void setUP() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Nex5");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability("appPackage", "com.h6ah4i.android.example.advrecyclerview");
        capabilities.setCapability("appActivity", ".launcher.MainActivity");
        capabilities.setCapability("automationName","Appium");

        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        // driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver,new AppiumListener());

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        logger.info("Start advanced");

    }

    @AfterSuite
    public void tearDown() {
        //driver.quit();
    }
    @BeforeMethod
    public void startLogger(Method m){
        logger.info("Start method" + m.getName());
    }
    @AfterMethod
    public void stopLogger(Method m){
        logger.info("Stop method" + m.getName());
    }
}
