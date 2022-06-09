package auxiliar;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class POMBase {

    private final Logger LOGGER;

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected int TIMEOUT_VALUE = 10;

    public POMBase(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(TIMEOUT_VALUE));
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, TIMEOUT_VALUE), this);
        LOGGER = Logger.getLogger(this.getClass().getName());
    }

    /**
     * Click an element from the page passed as WebElement
     * @param element
     */

    public void clickElement(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
            scrollIntoView(element);
            element.click();
        } catch (Exception e) {
            this.manageException(e,"ERROR: Cannot click element: " + element.getTagName());
        }
    }

    /**
     * Send text to an element from the page passed as WebElement
     * @param element
     */

    public void sendTextToElement(WebElement element, String text) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
            scrollIntoView(element);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            this.manageException(e,"ERROR: Cannot click element: " + element.getTagName());
        }
    }

    public boolean isElementVisible(WebElement element) {
        boolean isVisible = false;
        try {
            webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
            isVisible = true;
        } catch (Exception e) { }
        return isVisible;
    }

    /**
     * We execute javascript code to scroll into a webelement
     * @param element
     */
    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) this.driver)
                .executeScript("arguments[0].scrollIntoView({ block: 'center' });", element);
    }

    /**
     * Manage exceptions related to the web driver
     * @param e
     * @param errorMessage
     */

    public void manageException(Exception e, String errorMessage) {
        //this.saveScreenshot("Error screenshot");
        LOGGER.log(Level.SEVERE,e.getMessage());
        e.printStackTrace();
        Assert.fail(this.getClass() + " " + errorMessage);

    }

}
