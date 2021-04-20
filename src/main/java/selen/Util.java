package selen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Util extends BasePage {
    private static WebDriver driver;

    public static WebDriver createDriver(String url){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
