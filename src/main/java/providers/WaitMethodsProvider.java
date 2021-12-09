package providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMethodsProvider {

    public static void waitForTextToBePresented(WebDriverWait wait, WebElement webElement, String textToBeAppeared) {
        wait.until(ExpectedConditions.
                textToBePresentInElement(webElement, textToBeAppeared));
    }

    public static void waitForElementContainsAttribute(WebDriverWait wait, WebElement element, String param, String value) {
        wait.until(ExpectedConditions.attributeContains(element, param, value));
    }

    public static WebElement getElementWhenClickableByLocator(WebDriverWait wait, By locator) {
        return wait.until(ExpectedConditions.
                elementToBeClickable(locator));
    }

    public static WebElement waitToBeVisible(WebDriverWait wait, By locator) {
        return wait.until(ExpectedConditions.
                visibilityOfElementLocated(locator));
    }

    public static void waitUntilAlertIsPresented(WebDriverWait wait) {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static WebElement getElementWhenClickable(WebDriverWait wait, WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
