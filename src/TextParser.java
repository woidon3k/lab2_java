import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A utility class for parsing a raw string into a Text object.
 * Handles space/tab normalization and splitting into model objects.
 */
public class TextParser {

    // Regex to find either a word (\w+) or a punctuation mark ([.,!?:;])
    private static final Pattern SENTENCE_PART_PATTERN = Pattern.compile("(\\w+)|([.,!?:;])");

    /**
     * Parses a raw text string into a structured Text object.
     *
     * @param rawText The input string.
     * @return A Text object.
     */
    public Text parse(String rawText) {
        // Step 1: Normalize whitespace (replace tabs and multiple spaces with a single space)
        String processedText = rawText.trim().replaceAll("[ \\t]+", " ");

        // Step 2: Split the text into sentence strings.
        // This regex splits *after* a sentence-ending punctuation mark, keeping the mark.
        String[] sentenceStrings = processedText.split("(?<=[.!?])\\s*");

        List<Sentence> sentences = new ArrayList<>();
        for (String s : sentenceStrings) {
            if (!s.isBlank()) {
                sentences.add(parseSentence(s));
            }
        }
        return new Text(sentences);
    }

    /**
     * Helper method to parse a single sentence string into a Sentence object.
     *
     * @param sentenceStr The string for a single sentence.
     * @return A Sentence object.
     */
    private Sentence parseSentence(String sentenceStr) {
        List<ISenetencePart> parts = new ArrayList<>();
        Matcher matcher = SENTENCE_PART_PATTERN.matcher(sentenceStr);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                // Group 1 is the word
                parts.add(new Word(matcher.group(1)));
            } else if (matcher.group(2) != null) {
                // Group 2 is the punctuation
                parts.add(new Punctuation(matcher.group(2).charAt(0)));
            }
        }
        return new Sentence(parts);
    }
}