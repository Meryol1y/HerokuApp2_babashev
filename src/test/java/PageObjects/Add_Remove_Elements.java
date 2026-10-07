package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Add_Remove_Elements {

    // Драйвер обычно передается в PageObject через конструктор
    private WebDriver driver;

    public Add_Remove_Elements(WebDriver driver) {
        this.driver = driver;
    }

    // Ждет, пока элемент станет кликабельным
    public void clickBySelector(String cssSelector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector))).click();
    }
}