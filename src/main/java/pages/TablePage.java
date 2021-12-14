package pages;

import models.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends BasePage {

    public TablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> rows;

    public List<TableRowPage> createTableRowPageList() {
        List<TableRowPage> rowPageList = new ArrayList<>();
        for (WebElement row : rows) {
            rowPageList.add(new TableRowPage(row));
        }
        return rowPageList;
    }

    public void getMountainRowsWithSpecificHeight(int height, String state){
        for (TableRowPage tableRowPage : createTableRowPageList()){
            if (tableRowPage.getState().contains(state) && tableRowPage.getHeight() > height){
                System.out.println(tableRowPage.getRowInfo());
            }
        }
    }
}
