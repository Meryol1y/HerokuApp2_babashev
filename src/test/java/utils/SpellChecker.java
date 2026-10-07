package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class SpellChecker {

    // Словарь правильных слов для страницы Typos
    private static final Set<String> CORRECT_WORDS = new HashSet<>(Arrays.asList(
            "this", "example", "demonstrates", "a", "type", "being", "introduced",
            "it", "does", "randomly", "on", "each", "page", "load",
            "sometimes", "you'll", "see", "other", "times", "won't","you"
    ));

    public List<String> checkText(String text) {
        List<String> errors = new ArrayList<>();

        // Разбиваем текст на слова, убираем пунктуацию
        String[] words = text.toLowerCase()
                .replaceAll("[^a-z\\s']", " ")
                .split("\\s+");

        for (String word : words) {
            if (!word.isEmpty() && word.length() > 1 && !CORRECT_WORDS.contains(word)) {
                errors.add("Найдена опечатка: '" + word + "'");
            }
        }

        return errors;
    }

    public boolean hasErrors(String text) {
        return !checkText(text).isEmpty();
    }
}