import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class FirstTest extends CoreTestCase {
    public MainPageObject MainPageObject;

    public void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    /*
    Задача: тапнуть по поисковому полю, ввести "DNS", открыть найденную вкладку и сравнить текст
    описания заголовка статьи с ожидаемым.
    */
    @Test
    public void testSearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("DNS");
        SearchPageObject.waitForSearchResult("российская торговая сеть по продаже бытовой техники и электроники");
    }
}
