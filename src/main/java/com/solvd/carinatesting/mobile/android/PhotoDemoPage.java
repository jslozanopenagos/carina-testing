package com.solvd.carinatesting.mobile.android;

import com.solvd.carinatesting.mobile.common.PhotoDemoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PhotoDemoPageBase.class)
public class PhotoDemoPage extends PhotoDemoPageBase{
    @FindBy(xpath ="//android.widget.TextView[@text='Photo Library. Tap a photo!']")
    private ExtendedWebElement fixedTitle;

    @FindBy(xpath = "//android.widget.ImageView")
    private List<ExtendedWebElement> photoList;

    @FindBy(xpath ="//android.widget.Button[@resource-id='android:id/button1']")
    private ExtendedWebElement popUpOkButton;

    public PhotoDemoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return fixedTitle.isElementPresent(3);
    }

    @Override
    public int getItemsCount() {
        return photoList.size();
    }

    @Override
    public void selectRandomPhoto() {
        int size = photoList.size();

        if (size > 0) {
            int randomIndex = (int) (Math.random() * size);
            photoList.get(randomIndex).click();
        }
    }

    @Override
    public void clickPopUpOkButton(){
        if( isPopUpDisplayed()){
            popUpOkButton.click();
        } else {
            throw new RuntimeException("Pop Up Button is not displayed!");
        }
    }

    @Override
    public boolean isPopUpDisplayed(){
        return popUpOkButton.isElementPresent(3);
    }
}