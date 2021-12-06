package widgets;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.WaitMethodsProvider;

import java.util.List;

public class AccordionTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(AccordionTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/accordion.php");
        logger.info("Site window opened");
    }

    @Test
    void accordionTest() {
        List<WebElement> elementsToOpen = driver.findElements(By.cssSelector(".ui-accordion-header"));
        List<WebElement> elementsToPrint = driver.findElements(By.cssSelector("div.ui-accordion-content p , div.ui-accordion-content li"));

        for (WebElement element : elementsToOpen) {
            if (element.getAttribute("aria-selected").contains("false")) element.click();
            WaitMethodsProvider.waitForElementContainsAttribute(wait, element, "aria-selected", "true");
            printInnerText(elementsToPrint);
            logger.info("Text printed from " + element.getText());
        }
        logger.info("Test completed");
    }

    //Tutaj czy w klasie SimpleMethodProvider?
    private void printInnerText(List<WebElement> elementsToPrintList) {
        for (WebElement e : elementsToPrintList) {
            if (e.isDisplayed()) System.out.println(e.getText());
        }

    }

}
