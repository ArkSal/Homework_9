package demoqa;

import models.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.RandomDataGenerator;
import providers.WaitMethodsProvider;

import java.util.ArrayList;
import java.util.List;

public class ToolsQATest extends TestBase {
    private Logger logger = LoggerFactory.getLogger(ToolsQATest.class);
    List<String> listOfSelectedTextsElements;

    @BeforeEach
    void testSetup(){
        driver.get("https://demoqa.com/automation-practice-form");
        logger.info("Window opened");
        listOfSelectedTextsElements = new ArrayList<>();
    }

    @RepeatedTest(10)
    void shouldFillDemoQAForm() {
        driver.findElement(By.cssSelector("#close-fixedban")).click();
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Testing");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("Master");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("testing.account@gmail.com");
        driver.findElement(By.cssSelector("[for='gender-radio-1']")).click();
        driver.findElement(By.cssSelector("#userNumber")).sendKeys("0911213769");
        pickDate();
        sendKeysToElement( "MA");
        pickRandomElementFromTextField(listOfSelectedTextsElements);
        logger.info("Picked Maths from autocomplete");
        validateIfPickedElementsAreInTextField();

        sendKeysToElement("c");
        pickRandomElementFromTextField(listOfSelectedTextsElements);
        logger.info("Picked random option from autocomplete");
        validateIfPickedElementsAreInTextField();


        sendKeysToElement("a");
        pickRandomElementFromTextField(listOfSelectedTextsElements);
        logger.info("Picked random option from autocomplete");
        validateIfPickedElementsAreInTextField();

        deleteLastOptionFromTextField();
        logger.info("Deleted last option from text field");
        validateIfPickedElementsAreInTextField();

        deleteAllOptionsFromTextField();
        logger.info("Deleted all options");
        validateIfPickedElementsAreInTextField();
    }

    private void pickDate(){
        driver.findElement(By.cssSelector("#dateOfBirthInput")).click();
        driver.findElement(By.cssSelector(".react-datepicker__year-select")).click();
        driver.findElement(By.cssSelector("option[value='1991']")).click();
        driver.findElement(By.cssSelector(".react-datepicker__month-select")).click();
        driver.findElement(By.cssSelector("option[value='1']")).click();
        driver.findElement(By.cssSelector(".react-datepicker__day--027[aria-label*='February']")).click();
    }

    private void sendKeysToElement(String stringToSend){
        WebElement element = driver.findElement(By.cssSelector(".subjects-auto-complete__value-container"));
        element.click();
        actions.moveToElement(element).sendKeys(stringToSend).build().perform();
    }

    private void pickRandomElementFromTextField(List<String> listToAddText){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".subjects-auto-complete__menu")));
        List<WebElement> availableOptionsList = driver.findElements(By.cssSelector(".subjects-auto-complete__option"));
        int randomIndexFromList = RandomDataGenerator.randomFunction(availableOptionsList.size()-1);
        WebElement randomElementFromList = availableOptionsList.get(randomIndexFromList);
        listToAddText.add(randomElementFromList.getText());
        WaitMethodsProvider.getElementWhenClickable(wait, randomElementFromList).click();
    }

    private List<String> getListOfTextsFromSubjectField(){
        List<WebElement> listOfElements = driver.findElements(By.cssSelector(".subjects-auto-complete__multi-value__label"));
        List<String> listOfTextsFromWebelements = new ArrayList<>();
        for (WebElement listOfElement : listOfElements) {
            listOfTextsFromWebelements.add(listOfElement.getText());
        }
        return listOfTextsFromWebelements;
    }

    private void validateIfPickedElementsAreInTextField(){
        getListOfTextsFromSubjectField();
        Assertions.assertEquals(listOfSelectedTextsElements, getListOfTextsFromSubjectField());
        logger.info("Validated if picked elements are in subject text field");
    }

    private void deleteLastOptionFromTextField(){
        List<WebElement> webElements = driver.findElements(By.cssSelector(".subjects-auto-complete__multi-value__remove"));
        webElements.get(webElements.size()-1).click();
        listOfSelectedTextsElements.remove(listOfSelectedTextsElements.size()-1);
        logger.info("Deleted last option from Subjects text field");
    }

    private void deleteAllOptionsFromTextField(){
        driver.findElement(By.cssSelector(".subjects-auto-complete__indicators")).click();
        listOfSelectedTextsElements.clear();
    }


}
