package pageAdvanced;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SwipeScreen extends BaseScreenADV{
    public SwipeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/button'][2]")
    MobileElement swipeBasic;

    public SwipeAbleBasicScreen selectSwipeBasic(){
        swipeBasic.click();
        return new SwipeAbleBasicScreen(driver);
    }
}
