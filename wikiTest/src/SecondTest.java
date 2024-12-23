import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MainPageObject;
import lib.ui.ReadingsPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SecondTest extends CoreTestCase {
    public MainPageObject mainPageObject;


    public void setUp() throws Exception {
        super.setUp();
        mainPageObject = new MainPageObject(driver);
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testSearchElement() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        ReadingsPageObject readingsPageObject = new ReadingsPageObject(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("The Hobbit, or There and Back Again");
        searchPageObject.waitForSearchResultAndClick(
                "повесть английского писателя Джона Р. Р. Толкина");

        articlePageObject.saveToReadings("Hobbit");
        articlePageObject.showList();

        readingsPageObject.findListElement("Хоббит, или Туда и обратно");
        readingsPageObject.clearList("Hobbit");
    }
}
