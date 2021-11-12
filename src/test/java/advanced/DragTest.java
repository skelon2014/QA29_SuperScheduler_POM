package advanced;

import advancedconfig.AdvancedConfig;
import org.testng.annotations.Test;
import pageAdvanced.DragScreen;

public class DragTest extends AdvancedConfig {

    @Test
    public void dragDownTest(){
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragDown();
    }

    @Test
    public void dragDownTestCount(){
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragDownCount(4);
    }

    @Test
    public void dragDownTestWindow(){
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragDownWindow();
    }

    @Test
    public void DragUpWindow(){
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragUp(5);

    }

}
