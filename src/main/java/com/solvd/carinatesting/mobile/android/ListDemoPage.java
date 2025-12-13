package com.solvd.carinatesting.mobile.android;

import com.solvd.carinatesting.mobile.common.ListDemoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ListDemoPageBase.class)
public class ListDemoPage extends ListDemoPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='Check out these clouds']")
    private ExtendedWebElement fixedTitle;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='RNE__LISTITEM__padView']")
    private List<ExtendedWebElement> listItems;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private ExtendedWebElement okButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button3']")
    private ExtendedWebElement learnMoreAboutButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private ExtendedWebElement popUpOkButton;

    public ListDemoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return fixedTitle.isElementPresent(3);
    }

    @Override
    public int getItemsCount() {
        return listItems.size();
    }

    @Override
    public void clickRandomItem() {
        int size = listItems.size();

        if (size == 0) {
            throw new RuntimeException("List Demo page has no items!");
        }

        int randomIndex = new Random().nextInt(size);
        listItems.get(randomIndex).click();
    }

    @Override
    public void clickOkButton() {
        okButton.click();
    }

    @Override
    public void clickLearnMoreAboutButton(){
        learnMoreAboutButton.click();
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
