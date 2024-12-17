import lib.CoreTestCase;
import lib.ui.SavedListObject;
import lib.ui.MainPageObject;
import lib.ui.NavigationObject;
import lib.ui.SearchPageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SecondTest extends CoreTestCase {

    public MainPageObject mainPageObject;

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        mainPageObject = new MainPageObject(driver);
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testSearchElement() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        NavigationObject navigationObject = new NavigationObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("The Hobbit, or there and back again");
        searchPageObject.clickOnSearchResult("повесть английского писателя Джона Р. Р. Толкина");

        SavedListObject savedListObject = new SavedListObject(driver);

        String listName = "Hobbit";

        savedListObject.addToList(listName);

        navigationObject.back();

        savedListObject.openLists();

        Assert.assertTrue("List is present", savedListObject.isListPresent(listName));

        savedListObject.openList(listName);
        savedListObject.deleteList();

        Assert.assertFalse("List is not present", savedListObject.isListPresent(listName));
    }
}
