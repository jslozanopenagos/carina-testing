package com.solvd.carinatesting.mobile.android;

import com.solvd.carinatesting.mobile.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(xpath = "//android.widget.TextView[@text='TheApp']")
    private ExtendedWebElement appLogo;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='listItemTitle' and @text='Echo Box']")
    private ExtendedWebElement echoBoxButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='listItemTitle' and @text='Login Screen']")
    private ExtendedWebElement loginScreenButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='listItemTitle' and @text='Clipboard Demo']")
    private ExtendedWebElement clipboardDemoButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='listItemTitle' and @text='Webview Demo']")
    private ExtendedWebElement webviewDemoButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='listItemTitle' and @text='Dual Webview Demo']")
    private ExtendedWebElement dualWindowDemoButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='listItemTitle' and @text='List Demo']")
    private ExtendedWebElement listDemoButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='listItemTitle' and @text='Photo Demo']")
    private ExtendedWebElement photoDemoButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='listItemTitle' and @text='Geolocation Demo']")
    private ExtendedWebElement geolocationDemoButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='listItemTitle' and @text='Picker Demo']")
    private ExtendedWebElement pickerDemoButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='listItemTitle' and @text='Verify Phone Number']")
    private ExtendedWebElement verifyPhoneNumberButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return appLogo.isElementPresent(5);
    }

    @Override
    public void openEchoBox() {
        echoBoxButton.click();
    }

    @Override
    public void openLoginScreen() {
        loginScreenButton.click();
    }

    @Override
    public void openClipboardDemo() {
        clipboardDemoButton.click();
    }

    @Override
    public void openWebviewDemo() {
        webviewDemoButton.click();
    }

    @Override
    public void openDualWindowDemo() {
        dualWindowDemoButton.click();
    }

    @Override
    public void openListDemo() {
        listDemoButton.click();
    }

    @Override
    public void openPhotoDemo() {
        photoDemoButton.click();
    }

    @Override
    public void openGeolocationDemo() {
        geolocationDemoButton.click();
    }

    @Override
    public void openPickerDemo() {
        pickerDemoButton.click();
    }

    @Override
    public void openVerifyPhoneNumber() {
        verifyPhoneNumberButton.click();
    }
}
