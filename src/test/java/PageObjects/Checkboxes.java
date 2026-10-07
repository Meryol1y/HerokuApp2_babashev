package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Checkboxes {

    // Драйвер обычно передается в PageObject через конструктор
    private WebDriver driver;

    public Checkboxes(WebDriver driver) {
        this.driver = driver;
    }

    // Ждет, пока элемент станет кликабельным
    public void clickByXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }
}