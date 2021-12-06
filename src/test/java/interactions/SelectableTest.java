package interactions;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectableTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(SelectableTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/selectable.php");
        logger.info("Site window opened");
    }

    @Test
    void selectableTest() {
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(driver.findElement(By.cssSelector("ol>li:nth-of-type(1)")))
                .click(driver.findElement(By.cssSelector("ol>li:nth-of-type(3)")))
                .click(driver.findElement(By.cssSelector("ol>li:nth-of-type(4)")))
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
        logger.info("Selected item:1,3,4 from list");
        String[] tab = driver.findElement(By.cssSelector("#select-result")).getText().split(" ");
        assertArrayEquals(tab, new String[]{"#1", "#3", "#4"});
        logger.info("Selectable test completed");
    }
}
