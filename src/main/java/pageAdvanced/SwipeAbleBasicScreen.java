package pageAdvanced;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SwipeAbleBasicScreen extends BaseScreenADV {
    public SwipeAbleBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='android:id/text1']")
    List<MobileElement> list;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement okButton;

    public SwipeAbleBasicScreen swipeLeftToRight() {
        MobileElement element = list.get(1);
        Rectangle rec = element.getRect();

        int xFrom = (int) (rec.getX() + rec.getWidth() * 0.3);
        int yFrom = (int) (rec.getY() + rec.getHeight()/2);

        int xTo = (int) (xFrom + rec.getWidth()*0.6);
        int yTo = yFrom;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,yFrom))
                .moveTo(PointOption.point(xTo,yTo))
                .release().perform();
        return this;
    }

    public SwipeAbleBasicScreen swipeRightToLeft() {
        MobileElement element = list.get(1);
        Rectangle rec = element.getRect();

        int xFrom = (int) (rec.getX() + rec.getWidth() * 0.8);
        int yFrom = (int) (rec.getY() + rec.getHeight()/2);

        int xTo = (int) (xFrom - rec.getWidth()*0.8);
        int yTo = yFrom;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,yFrom))
                .moveTo(PointOption.point(xTo,yTo))
                .release().perform();
        okButton.click();
        return this;
    }
}
