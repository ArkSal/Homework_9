package widgets;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.WaitMethodsProvider;

public class MenuTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(MenuTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/menu-item.php");
        logger.info("Site window opened");
    }

    @Test
    void menuTest() {
        driver.findElement(By.cssSelector("#ui-id-9")).click();
        WaitMethodsProvider.waitToBeVisible(wait, By.cssSelector("#ui-id-13")).click();
        WaitMethodsProvider.waitToBeVisible(wait, By.cssSelector("#ui-id-16")).click();
        logger.info("Picked Music -> Jazz -> Modern from menu");
        logger.info("Test completed");
    }
}
