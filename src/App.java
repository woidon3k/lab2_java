import java.util.List;

/**
 * Main application entry-point class (formerly LabRunner).
 *
 * Its only responsibility is to orchestrate the application flow:
 * 1. Set up
 * 2. Create services
 * 3. Call services to execute logic
 * 4. Print results
 */
public class App {

    /**
     * Main executable method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // --- Input text ---
        String inputText = "Anton \t Pasha Dima Bob Hank... orange Oval, Banana! Uber Is Evidens? An item.";

        // --- Create services/tools ---
        TextParser parser = new TextParser();
        TextOperationService textService = new TextOperationService();

        // --- Execute logic (Orchestration) ---
        System.out.println("-------------------------------------------------");
        Text text = parser.parse(inputText);
        System.out.println(text);
        System.out.println("-------------------------------------------------");

        List<Word> vowelWords = textService.findWordsStartingWithVowel(text);
        System.out.println(vowelWords);
        System.out.println("-------------------------------------------------");

        textService.sortWordsBySecondLetter(vowelWords);

        // --- Print final result ---
        System.out.println(vowelWords);
        System.out.println("-------------------------------------------------");
    }
}