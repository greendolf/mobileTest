package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{
    private static final String
    SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Поиск по Википедии')]",
    SEARCH_INPUT = "//*[@resource-id='org.wikipedia:id/search_src_text']",
    SEARCH_RESULT = "//*[@id='page_list_item_description' and @text='{SUBSTRING}']";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT.replace("{SUBSTRING}", substring);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Невозможно нажать на поле ввода", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Невозможно ввести в текст", 10);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Невозможно найти " + substring, 5);
    }

    public void waitForSearchResultAndClick(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath),
                "Невозможно найти результат поиска", 5);
    }

}
