package handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.WaitMethodsProvider;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

public class DatesHandler {
    private static Logger logger = LoggerFactory.getLogger(DatesHandler.class);

    public static String getFormattedDateAsString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

    public static LocalDate getRandomDateInRange(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);
        logger.info("Random date in specific range created");
        return LocalDate.ofEpochDay(randomDay);
    }

    public static long getMonthsDifferenceBetweenDates(LocalDate firstDate, LocalDate secondDate) {
        return ChronoUnit.MONTHS.between(
                firstDate.withDayOfMonth(1),
                secondDate.withDayOfMonth(1));
    }

    public static void goToCorrectMonthInCalendar(WebDriverWait wait, WebElement element, By previousMonthIcon, By nextMonthIcon, long monthsDifference) {
        element.click();
        if (monthsDifference > 0) {
            for (int i = 0; i < monthsDifference; i++) {
                WaitMethodsProvider.getElementWhenClickable(wait, nextMonthIcon).click();
            }
        } else if (monthsDifference < 0) {
            long absOfDifferenceValue = Math.abs(monthsDifference);
            for (int i = 0; i < absOfDifferenceValue; i++) {
                WaitMethodsProvider.getElementWhenClickable(wait, previousMonthIcon).click();
            }
        }
    }

    public static void clickCorrectDay(LocalDate date, WebDriverWait wait) {
        WaitMethodsProvider.getElementWhenClickable(wait, By.xpath
                ("//*[@data-month='" + (date.getMonthValue() - 1) + "']//a[.='" + date.getDayOfMonth() + "']")).click();
        logger.info("Correct date selected on the calendar");
    }

    public static String getDateFieldTextValue(WebElement element) {
        return element.getAttribute("value");
    }


    public static LocalDate getLastYearRandomDate() {
        LocalDate lastYearFirstDay = LocalDate.now().minusYears(1).withDayOfYear(1);
        LocalDate lastYearLastDay = lastYearFirstDay.withDayOfYear(lastYearFirstDay.lengthOfYear());
        LocalDate randomDateLastMonth = DatesHandler.getRandomDateInRange(lastYearFirstDay, lastYearLastDay);
        logger.info("Random date from last year created: {}", randomDateLastMonth);
        return randomDateLastMonth;
    }

    public static LocalDate getLastMonthRandomDate() {
        LocalDate lastMonthFirstDay = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate lastMonthLastDay = lastMonthFirstDay.withDayOfMonth(lastMonthFirstDay.lengthOfMonth());
        LocalDate randomDateLastMonth = DatesHandler.getRandomDateInRange(lastMonthFirstDay, lastMonthLastDay);
        logger.info("Random date from last month created: {}", randomDateLastMonth);
        return randomDateLastMonth;
    }

    public static LocalDate getDateFromTextField(WebElement element) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return LocalDate.parse(getDateFieldTextValue(element), formatter);
    }


}
