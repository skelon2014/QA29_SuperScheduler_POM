package advanced;

import advancedconfig.AdvancedConfig;
import org.testng.annotations.Test;
import pageAdvanced.DragScreen;

public class SwipeTest extends AdvancedConfig {
    @Test
    public void swipeTest() {
    new DragScreen(driver)
            .selectSwipe()
            .selectSwipeBasic()
            .swipeLeftToRight()
            .swipeRightToLeft();

    }
}
