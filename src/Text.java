import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Represents a full text, composed of a list of Sentence objects.
 */
public class Text {

    private final List<Sentence> sentences;

    /**
     * Constructs a new Text.
     *
     * @param sentences A list of Sentence objects.
     */
    public Text(List<Sentence> sentences) {
        this.sentences = List.copyOf(sentences); // Make it immutable
    }

    /**
     * Gets all sentences in the text.
     *
     * @return An immutable list of Sentences.
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Reconstructs the entire text by joining sentences with a space.
     *
     * @return A string representation of the full text.
     */
    @Override
    public String toString() {
        return sentences.stream()
                .map(Sentence::toString)
                .collect(Collectors.joining(" "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(sentences, text.sentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentences);
    }
}