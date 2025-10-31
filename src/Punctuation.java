import java.util.Objects;

/**
 * Represents a single punctuation mark.
 * Implements ISentencePart so it can be part of a Sentence.
 */
public class Punctuation implements ISenetencePart {

    private final char mark;

    /**
     * Constructs a new Punctuation object.
     *
     * @param mark The punctuation character (e.g., '.', ',', '!').
     */
    public Punctuation(char mark) {
        this.mark = mark;
    }

    /**
     * Gets the punctuation character.
     *
     * @return The punctuation mark.
     */
    public char getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return String.valueOf(mark);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punctuation that = (Punctuation) o;
        return mark == that.mark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark);
    }
}