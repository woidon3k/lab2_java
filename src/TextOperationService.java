import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A service class that contains the core business logic
 * for processing Text and Word objects.
 * This separates the logic from the application's entry point (App.java).
 */
public class TextOperationService {

    /**
     * Traverses a Text object and finds all words that start with a vowel.
     * (Task C3 = 0: Знайти всі слова, що починаються з голосної)
     *
     * @param text The Text object to search.
     * @return A new List containing all words that start with a vowel.
     */
    public List<Word> findWordsStartingWithVowel(Text text) {
        List<Word> vowelWords = new ArrayList<>();

        // Iterate through each sentence
        for (Sentence sentence : text.getSentences()) {
            // Iterate through each part of the sentence
            for (ISenetencePart part : sentence.getParts()) {
                // Check if the part is a Word
                if (part instanceof Word) {
                    Word word = (Word) part;
                    // Use the Word's own logic to check for a vowel
                    if (word.startsWithVowel()) {
                        vowelWords.add(word);
                    }
                }
            }
        }
        return vowelWords;
    }

    /**
     * Sorts a list of Word objects in place, in ascending order
     * based on their second letter.
     * (Task C17 = 7: сортувати за другою літерою)
     *
     * @param words The list of Words to sort (this list WILL be modified).
     */
    public void sortWordsBySecondLetter(List<Word> words) {
        // Use a Comparator to define the custom sorting logic
        Comparator<Word> bySecondLetter = Comparator.comparing(
            Word::getSecondLetter,
            // Handle nulls (words with < 2 letters) by placing them first
            Comparator.nullsFirst(
                // Compare letters case-insensitively
                // (FIXED: Character::compareToIgnoreCase did not exist)
                // We create a case-insensitive comparator by comparing the uppercase versions.
                Comparator.comparing(Character::toUpperCase)
            )
        );

        words.sort(bySecondLetter);
    }
}


