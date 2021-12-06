package widgets;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.SimpleMethodsProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SliderTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(SliderTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/slider.php");
        logger.info("Site window opened");
    }

    @Test
    void sliderTest() {
        WebElement sliderElement = driver.findElement(By.id("custom-handle"));
        final int WHOLE_SLIDER_WIDTH = driver.findElement(By.id("slider")).getSize().getWidth();
        final int SLIDER_ICON_WIDTH = driver.findElement(By.id("custom-handle")).getSize().getWidth();

        int[] sliderPositionsToMove = new int[]{50, 80, 80, 20, 0};
        int currentSliderPosition = 0;

        for (int nextSliderPosition : sliderPositionsToMove) {
            actions.dragAndDropBy(sliderElement, SimpleMethodsProvider
                            .moveSlider(currentSliderPosition, nextSliderPosition, WHOLE_SLIDER_WIDTH, SLIDER_ICON_WIDTH), 0)
                    .build()
                    .perform();
            currentSliderPosition = nextSliderPosition;
            assertEquals(nextSliderPosition, Integer.parseInt(sliderElement.getText()));
            logger.info("Assertion done correctly");
        }
    }
}

