package basic.tests;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.WaitMethodsProvider;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AlertsTest extends TestBase {
    private final Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        logger.info("Site window opened");
    }

    @Test
    @DisplayName("Simple alert test")
    void simpleAlertPopUpTest() {
        driver.findElement(By.cssSelector("#simple-alert")).click();
        driver.switchTo().alert().accept();
        logger.info("Alert window accepted");
        assertThat(driver.findElement(By.cssSelector("#simple-alert-label")).getText(), equalTo("OK button pressed"));
        logger.info("Alert window test completed");
    }

    @Test
    @DisplayName("Prompt alert box test")
    void promptAlertBoxTest() {
        driver.findElement(By.cssSelector("#prompt-alert")).click();
        Alert alert = driver.switchTo().alert();
        String textSentToAlert = "Random name";
        alert.sendKeys(textSentToAlert);
        alert.accept();
        logger.info("Name sent to alert");
        assertThat(driver.findElement(By.cssSelector("#prompt-label")).getText(), equalTo("Hello " + textSentToAlert + "! How are you today?"));
        logger.info("Alert box test completed");
    }

    @Test
    @DisplayName("Confirm alert box test")
    void confirmAlertBoxTest() {
        WebElement alertButton = driver.findElement(By.cssSelector("#confirm-alert"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement alertMessageElement = driver.findElement(By.cssSelector("#confirm-label"));
        logger.info("\"OK\" button clicked on alert");
        assertThat(alertMessageElement.getText(), equalTo("You pressed OK!"));
        logger.info("Validating \"accept\" alert message");
        alertButton.click();
        alert.dismiss();
        logger.info("\"Anuluj\" button clicked on alert");
        assertThat(alertMessageElement.getText(), equalTo("You pressed Cancel!"));
        logger.info("Validating \"dismiss\" alert message");
    }

    @Test
    @DisplayName("Delayed alert test")
    void delayedAlertTest() {
        driver.findElement(By.cssSelector("#delayed-alert")).click();
        logger.info("\"OK\" button clicked on delayed alert");
        WaitMethodsProvider.waitUntilAlertIsPresented(wait);
        driver.switchTo().alert().accept();

        assertThat("OK button pressed", equalTo(driver.findElement(By.cssSelector("#delayed-alert-label")).getText()));
        logger.info("Validating \"OK\" alert message");
    }

}
