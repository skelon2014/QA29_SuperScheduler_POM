package pages;

import dto.Credentials;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen extends BaseScreen {

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;

    @AndroidFindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMessage;

    public LoginScreen fillEmail(String email) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(emailEditText));
        type(emailEditText, email);
        return this;
    }

    public LoginScreen fillPassword(String password) {
        type(passwordEditText, password);
        return this;
    }

    public WizardScreen clickOnLogin() {
        hideKeyBoard();
        loginButton.click();
        return new WizardScreen(driver);
    }

    public WizardScreen loginWithCredentials(Credentials user) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(emailEditText));
        type(emailEditText, user.getEmail());
        type(passwordEditText, user.getPassword());
        hideKeyBoard();
        loginButton.click();
        return new WizardScreen(driver);

    }

    public boolean isLoginButtonPresent() {
        return loginButton.isDisplayed();
    }

    public LoginScreen fillForm(Credentials user) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(emailEditText));
        type(emailEditText, user.getEmail());
        type(passwordEditText, user.getPassword());
        return this;
    }

    public LoginScreen errorLogin() {
        hideKeyBoard();
        loginButton.click();
        return this;
    }

    public String errorMessage() {
        //should(errorMessage,10);
        return errorMessage.getText();
    }


}
