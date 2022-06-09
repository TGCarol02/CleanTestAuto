package pages;

import auxiliar.POMBase;
import com.google.common.collect.Table;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TablesPage extends POMBase {

    @FindBy(xpath = "//td[count(//table//th[contains(@aria-label,'Name')]/preceding-sibling::*) +1]")
    List<WebElement> namesList;

    @FindBy(xpath = "//td[count(//table//th[contains(@aria-label,'Position')]/preceding-sibling::*) +1]")
    List<WebElement> positionsList;

    @FindBy(xpath = "//td[count(//table//th[contains(@aria-label,'Office')]/preceding-sibling::*) +1]")
    List<WebElement> officeList;

    public TablesPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getNamesList() { return namesList; }
    public List<WebElement> getPositionsList() { return positionsList; }
    public List<WebElement> getOfficeList() { return officeList; }

}
