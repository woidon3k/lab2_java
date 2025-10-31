import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a single word, composed of a list of Letter objects.
 * Implements ISentencePart so it can be part of a Sentence.
 */
public class Word implements ISenetencePart {

    private final List<Letter> letters;

    /**
     * Constructs a Word from a standard String.
     *
     * @param wordStr The string to convert into a Word object.
     */
    public Word(String wordStr) {
        this.letters = new ArrayList<>();
        for (char c : wordStr.toCharArray()) {
            this.letters.add(new Letter(c));
        }
    }

    /**
     * Constructs a Word from a pre-made list of Letters.
     *
     * @param letters The list of Letter objects.
     */
    public Word(List<Letter> letters) {
        this.letters = new ArrayList<>(letters);
    }

    /**
     * Gets the list of Letters that make up this word.
     *
     * @return A list of Letter objects.
     */
    public List<Letter> getLetters() {
        return letters;
    }

    /**
     * Checks if the word starts with a vowel.
     *
     * @return true if the word is not empty and its first letter is a vowel, false otherwise.
     */
    public boolean startsWithVowel() {
        return !letters.isEmpty() && letters.get(0).isVowel();
    }

    /**
     * Gets the second letter of the word as a Character.
     *
     * @return The second Character, or null if the word has fewer than 2 letters.
     */
    public Character getSecondLetter() {
        if (letters.size() < 2) {
            return null;
        }
        return letters.get(1).getCharacter();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.toString());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(letters, word.letters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letters);
    }
}