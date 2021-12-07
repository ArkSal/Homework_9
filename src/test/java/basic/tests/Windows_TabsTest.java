package basic.tests;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.SimpleMethodProvider;

public class Windows_TabsTest extends TestBase {
    private Logger logger = LoggerFactory.getLogger(Windows_TabsTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/windows-tabs.php");
        logger.info("Site window opened");
    }

    @Test
    void newBrowserWindowTest() {
        driver.findElement(By.cssSelector("#newBrowserWindow")).click();
        SimpleMethodProvider.windowSwitch(driver);
        SimpleMethodProvider.tableSearch(driver);
    }

    @Test
    void newMessageWindow() {
        driver.findElement(By.cssSelector("#newMessageWindow")).click();
        SimpleMethodProvider.windowSwitch(driver);
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
    }

    @Test
    void newBrowserTab() {
        driver.findElement(By.cssSelector("#newBrowserTab")).click();
        SimpleMethodProvider.windowSwitch(driver);
        SimpleMethodProvider.tableSearch(driver);
    }

}
