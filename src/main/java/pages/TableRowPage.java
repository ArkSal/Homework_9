package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class TableRowPage {

    public TableRowPage(WebElement row) {
        PageFactory.initElements(new DefaultElementLocatorFactory(row), this);
    }

    @FindBy(css = "th")
    private WebElement rank;

    @FindBy(css = "td")
    private WebElement peak;

    @FindBy(css = ":nth-child(3)")
    private WebElement mountainRange;

    @FindBy(css = ":nth-child(4)")
    private WebElement state;

    @FindBy(css = ":nth-child(5)")
    private WebElement height;

    public String getRowInfo() {
        return "Rank: " + getRank() + " | Peak:  " + getPeak() + " | Mountain range:  " + getMountainRange();
    }

    public String getState() {
        return state.getText();
    }

    public int getHeight() {
        return Integer.parseInt(height.getText());
    }

    public int getRank() {
        return Integer.parseInt(rank.getText());
    }

    public String getPeak() {
        return peak.getText();
    }

    public String getMountainRange() {
        return mountainRange.getText();
    }
}
