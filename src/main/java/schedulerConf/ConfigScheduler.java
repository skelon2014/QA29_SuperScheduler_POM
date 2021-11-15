package schedulerConf;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
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

public class ConfigScheduler {

    protected AppiumDriver<MobileElement> driver;

    Logger logger = LoggerFactory.getLogger(ConfigScheduler.class);

    @BeforeSuite
    public void setUP() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Nex5");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("app","C:/Users/Study/APK/v.0.0.3.apk");

        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      //  driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new AppiumListener());


        logger.info("Start superScheduler");
    }

    @AfterSuite
    public void tearDown() {
        logger.info("Stop SuperScheduler");
        driver.quit();
    }
    @BeforeMethod
    public void startLogger(Method m){
        logger.info("Start method -> " + m.getName());
    }
    @AfterMethod
    public void stopLogger(Method m){
        logger.info("Stop method -> " + m.getName());
    }
}
