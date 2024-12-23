package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ReadingsPageObject extends MainPageObject {
    private static final String
        LIST_ELEMENT = "//*[@id='page_list_item_title' and @text='{SUBSTRING}']",
        TOOLBAR_ELEMENT = "//*[@id='item_overflow_menu' and @contentDescription='Ещё']",
        DELETE_LIST_BUTTON = "//*[@id='title' and @text='Удалить список']",
        DELETE_ACCEPT_BUTTON = "//*[@class='android.widget.Button' and @text='ОК']",
        LIST_NAME_ELEMENT = "//*[@id='item_title' and @text='{SUBSTRING}']";

    public ReadingsPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void findListElement(String elementName) {
        String listElement = getListElement(elementName);
        this.waitForElementPresent(By.xpath(listElement),
                "Не удаётся найти элемент в списке", 5);
    }

    public void clearList(String listName) {
        this.waitForElementAndClick(By.xpath(TOOLBAR_ELEMENT),
                "Невозможно нажать на кнопку тулбара", 5);
        this.waitForElementAndClick(By.xpath(DELETE_LIST_BUTTON),
                "Невозможно нажать на кнопку удаления списка", 5);
        this.waitForElementAndClick(By.xpath(DELETE_ACCEPT_BUTTON),
                "Невозможно подтвердить удаление списка", 5);
        String listNameElement = getListNameElement(listName);
        this.waitForElementToDisappear(By.xpath(listNameElement),
                "Список удалось найти", 5);
    }

    private static String getListNameElement(String substring) {
        return LIST_NAME_ELEMENT.replace("{SUBSTRING}", substring);
    }

    private static String getListElement(String substring) {
        return LIST_ELEMENT.replace("{SUBSTRING}", substring);
    }
}
