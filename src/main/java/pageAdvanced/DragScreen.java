package pageAdvanced;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class DragScreen extends BaseScreenADV{
    public DragScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/button']")

    List<MobileElement> list;

    MobileElement selectMinimal = list.get(0);
    MobileElement selectDraggable = list.get(1);
    MobileElement selectDraggOnLongPress = list.get(2);
    MobileElement selectDraggWithSection = list.get(3);
    MobileElement selectDraggUseOnCheck = list.get(4);
    MobileElement selectDraggLayOut = list.get(5);
    MobileElement selectDraggStraggered = list.get(6);


    @FindBy(xpath = "//*[@content-desc='Swipe']")
    MobileElement swipe;

    public DraggableBasicScreen selectDraggableBasic(){
        selectDraggable.click();
        return new DraggableBasicScreen(driver);
    }

    public SwipeScreen selectSwipe(){
        swipe.click();
        return new SwipeScreen(driver);
    }

}
