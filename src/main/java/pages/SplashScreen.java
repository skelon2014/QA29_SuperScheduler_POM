package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SplashScreen extends BaseScreen {

    public SplashScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/app_version_res']")
    MobileElement versionTextVew;

    public String getCurrentVersion() {
        return versionTextVew.getText();
    }

    //return object of class(page)
    public LoginScreen checkVersion(String version) {
        shouldHave(versionTextVew, version, 10);
        return new LoginScreen(driver);

    }
}
