package scheduler;

import configuration.ConfigScheduler;
import dto.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashScreen;

public class LoginTest extends ConfigScheduler {

    @Test
    public void loginTest() {
        int i = (int) (System.currentTimeMillis() / 3600 % 1000);
        boolean isFabPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("skelon" + i + "@bk.ru")
                .fillPassword("Qwerty$4")
                .clickOnLogin()
                .skipWizard()
                .isFabAddButtonPresent();
        Assert.assertTrue(isFabPresent);
        System.out.println(isFabPresent);
    }

    @Test
    public void LoginCredentialsTest() {
        int i = (int) (System.currentTimeMillis() / 3600 % 1000);
        Credentials user = Credentials.builder()
                .email("skelon" + i + "@bk.ru")
                .password("Qwerty$4").build();

        boolean isFabPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .loginWithCredentials(user)
                .skipWizard()
                .isFabAddButtonPresent();
        Assert.assertTrue(isFabPresent);
        System.out.println(isFabPresent);
    }

    @Test
    public void loginLogoutTestWithCredentials() {
        int i = (int) (System.currentTimeMillis() / 3600 % 1000);
        Credentials user = Credentials.builder()
                .email("skelon" + i + "@bk.ru")
                .password("Qwerty$4").build();

        boolean isLoginPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .loginWithCredentials(user)
                .skipWizard()
                .openMenu()
                .logout()
                .isLoginButtonPresent();
        Assert.assertTrue(isLoginPresent);
        System.out.println(isLoginPresent);
    }

    @Test
    public void loginNegativeTest() {
        Credentials user = Credentials.builder()
                .email("skelon@bk.ru")
                .password("Qwerty4$4").build();

        String errorMessage = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillForm(user)
                .errorLogin()
                .errorMessage();
        Assert.assertEquals(errorMessage, "Wrong email or password");
    }
}
