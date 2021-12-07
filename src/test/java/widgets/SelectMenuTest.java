package widgets;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.SimpleMethodProvider;

import java.util.List;

public class SelectMenuTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(SelectMenuTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/selectmenu.php");
        logger.info("Site window opened");
    }

    @Test
    void selectMenuTest() {
        driver.findElement(By.cssSelector("#speed-button")).click();
        List<WebElement> speedElements = driver.findElements(By.cssSelector("#speed-menu li"));
        SimpleMethodProvider.clickRandomElementFromList(speedElements);
        logger.info("Speed selected");

        driver.findElement(By.cssSelector("#files-button")).click();
        List<WebElement> filesElements = driver.findElements(By.cssSelector("#files-menu li.ui-menu-item"));
        SimpleMethodProvider.clickRandomElementFromList(filesElements);
        logger.info("File selected");

        driver.findElement(By.cssSelector("#number-button")).click();
        List<WebElement> numberElements = driver.findElements(By.cssSelector("#number-menu li"));
        SimpleMethodProvider.clickRandomElementFromList(numberElements);
        logger.info("Number selected");

        driver.findElement(By.cssSelector("#salutation-button")).click();
        List<WebElement> titleElements = driver.findElements(By.cssSelector("#salutation-menu li:not([aria-disabled])"));
        SimpleMethodProvider.clickRandomElementFromList(titleElements);
        logger.info("Title selected");

        logger.info("Test completed");
    }
}
