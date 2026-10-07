package Tests;

import PageObjects.Checkboxes;
import org.openqa.selenium.WebDriver;

public class Test2 implements ITest {
    private WebDriver driver;
    private Checkboxes pageObject;

    @Override
    public void setUp() {
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        pageObject = new Checkboxes(driver);
    }

    @Override
    public void execute() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        pageObject.clickByXpath("/html/body/div[2]/div/div/form/input[1]");

        pageObject.clickByXpath("/html/body/div[2]/div/div/form/input[2]");
    }

    @Override
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}