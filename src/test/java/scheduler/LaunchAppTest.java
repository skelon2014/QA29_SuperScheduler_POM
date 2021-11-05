package scheduler;

import configuration.ConfigScheduler;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashScreen;

public class LaunchAppTest extends ConfigScheduler {

    @Test
    public void launchTest(){
       String version = new SplashScreen(driver).getCurrentVersion();
        Assert.assertEquals(version,"0.0.3");
    }
}
