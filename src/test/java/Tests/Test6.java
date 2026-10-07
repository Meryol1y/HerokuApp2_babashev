package Tests;

import PageObjects.NotificationMessages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test6 implements ITest {

    private WebDriver driver;
    private NotificationMessages notificationPage;

    @Override
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        notificationPage = new NotificationMessages(driver);
    }

    @Override
    public void execute() {
        driver.get("http://the-internet.herokuapp.com/notification_message");

        System.out.println("=== Notification Messages Test ===\n");

        String expectedText = "Action successful";
        int attempts = 0;
        int maxAttempts = 10;
        boolean success = false;

        while (attempts < maxAttempts) {
            attempts++;
            System.out.println("Попытка #" + attempts);

            // Кликаем на ссылку
            notificationPage.clickClickHereLink();

            // Получаем текст уведомления
            String notificationText = notificationPage.getNotificationText();
            System.out.println("Текст уведомления: " + notificationText);

            // Проверяем, содержит ли текст "Action successful"
            if (notificationText.contains(expectedText)) {
                System.out.println("\n Найдено! Текст соответствует ожиданиям: '" + expectedText + "'");
                success = true;
                break;
            } else {
                System.out.println("Текст не соответствует. Продолжаем...\n");
            }
        }

        if (!success) {
            System.out.println("Не удалось получить '" + expectedText + "' за " + maxAttempts + " попыток");
        }

        System.out.println("\nВсего попыток: " + attempts);
    }

    @Override
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}