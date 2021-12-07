package widgets;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.RandomDataGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoCompleteTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(AutoCompleteTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/autocomplete.php");
        logger.info("Site window opened");
    }

    @Test
    void autocompleteTest() {
        WebElement searchElement = driver.findElement(By.id("search"));
        searchElement.sendKeys("a");
        logger.info("Typed \"a\" in text bar");
        List<WebElement> autoCompleteWords = driver.findElements(By.cssSelector("[tabindex='-1']"));

        for (WebElement element : autoCompleteWords) {
            System.out.println(element.getText());
        }

        int indexOfWord = RandomDataGenerator.randomFunction(0, 8);
        String wordPutInBox = autoCompleteWords.get(indexOfWord).getText();
        autoCompleteWords.get(indexOfWord).click();
        logger.info("Clicked random word from list");
        String wordFromBox = lastGroupOfWord(driver.findElement(By.cssSelector("[role='status'] :last-child")));
        assertEquals(wordPutInBox, wordFromBox);
        logger.info("auto complete test completed");
    }


    private String lastGroupOfWord(WebElement element) {
        String[] wordToReturn = element.getText().split(": ");
        return wordToReturn[wordToReturn.length - 1];
    }
}

