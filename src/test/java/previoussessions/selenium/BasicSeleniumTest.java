package previoussessions.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class BasicSeleniumTest {

    @BeforeMethod
    public void setChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
    }

    @Test
    public void navigateToWebPage(){
        try{
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.youtube.com/");
            Thread.sleep(3500);
            driver.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reproduceFirstVideo(){
        try{
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.youtube.com/");
            driver.findElement(By.xpath("(//div[@id='dismissible'])[1]//img[@width='9999']")).click();
            Thread.sleep(3500);
            driver.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchVideo(){
        try{
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.youtube.com/");
            Thread.sleep(3500);
            driver.findElement(By.id("search")).sendKeys("Selenium");
            driver.findElement(By.id("search-icon-legacy")).click();
            Thread.sleep(5500);
            driver.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
