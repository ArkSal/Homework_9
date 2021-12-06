package interactions;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.SimpleMethodsProvider;

public class ResizableTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(ResizableTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/resizable.php");
        logger.info("Site window opened");
    }

    @Test
    void resizableTest() {
        WebElement gripIcon = driver.findElement(By.cssSelector(".ui-icon"));
        SimpleMethodsProvider.resizeElement(actions, gripIcon, 10, 0);
        SimpleMethodsProvider.resizeElement(actions, gripIcon, 0, 10);
        SimpleMethodsProvider.resizeElement(actions, gripIcon, 10, 10);
        logger.info("Resizable test completed");
    }
}
