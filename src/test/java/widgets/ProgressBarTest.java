package widgets;

import models.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.WaitMethodsProvider;

public class ProgressBarTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(ProgressBarTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        logger.info("Site window opened");
    }

    @Test
    void progressBarTest() {
        WebElement progressBar = driver.findElement(By.cssSelector("#progressbar"));
        WaitMethodsProvider.waitForTextToBePresented(wait, progressBar, "Complete!");
        Assertions.assertEquals(progressBar.getText(), "Complete!");
        logger.info("Test completed");
    }
}
