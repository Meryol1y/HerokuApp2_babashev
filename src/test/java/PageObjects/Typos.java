package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

public class Typos {

    private WebDriver driver;

    public Typos(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstParagraphText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement paragraph = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("p")));
        return paragraph.getText();
    }

    public String getSecondParagraphText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("p")));

        List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
        if (paragraphs.size() >= 2) {
            return paragraphs.get(1).getText(); // Индекс 1 = второй параграф
        }
        return "";
    }

    public String getAllParagraphsText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("p")));

        List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
        StringBuilder allText = new StringBuilder();

        for (WebElement paragraph : paragraphs) {
            if (allText.length() > 0) {
                allText.append(" "); // Добавляем пробел между параграфами
            }
            allText.append(paragraph.getText());
        }

        return allText.toString();
    }

    public List<String> getAllParagraphsAsList() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("p")));

        List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
        List<String> texts = new ArrayList<>();

        for (WebElement paragraph : paragraphs) {
            texts.add(paragraph.getText());
        }

        return texts;
    }
}