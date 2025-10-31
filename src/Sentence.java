import java.util.List;
import java.util.Objects;

/**
 * Represents a sentence, composed of a list of ISentencePart objects
 * (which can be Words or Punctuation).
 */
public class Sentence {

    private final List<ISenetencePart> parts;

    /**
     * Constructs a new Sentence.
     *
     * @param parts A list of Words and/or Punctuation objects.
     */
    public Sentence(List<ISenetencePart> parts) {
        this.parts = List.copyOf(parts); // Make it immutable
    }

    /**
     * Gets all parts of the sentence (Words and Punctuation).
     *
     * @return An immutable list of ISentencePart.
     */
    public List<ISenetencePart> getParts() {
        return parts;
    }

    /**
     * Reconstructs the sentence as a readable string.
     * It intelligently handles spacing, placing spaces *before* words
     * but not before punctuation.
     *
     * @return A string representation of the sentence.
     */
    @Override
    public String toString() {
        if (parts.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        // Append the first part directly
        sb.append(parts.get(0).toString());

        // Iterate from the second part
        for (int i = 1; i < parts.size(); i++) {
            ISenetencePart current = parts.get(i);
            
            // If the current part is punctuation, append it directly.
            if (current instanceof Punctuation) {
                sb.append(current.toString());
            } else {
                // If it's a word, add a space before it.
                sb.append(" ").append(current.toString());
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(parts, sentence.parts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parts);
    }
}