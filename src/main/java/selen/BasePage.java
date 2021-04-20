package selen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver = Util.getDriver();
    private Wait<WebDriver> waiter = new WebDriverWait(driver, 30, 1000);

    public BasePage(){
        PageFactory.initElements(driver, this);
    }
}
