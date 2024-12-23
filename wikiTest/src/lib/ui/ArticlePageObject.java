package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticlePageObject extends MainPageObject {
    private static final String
        SAVE_BUTTON = "//*[@resource-id='org.wikipedia:id/page_save']",
        LIST_ADD_BUTTON = "//*[@id='snackbar_action' and @text='Добавить в список']",
        LIST_NAME_INPUT = "//*[@resource-id='org.wikipedia:id/text_input']",
        LIST_ACCEPT_BUTTON = "//*[@id='button1' and @text='ОК']",
        LIST_ADDED_TEXT = "//*[@id='snackbar_text' and contains(@text, 'перемещено в {SUBSTRING}')]",
        CHECK_LIST_BUTTON = "//*[@id='snackbar_action' and @text='Посмотреть список']";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void saveToReadings(String listName) {
        this.waitForElementAndClick(By.xpath(SAVE_BUTTON),
                "Невозможно нажать на кнопку сохранения",
                5);
        this.waitForElementAndClick(By.xpath(LIST_ADD_BUTTON),
                        "Невозможно нажать на кнопку добавления в список",
                5);
        this.waitForElementAndSendKeys(By.xpath(LIST_NAME_INPUT),
                listName,
                "Невозможно задать название списка",
                10);
        this.waitForElementAndClick(By.xpath(LIST_ACCEPT_BUTTON),
                "Невозможно подтвердить добавление в список",
                5);
        String listAddingResult = getListAddingResult(listName);
        this.waitForElementPresent(By.xpath(listAddingResult),
                "Невозможно найти сообщение, подтверждающее добавление статьи в список",
                5);
    }

    public void showList() {
        this.waitForElementAndClick(By.xpath(CHECK_LIST_BUTTON),
                "Невозможно найти кнопку просмотра списка", 5);
    }

    private static String getListAddingResult(String substring) {
        return LIST_ADDED_TEXT.replace("{SUBSTRING}", substring);
    }
}
