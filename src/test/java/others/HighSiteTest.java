package others;

import handlers.FileHandler;
import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.SimpleMethodsProvider;

public class HighSiteTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(HighSiteTest.class);

    @BeforeEach
    void testSetup() {
        //czy taka nazwa metody pasuje? + tekst loggera taki trochę dziwny
        driver.get("https://seleniumui.moderntester.pl/high-site.php");
        logger.info("Site window opened");
    }

    @Test
    void highSiteTest() {
        SimpleMethodsProvider.scrollDownUntilVisible(By.cssSelector("#scroll-button"), driver, actions);
        logger.info("Scrolled down until button was visible.");
        FileHandler.takeScreenshot(driver);
        logger.info("Screenshot has been taken");
    }
}
