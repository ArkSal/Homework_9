package interactions;

import models.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DroppableTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(DroppableTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        logger.info("Site window opened");
    }

    @Test
    void droppableTest() {
        WebElement droppableElement = driver.findElement(By.cssSelector("#droppable"));
        actions.dragAndDrop(driver.findElement(By.cssSelector("#draggable")),
                droppableElement).build().perform();
        logger.info("Element moved to drop window");
        Assertions.assertEquals(droppableElement.getText(), "Dropped!");
        logger.info("Droppable test completed");
    }
}
