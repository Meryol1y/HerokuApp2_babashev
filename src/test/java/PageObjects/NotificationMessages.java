package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class NotificationMessages {

    private WebDriver driver;

    public NotificationMessages(WebDriver driver) {
        this.driver = driver;
    }

    public void clickClickHereLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Click here")));
        link.click();
    }

    public String getNotificationText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement flashMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        return flashMessage.getText();
    }

    public boolean isNotificationContains(String expectedText) {
        String actualText = getNotificationText();
        return actualText.contains(expectedText);
    }

    public String clickAndGetNotification() {
        clickClickHereLink();
        return getNotificationText();
    }
}