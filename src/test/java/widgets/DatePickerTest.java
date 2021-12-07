package widgets;

import handlers.DatesHandler;
import models.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class DatePickerTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(DatePickerTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
        logger.info("Site window opened");
    }

    @Test
    void datePickerTest() {
        WebElement dateFieldText = driver.findElement(By.cssSelector("#datepicker"));
        dateFieldText.click();
        By prevIconLocator = By.cssSelector(".ui-icon-circle-triangle-w");
        By nextIconLocator = By.cssSelector(".ui-icon-circle-triangle-e");
        long monthsDifference;

        logger.info("Validating if current date in calendar was correct");
        WebElement currentDateHighlight = driver.findElement(By.cssSelector(".ui-state-highlight"));
        currentDateHighlight.click();
        LocalDate todayDate = LocalDate.now();
        // nie wiem czy DatesHandler.getDateFieldTextValue powinienem zrobić jako zmienną i jej uzyć dwa razy poniżej
        Assertions.assertEquals(DatesHandler.
                getFormattedDateAsString(todayDate), DatesHandler.getDateFieldTextValue(dateFieldText));
        logger.info("Date read from text field: " + DatesHandler.getDateFieldTextValue(dateFieldText));

        logger.info("Validating if first day of next month is set correctly");
        LocalDate firstDayOfNextMonth = todayDate.plusMonths(1).withDayOfMonth(1);
        LocalDate dateReadFromCalendarTextField = DatesHandler.getDateFromTextField(dateFieldText);
        monthsDifference = DatesHandler.
                getMonthsDifferenceBetweenDates(dateReadFromCalendarTextField, firstDayOfNextMonth);
        DatesHandler.goToCorrectMonthInCalendar(wait, dateFieldText, prevIconLocator, nextIconLocator, monthsDifference);
        DatesHandler.clickCorrectDay(firstDayOfNextMonth, wait);
        Assertions.assertEquals(DatesHandler
                .getFormattedDateAsString(firstDayOfNextMonth), DatesHandler.getDateFieldTextValue(dateFieldText));
        logger.info("Date read from text field: " + DatesHandler.getDateFieldTextValue(dateFieldText));

        logger.info("Validating if the same date as in the last test is set correctly");
        LocalDate lastDayOfJanuaryNextYear = todayDate.plusYears(1).withMonth(1).withDayOfMonth(31);
        monthsDifference = DatesHandler.
                getMonthsDifferenceBetweenDates(DatesHandler.getDateFromTextField(dateFieldText), lastDayOfJanuaryNextYear);
        DatesHandler.goToCorrectMonthInCalendar(wait, dateFieldText, prevIconLocator, nextIconLocator, monthsDifference);
        DatesHandler.clickCorrectDay(lastDayOfJanuaryNextYear, wait);
        Assertions.assertEquals(DatesHandler.
                getFormattedDateAsString(lastDayOfJanuaryNextYear), DatesHandler.getDateFieldTextValue(dateFieldText));
        logger.info("Date read from text field: " + DatesHandler.getDateFieldTextValue(dateFieldText));

        logger.info("Validating if last day of next January is set correctly");
        monthsDifference = DatesHandler.
                getMonthsDifferenceBetweenDates(DatesHandler.getDateFromTextField(dateFieldText), firstDayOfNextMonth);
        DatesHandler.goToCorrectMonthInCalendar(wait, dateFieldText, prevIconLocator, nextIconLocator, monthsDifference);
        DatesHandler.clickCorrectDay(lastDayOfJanuaryNextYear, wait);
        Assertions.assertEquals(DatesHandler.
                getFormattedDateAsString(lastDayOfJanuaryNextYear), DatesHandler.getDateFieldTextValue(dateFieldText));
        logger.info("Date read from text field: " + DatesHandler.getDateFieldTextValue(dateFieldText));

        logger.info("Validating if random date from last month is set correctly");
        LocalDate randomDateLastMonth = DatesHandler.getLastMonthRandomDate();
        monthsDifference = DatesHandler.
                getMonthsDifferenceBetweenDates(DatesHandler.getDateFromTextField(dateFieldText), randomDateLastMonth);
        DatesHandler.goToCorrectMonthInCalendar(wait, dateFieldText, prevIconLocator, nextIconLocator, monthsDifference);
        DatesHandler.clickCorrectDay(randomDateLastMonth, wait);
        Assertions.assertEquals(DatesHandler.
                getFormattedDateAsString(randomDateLastMonth), DatesHandler.getDateFieldTextValue(dateFieldText));
        logger.info("Date read from text field: " + DatesHandler.getDateFieldTextValue(dateFieldText));

        logger.info("Validating if random date from last year is set correctly");
        LocalDate randomDateFromLAstYear = DatesHandler.getLastYearRandomDate();
        monthsDifference = DatesHandler.
                getMonthsDifferenceBetweenDates(DatesHandler.getDateFromTextField(dateFieldText), randomDateFromLAstYear);
        DatesHandler.goToCorrectMonthInCalendar(wait, dateFieldText, prevIconLocator, nextIconLocator, monthsDifference);
        DatesHandler.clickCorrectDay(randomDateFromLAstYear, wait);
        Assertions.assertEquals(DatesHandler.
                getFormattedDateAsString(randomDateFromLAstYear), DatesHandler.getDateFieldTextValue(dateFieldText));
        logger.info("Date read from text field: " + DatesHandler.getDateFieldTextValue(dateFieldText));


        logger.info("Test completed");
    }


}
