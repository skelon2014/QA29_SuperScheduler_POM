package pageAdvanced;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraggableBasicScreen extends BaseScreenADV{
    public DraggableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/drag_handle']")
    List<MobileElement> list;

    public DraggableBasicScreen dragDown(){
        MobileElement element = list.get(0);
        Dimension window = driver.manage().window().getSize();
        System.out.println("Size of window - " + window.getWidth() +" --- " + window.getHeight());
        Rectangle rect = element.getRect();
        System.out.println(rect);
      //  rect.getX();
      //  rect.getY();
      //  rect.getHeight();
      //  rect.getWidth();

        int xFrom = rect.getX() + rect.getWidth()/2;
        int yFrom = rect.getY() + rect.getHeight()/2;

        int xTo = xFrom;
        int yTo = yFrom + rect.getHeight();

        TouchAction <?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,yFrom))
                .moveTo(PointOption.point(xTo,yTo))
                .release()
                .perform();

        return this;
    }

    public DraggableBasicScreen dragDownCount(int count){

        MobileElement element = list.get(0);
        Dimension window = driver.manage().window().getSize();
        System.out.println("Size of window - " + window.getWidth() +" --- " + window.getHeight());
        Rectangle rect = element.getRect();

        int xFrom = rect.getX() + rect.getWidth()/2;
        int yFrom = rect.getY() + rect.getHeight()/2;

        int xTo = xFrom;
        int yTo = yFrom + rect.getHeight() * count;

        TouchAction <?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,yFrom))
                .moveTo(PointOption.point(xTo,yTo))
                .release()
                .perform();

        return this;
    }

    public DraggableBasicScreen dragDownWindow() {
        MobileElement element = list.get(0);
        Dimension window = driver.manage().window().getSize();
        System.out.println("Size of window - " + window.getWidth() +" --- " + window.getHeight());
        Rectangle rect = element.getRect();

        int xFrom = rect.getX() + rect.getWidth()/2;
        int yFrom = rect.getY() + rect.getHeight()/2;

        int xTo = xFrom;
        int yTo =  window.getHeight() - rect.getY()/2;

        TouchAction <?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,yFrom))
                .moveTo(PointOption.point(xTo,yTo))
                .release()
                .perform();

        return this;
    }

    public DraggableBasicScreen dragUp(int index){
        MobileElement element = list.get(index);
        TouchAction<?>touchAction = new TouchAction<>(driver);
        Rectangle rect = element.getRect();

        int xFrom = rect.getX() + rect.getWidth()/2;
        int yFrom = rect.getY() + rect.getHeight()/2;

        int xTo = xFrom;
        int yTo = yFrom - rect.getHeight() * index;

        touchAction.longPress(PointOption.point(xFrom,yFrom))
                .moveTo(PointOption.point(xTo,yTo))
                .release().perform();
        return this;
    }
}
