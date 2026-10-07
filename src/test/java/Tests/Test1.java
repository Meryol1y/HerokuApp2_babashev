package Tests;

import PageObjects.Add_Remove_Elements;
import org.openqa.selenium.WebDriver;
public class Test1 implements ITest {
    private WebDriver driver;
    private Add_Remove_Elements pageObject;

    @Override
    public void setUp() {
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        pageObject = new Add_Remove_Elements(driver);
    }

    @Override
    public void execute() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        //добавление
        pageObject.clickBySelector("/html/body/div[2]/div/div/button");
        pageObject.clickBySelector("/html/body/div[2]/div/div/button");
        //удаление
        pageObject.clickBySelector("/html/body/div[2]/div/div/div/button[1]");
        pageObject.clickBySelector("/html/body/div[2]/div/div/div/button");
    }

    @Override
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}