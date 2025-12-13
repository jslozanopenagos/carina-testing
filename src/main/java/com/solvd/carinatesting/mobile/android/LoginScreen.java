package com.solvd.carinatesting.mobile.android;

import com.solvd.carinatesting.mobile.common.LoginScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginScreenBase.class)
public class LoginScreen extends LoginScreenBase {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='username']")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//android.widget.Button[@content-desc='loginBtn']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/message\"]")
    private ExtendedWebElement errorMessage;

    public LoginScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return usernameField.isElementPresent(5);
    }

    @Override
    public void typeUsername(String username) {
        usernameField.type(username);
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password);
    }

    @Override
    public void tapLoginButton() {
        loginButton.click();
    }

    public boolean isErrorMessagePresent() {
        return errorMessage.isElementPresent();
    }
}