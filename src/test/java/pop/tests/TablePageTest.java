package pop.tests;

import models.TestBasePOP;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.TablePage;
import pages.TableRowPage;

public class TablePageTest extends TestBasePOP {
    Logger logger = LoggerFactory.getLogger(TableRowPage.class);
    TablePage tablePage;

    @Test
    void tableTest() {
        tablePage = new TablePage(driver);
        tablePage.getMountainRowsWithSpecificHeight(4000, "Switzerland");
    }

}
