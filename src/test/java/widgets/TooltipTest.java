package widgets;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TooltipTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(TooltipTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/tooltip.php");
        logger.info("Site window opened");
    }

    @Test
    void toolTipTest(){
        logger.info("Test completed");
    }
}
