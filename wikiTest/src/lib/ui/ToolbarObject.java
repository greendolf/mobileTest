package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ToolbarObject extends MainPageObject {

    public static final String
    TOOLBAR_ELEMENT = "//*[@id='page_toolbar_button_show_overflow_menu']";

    public ToolbarObject(AppiumDriver driver) {
        super(driver);
    }

    public void openToolbar() {
        this.waitForElementAndClick(By.xpath(TOOLBAR_ELEMENT), "Невозможно отрыть " +
                "тулбар", 5);
    }
}
