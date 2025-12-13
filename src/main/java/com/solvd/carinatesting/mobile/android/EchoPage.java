package com.solvd.carinatesting.mobile.android;

import com.solvd.carinatesting.mobile.common.EchoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = EchoPageBase.class)
public class EchoPage extends EchoPageBase {
    @FindBy(xpath = "//android.widget.EditText[@resource-id='messageInput']")
    private ExtendedWebElement messageInput;

    @FindBy(xpath = "//android.widget.Button[@resource-id='messageSaveBtn']")
    private ExtendedWebElement saveButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='savedMessage']")
    private ExtendedWebElement savedMessage;


    public EchoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return messageInput.isElementPresent(5);
    }

    @Override
    public void typeMessage(String message) {
        messageInput.type(message);
    }

    @Override
    public void tapEchoButton() {
        saveButton.click();
    }

    @Override
    public boolean isMessageDisplayed() {
        return savedMessage.isElementPresent(2);
    }
}

