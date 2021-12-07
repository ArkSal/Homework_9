package widgets;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TabsTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(TabsTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/tabs.php");
        logger.info("Site window opened");
    }

    @Test
    void tabsTest() {
        logger.info("Test completed");
    }
}
