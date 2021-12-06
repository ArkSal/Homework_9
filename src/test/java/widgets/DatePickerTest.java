package widgets;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatePickerTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(DatePickerTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
        logger.info("Site window opened");
    }

    @Test
    void datePickerTest(){
        logger.info("Test completed");
    }
}
