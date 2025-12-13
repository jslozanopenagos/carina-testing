package com.solvd.carinatesting.mobile.android;

import com.solvd.carinatesting.mobile.common.WebViewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='urlInput']")
    private ExtendedWebElement urlField;

    @FindBy(xpath = "//android.widget.Button[@content-desc='navigateBtn']")
    private ExtendedWebElement goUrlButton;

    @FindBy(xpath = "//android.webkit.WebView")
    private ExtendedWebElement webView;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/alertTitle']")
    private ExtendedWebElement alertTitle;

    @FindBy(xpath = "//android.widget.Button[@content-desc='clearBtn']")
    private ExtendedWebElement clearUrlButton;

    private static final String DEFAULT_URL = "https://appiumpro.com";

    public WebViewPage(WebDriver webDriver){
        super(webDriver);
    }

    @Override
    public boolean isPageOpened() {
        return urlField.isElementPresent(2);
    }

    @Override
    public void typeUrl(String text) {
        urlField.type(text);
    }

    @Override
    public void tapGoUrlButton(){
        goUrlButton.click();
    }

    @Override
    public boolean isWebAlertDisplayed(){
        return alertTitle.isElementPresent(5);
    }

    @Override
    public void tapClearButton(){
        clearUrlButton.click();
    }

    public boolean isUrlResetToDefault() {
        return urlField.getText().equals(DEFAULT_URL);
    }

    public boolean isUrlDifferentFrom(String value) {
        return !urlField.getText().equals(value);
    }
}