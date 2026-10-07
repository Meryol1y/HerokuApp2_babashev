package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Inputs {

    // Драйвер обычно передается в PageObject через конструктор
    private WebDriver driver;
    private Actions actions;

    public Inputs(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void waitForMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Задержка прервана");
        }
    }

    public void pressArrowDown(int times) {
        for (int i = 0; i < times; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            waitForMillis(100);
        }
    }
    public void pressArrowUP(int times) {
        for (int i = 0; i < times; i++) {
            actions.sendKeys(Keys.ARROW_UP).perform();
            waitForMillis(100);
        }
    }
    public void clickBySelector(String cssSelector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector))).click();
    }

}