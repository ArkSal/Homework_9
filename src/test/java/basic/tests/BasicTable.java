package basic.tests;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.SimpleMethodProvider;

public class BasicTable extends TestBase {
    private Logger logger = LoggerFactory.getLogger(BasicTable.class);

    @BeforeEach
    void testSetUp() {
        driver.get("https://seleniumui.moderntester.pl/table.php");
        logger.info("Site window opened");
    }

    @Test
    void tablePractise() {
        SimpleMethodProvider.tableSearch(driver);
        logger.info("Window switched");
    }
}
