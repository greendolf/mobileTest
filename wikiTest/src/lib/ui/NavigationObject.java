package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationObject extends MainPageObject{

    public final static String
            BACK_BUTTON = "//*[@contentDescription='Перейти вверх']";

    public NavigationObject(AppiumDriver driver) {
        super(driver);
    }

    public void back() {
        this.waitForElementAndClick(
                By.xpath(BACK_BUTTON),
                "Не удалось нажать \"Назад\"",
                4);
    }

}