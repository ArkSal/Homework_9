package providers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitMethodsProvider {

    public static WebElement getRandomElementFromList(List<WebElement> webElements){
        return webElements.get(RandomDataGenerator.randomFunction(webElements.size()-1));
    }

    public static void waitForTextToBePresented(WebDriverWait wait, WebElement webElement, String textToBeAppeared){
        wait.until(ExpectedConditions.
                textToBePresentInElement(webElement, textToBeAppeared));
    }

    public static void waitForElementToBeClickable(WebDriverWait wait, WebElement webElement) {
        wait.until(ExpectedConditions.
                elementToBeClickable(webElement));
    }

    public static void waitForElementToBeVisible(WebDriverWait wait, WebElement webElement) {
        wait.until(ExpectedConditions.
                visibilityOf(webElement));
    }

    public static void getElementWhenTextAppear(WebDriverWait wait, By locator, String textToAppear) {
        wait.until(ExpectedConditions.
                textToBePresentInElementLocated(locator, textToAppear));
    }

    public static void waitForElementContainsAttribute(WebDriverWait wait, WebElement element, String param, String value){
        wait.until(ExpectedConditions.attributeContains(element,param, value));
    }

    public static WebElement getElementWhenClickable(WebDriverWait wait, By locator){
        return wait.until(ExpectedConditions.
                elementToBeClickable(locator));
    }

    public static WebElement waitToBeVisible(WebDriverWait wait, By locator) {
        return wait.until(ExpectedConditions.
                visibilityOfElementLocated(locator));
    }

    public static List<WebElement> waitForListToBeVisible(WebDriverWait wait, By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void waitUntilAlertIsPresented(WebDriverWait wait){
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
