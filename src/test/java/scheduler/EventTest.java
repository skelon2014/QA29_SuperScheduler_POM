package scheduler;

import schedulerConf.ConfigScheduler;
import schedulerConf.ListenTestNG;
import dto.Credentials;
import dto.Event;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pagesScheduler.HomeScreen;
import pagesScheduler.SplashScreen;

@Listeners(ListenTestNG.class)

public class EventTest extends ConfigScheduler {
    @BeforeMethod
    public void Precondition() {
       new SplashScreen(driver)
       .checkVersion("0.0.3")
       .loginWithCredentials(Credentials.builder()
               .email("skelon@bk.ru")
               .password("Qwerty$4")
               .build())
               .skipWizard()
               .isFabAddButtonPresent();
    }
    @Test
    public void eventCreationTest(){
     boolean isFabPresent =  new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("New event")
                        .type("event")
                        .breaks(3)
                        .ammount(40).build())
                        .isFabAddButtonPresent();
        Assert.assertTrue(isFabPresent);

    }
}
