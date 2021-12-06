package interactions;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccordionTest extends TestBase {
    private Logger logger = LoggerFactory.getLogger(AccordionTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/draggable.php");
        logger.info("Site window opened");
    }

    @Test
    void draggableTest() {
        WebElement dragElement = driver.findElement(By.cssSelector("#draggable"));

        int windowHeight = driver.manage().window().getSize().height;
        int windowWidth = driver.manage().window().getSize().width;
        int dragElementHeight = dragElement.getLocation().y;
        int dragElementWeight = dragElement.getLocation().x;

        actions.dragAndDropBy(dragElement, windowWidth - dragElementWeight - 150, -dragElementHeight).build().perform();
        logger.info("Element moved to upper right corner");
        actions.dragAndDropBy(dragElement, 0, windowHeight - 300).build().perform();
        logger.info("Element moved to bottom right corner");
        actions.dragAndDropBy(dragElement, -windowWidth / 2, -(windowHeight / 2 - 150)).build().perform();
        logger.info("Element moved to center");
        actions.dragAndDropBy(dragElement, -(windowWidth / 2 - 150), windowHeight / 2 - 150).build().perform();
        logger.info("Element moved to bottom left corner");
    }
}
