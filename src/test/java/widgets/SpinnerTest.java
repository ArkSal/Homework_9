package widgets;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpinnerTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(SpinnerTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/spinner.php");
        logger.info("Site window opened");
    }

    @Test
    void spinnerTest(){
        logger.info("Test completed");
    }
}
