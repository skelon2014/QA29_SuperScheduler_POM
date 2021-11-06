package scheduler;

import configuration.ConfigScheduler;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashScreen;

public class LoginTest extends ConfigScheduler {

    @Test
    public void loginTest(){
        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("skelon122@bk.ru")
                .fillPassword("Qwerty$4")
                .clickOnLogin()
                .skipWizard();
      //          .isFabAddPresent();
   //     Assert.assertTrue(isFabButtonPresent);
    //    System.out.println(isFabButtonPresent);
    }
}
