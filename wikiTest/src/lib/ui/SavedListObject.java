package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SavedListObject extends MainPageObject {

    public static final String
            ADD_TO_BOOKMARK_ELEMENT = "//*[@text='Сохранить']",
            ADD_TO_LIST_BUTTON = "//*[@text='Добавить в список']",
            CREATE_NEW_LIST_BUTTON = "//*[@text='Создать новый']",
            MOVE_TO_ANOTHER_LIST = "//*[@text='Перенести из Сохранённое в другой список для чтения']",
            LIST_NAME_ELEMENT = "//*[@id='text_input']",
            OPEN_LISTS_ELEMENT = "//*[@id='nav_tab_reading_lists']",
            DEFINED_LIST_ELEMENT = "//*[@class='android.view.ViewGroup' and ./*[@id='item_title_container' and ./*[@text='SUBSTRING']]]",
            TOOLBAR_AT_SAVED_LIST = "//*[@id='item_overflow_menu']",
            DELETE_LIST_ELEMENT = "//*[@id='content' and ./*[./*[@text='Удалить список']]]",
            CONFIRM_DELETION_ELEMENT = "//*[@text='ОК']",
            CREATE_LIST_BUTTON = "//*[@text='ОК']";

    public SavedListObject(AppiumDriver driver) {
        super(driver);
    }

    public void addToList(String listName) {
        this.waitForElementAndClick(By.xpath(ADD_TO_BOOKMARK_ELEMENT), "Не удалось нажать \"Сохранить\"", 5);
        this.waitForElementAndClick(By.xpath(ADD_TO_BOOKMARK_ELEMENT), "Не удалось нажать \"Сохранить\"", 5);

        try {
            this.waitForElementAndClick(By.xpath(MOVE_TO_ANOTHER_LIST), "Не найдена кнопка перемещения в новый список", 10);
        } catch (Exception ignored) {
        }

        this.waitForElementAndClick(By.xpath(CREATE_NEW_LIST_BUTTON), "", 10);
        this.waitForElementAndSendKeys(By.xpath(LIST_NAME_ELEMENT), listName, "Не удалось ввести имя списка", 10);
        this.waitForElementAndClick(By.xpath(CREATE_LIST_BUTTON), "Не удалось нажать \"ОК\"", 5);
    }

    private static String substituteListName(String listName) {
        return DEFINED_LIST_ELEMENT.replace("SUBSTRING", listName);
    }

    public void openLists() {
        this.waitForElementAndClick(By.xpath(OPEN_LISTS_ELEMENT), "Не удалось нажать \"Сохраненные\"", 5);
    }


    public void openList(String listName) {
        String listElement = substituteListName(listName);
        this.waitForElementAndClick(By.xpath(listElement), "Не удалось нажать на список", 5);
    }

    public void deleteList() {
        this.waitForElementAndClick(By.xpath(TOOLBAR_AT_SAVED_LIST), "Не удалось нажать на \"...\"", 5);
        this.waitForElementAndClick(By.xpath(DELETE_LIST_ELEMENT), "Не удалось нажать на \"Удалить список\"", 5);
        this.waitForElementAndClick(By.xpath(CONFIRM_DELETION_ELEMENT), "Не удалось нажать на \"ОК\"", 5);
    }

    public boolean isListPresent(String listName) {

        String listElement = substituteListName(listName);
        try {
            this.waitForElementPresent(By.xpath(listElement), "Не удалось нажать на список", 5);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}