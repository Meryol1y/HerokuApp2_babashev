package Tests;

import PageObjects.Dropdown;
import org.openqa.selenium.WebDriver;

public class Test3 implements ITest {
    private WebDriver driver;
    private Dropdown pageObject;

    @Override
    public void setUp() {
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        pageObject = new Dropdown(driver);
    }

    @Override
    public void execute() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        pageObject.clickByXpath("/html/body/div[2]/div/div/select");
        pageObject.clickByXpath("/html/body/div[2]/div/div/select/option[2]");
        pageObject.waitForMillis(1000);
        pageObject.clickByXpath("/html/body/div[2]/div/div/select");
        pageObject.clickByXpath("/html/body/div[2]/div/div/select/option[3]");
        pageObject.waitForMillis(500);
    }

    @Override
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
