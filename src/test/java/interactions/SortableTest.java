package interactions;

import models.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import providers.RandomDataGenerator;

import java.util.List;

public class SortableTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(SortableTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/sortable.php");
        logger.info("Site window opened");
    }

    @Test
    void sortableTest() {
        List<WebElement> elementsToSort = driver.findElements(By.cssSelector(".ui-sortable-handle"));
        int[] startedYLocalization = new int[elementsToSort.size()];

        for (int i = 0; i < elementsToSort.size(); i++) {
            startedYLocalization[i] = elementsToSort.get(i).getLocation().getY();
        }
        int[] sortedTable = RandomDataGenerator.createTableWithSortedNumbers(7);
        List<Integer> shuffledList = RandomDataGenerator.getShuffledListFromSortedTable(sortedTable);


        for (int i = 0; i < sortedTable.length; i++) {
            WebElement elementToMove = elementsToSort.get((shuffledList.get(i)) - 1);
            int elementToMovePosition = elementToMove.getLocation().getY();
            int distanceToMoveInYAxis = startedYLocalization[i] - elementToMovePosition;
            actions.dragAndDropBy(elementToMove, 0, distanceToMoveInYAxis).build().perform();
            logger.info("Element  moved");
        }
        logger.info("Selectable test completed");
    }
}