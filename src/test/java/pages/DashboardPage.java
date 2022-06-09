package pages;

import auxiliar.POMBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends POMBase {

    @FindBy(xpath = "//div[contains(text(),'Warning')]/..")
    WebElement warningRectangle;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getWarningRectangle() { return warningRectangle; }

    public void clickWarningRectangle() { clickElement(warningRectangle); }

}
