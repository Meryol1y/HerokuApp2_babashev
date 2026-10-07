package Tests;

import PageObjects.Typos;
import utils.SpellChecker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Test5 implements ITest {

    private WebDriver driver;
    private Typos typosPage;
    private SpellChecker spellChecker;

    @Override
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        typosPage = new Typos(driver);
        spellChecker = new SpellChecker();
    }

    @Override
    public void execute() {
        driver.get("http://the-internet.herokuapp.com/typos");

        System.out.println("=== Проверка орфографии параграфов ===\n");

        List<String> paragraphs = typosPage.getAllParagraphsAsList();

        System.out.println("Найдено параграфов: " + paragraphs.size());
        System.out.println();

        for (int i = 0; i < paragraphs.size(); i++) {
            String paragraphText = paragraphs.get(i);
            System.out.println("Параграф " + (i + 1) + ":");
            System.out.println(paragraphText);
            System.out.println();

            List<String> errors = spellChecker.checkText(paragraphText);

            if (errors.isEmpty()) {
                System.out.println("  ✅ Ошибок не найдено");
            } else {
                System.out.println("  ❌ Найдено ошибок: " + errors.size());
                for (String error : errors) {
                    System.out.println("     - " + error);
                }
            }
            System.out.println();
        }
        System.out.println("=".repeat(50));
        System.out.println("Проверка всех параграфов вместе:");
        String allText = typosPage.getAllParagraphsText();
        List<String> allErrors = spellChecker.checkText(allText);

        if (allErrors.isEmpty()) {
            System.out.println("✅ Ошибок не найдено!");
        } else {
            System.out.println("❌ Найдено ошибок: " + allErrors.size());
            for (int i = 0; i < allErrors.size(); i++) {
                System.out.println((i + 1) + ". " + allErrors.get(i));
            }
        }
    }

    @Override
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}