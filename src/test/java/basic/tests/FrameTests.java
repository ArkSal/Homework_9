package basic.tests;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.RandomDataGenerator;

import java.util.List;

public class FrameTests extends TestBase {
    private Logger logger = LoggerFactory.getLogger(FrameTests.class);

    @BeforeEach
    void testSetUp() {
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
        logger.info("Site window opened");
    }

    @Test
    @DisplayName("iFrame test")
    void iFrameTest() {
        driver.switchTo().frame("iframe1");
        driver.findElement(By.cssSelector("[placeholder='First name']")).sendKeys("firstName");
        driver.findElement(By.cssSelector("[placeholder='Surname']")).sendKeys("lastName");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        logger.info("Iframe1's form filled");
        driver.switchTo().parentFrame();
        logger.info("Switched to 2nd frame");
        driver.switchTo().frame("iframe2");
        driver.findElement(By.cssSelector("#inputLogin")).sendKeys("randomLogin");
        driver.findElement(By.cssSelector("#inputPassword")).sendKeys("randomPassword");
        List<WebElement> continentsList = driver.findElements(By.cssSelector("#inlineFormCustomSelectPref option"));
        continentsList.get(RandomDataGenerator.randomFunction(1, continentsList.size()) - 1).click();
        List<WebElement> yearsOfExperienceList = driver.findElements(By.cssSelector(".form-check-input"));
        yearsOfExperienceList.get(RandomDataGenerator.randomFunction(7)).click();
        driver.findElement(By.cssSelector("div>button")).click();
        logger.info("Iframe2's form filled");
        driver.switchTo().parentFrame();
        logger.info("Switched to parent frame");
        driver.findElement(By.cssSelector(".nav-ite")).click();
        logger.info("Basic menu clicked. Test cpmpleted");
    }
}
