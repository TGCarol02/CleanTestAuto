package pages;

import auxiliar.POMBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideMenuBar extends POMBase {

    @FindBy(xpath = "(//ul[@id='accordionSidebar']/a/div)[2]")
    WebElement homeOption;

    @FindBy(xpath = "//a[contains(@href,'tables')]")
    WebElement tablesOption;

    @FindBy(xpath = "//a[contains(@href,'charts')]")
    WebElement chartsOption;

    @FindBy(xpath = "//a[contains(@aria-controls,'Pages')]")
    WebElement pagesOption;

    @FindBy(xpath = "//a[contains(@aria-controls,'Utilities')]")
    WebElement utilitiesOption;

    @FindBy(xpath = "//a[contains(@aria-controls,'collapseTwo')]")
    WebElement componentsOption;


    /**
     * Class Constructor.
     * @param driver the web driver.
     */
    public SideMenuBar(WebDriver driver) {
        super(driver);
    }

    public void clickHomeOption() { clickElement(homeOption); }

    public void clickComponentsOption() { clickElement(componentsOption); }

    public void clickUtilitiesOption() { clickElement(utilitiesOption); }

    public void clickPagesOption() { clickElement(pagesOption); }

    public void clickChartsOption() { clickElement(chartsOption); }

    public void clickTablesOption() { clickElement(tablesOption); }
}
