package providers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
// Dziwna nazwa tej klasy

public class SimpleMethodProvider {
    private static Logger logger = LoggerFactory.getLogger(SimpleMethodProvider.class);

    public static void tableSearch(WebDriver driver) {
        List<WebElement> tableRows = driver.findElements(By.cssSelector("tbody tr"));

        for (WebElement mountain : tableRows) {
            String rank = mountain.findElement(By.cssSelector("th")).getText();
            String peak = mountain.findElement(By.cssSelector("td")).getText();
            String mountainRange = mountain.findElement(By.cssSelector(":nth-child(3)")).getText();
            int mountainHeight = Integer.parseInt(mountain.findElement(By.cssSelector(":nth-child(5)")).getText());
            if ((mountain.getText().contains("Switzerland")) && (mountainHeight > 4000)) {
                System.out.println("Rank: " + rank + " | Peak:  " + peak + " | Mountain range:  " + mountainRange);
            }
        }
        logger.info("Table search method done");
    }

    public static void windowSwitch(WebDriver driver){
        for (String winHandle: driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public static void resizeElement(Actions actions, WebElement elementToResize, int xSet, int ySet){
        actions.dragAndDropBy(elementToResize,25+xSet, 25+ySet).build().perform();
        logger.info("Element resized by " + xSet + " in X axis and by " + ySet + " in Y axis.");
    }

    public static boolean scrollDownUntilVisible(By locator, WebDriver driver, Actions actions){
        //  tu mozna też zrobić bez rekurencji. przy wywołaniu metody wystarczy dać while(scrollDownmethod){}
        // można też użyć js excecutor tutaj, ale to chyba bez różnicy, tyle, że w JS moozna robić większe "kroki"
        try {
            driver.findElement(locator);
        } catch (NoSuchElementException e) {
            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            scrollDownUntilVisible(locator, driver, actions);
        }
        return true;
    }

    public static int moveSlider(int lastStep, int currentStep, int sliderWidth, int sliderSize) {
        return sliderWidth * (currentStep - lastStep) / 100 - (sliderSize / 3);
    }

    public static void clickRandomElementFromList(List<WebElement> elementsList){
        elementsList.get(RandomDataGenerator.randomFunction(elementsList.size()-1)).click();
    }



}
