package basic.tests;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;

public class AlertsTest extends TestBase {

    @BeforeEach
    void testSetup(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
    }
}
