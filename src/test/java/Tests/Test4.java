package Tests;

import PageObjects.Inputs;
import org.openqa.selenium.WebDriver;

public class Test4 implements ITest {
    private WebDriver driver;
    private Inputs pageObject;

    @Override
    public void setUp() {
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        pageObject = new Inputs(driver);
    }

    @Override
    public void execute() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        pageObject.clickBySelector("#content > div > div > div > input[type=number]");
        pageObject.pressArrowUP(3);
        pageObject.waitForMillis(1000);
        pageObject.pressArrowDown(3);
        pageObject.waitForMillis(500);
    }

    @Override
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}

