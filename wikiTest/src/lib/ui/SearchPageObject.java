package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPageObject extends MainPageObject {
    private static final String
    SEARCH_INIT_ELEMENT = "//*[@text='Поиск по Википедии']",
    SEARCH_INPUT = "//*[@id='search_src_text']",
    SEARCH_RESULT = "//*[@text='SUBSTRING']";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT),
                "Невозможно нажать на поле ввода", 15);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT),
                "Невозможно нажать на поле ввода", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line,
                "Невозможно нажать на поле ввода", 15);
    }

    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT.replace("SUBSTRING", substring);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath),
                "Невозможно найти " + substring, 15);
    }

    public void clickOnSearchResult(String substring) {
        String searchResultXpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(searchResultXpath), "Невозможно найти", 15);
    }
}
