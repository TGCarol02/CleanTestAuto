package specs.newfeatures;

import auxiliar.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.User;

import java.io.File;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SeleniumFour extends TestBase {

    @Test
    public void webElementScreenshot() {
        try{
            LoginPage loginPage = new LoginPage(getDriver());
            File file = loginPage.returnLoginImage().getScreenshotAs(OutputType.FILE);
            File destFile =new File(System.getProperty("user.dir") + "/target/screenshots/puppy.png");
            FileHandler.copy(file,destFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void openNewTab() {
        try{
            User user = new User();
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.login(user.getEmail(), user.getPassword());
            getDriver().switchTo().newWindow(WindowType.TAB);
            getDriver().navigate().to("https://www.youtube.com/");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void openNewWindow() {
        try{
            User user = new User();
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.login(user.getEmail(), user.getPassword());
            getDriver().switchTo().newWindow(WindowType.WINDOW);
            getDriver().navigate().to("https://www.youtube.com/");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getElementLocation() {
        LoginPage loginPage = new LoginPage(getDriver());
        System.out.println("Height: " + loginPage.returnLoginImage().getRect().getDimension().getHeight());
        System.out.println("Width: " + loginPage.returnLoginImage().getRect().getDimension().getWidth());
        System.out.println("X Location: " + loginPage.returnLoginImage().getRect().getX());
        System.out.println("Y Location: " + loginPage.returnLoginImage().getRect().getY());

    }

}
