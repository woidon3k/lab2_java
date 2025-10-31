import java.util.Objects;

/**
 * Represents a single letter (character).
 */
public class Letter {

    private static final String VOWELS = "AEIOUaeiou";

    private final char character;

    /**
     * Constructs a new Letter.
     *
     * @param character The character for this letter.
     */
    public Letter(char character) {
        this.character = character;
    }

    /**
     * Gets the underlying character.
     *
     * @return The character.
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Checks if this letter is a vowel.
     *
     * @return true if the letter is a vowel (upper or lower case), false otherwise.
     */
    public boolean isVowel() {
        return VOWELS.indexOf(this.character) != -1;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return character == letter.character;
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }
}