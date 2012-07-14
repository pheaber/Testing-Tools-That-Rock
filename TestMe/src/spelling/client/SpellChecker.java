package spelling.client;

import org.restlet.resource.ClientResource;

import spelling.Word;
import spelling.common.WordChecker;

public class SpellChecker {

    private static final String BASE = "http://localhost:8182";

    private final WordChecker wordChecker;

    public SpellChecker(WordChecker wordChecker) {
        this.wordChecker = wordChecker;
    }

    public Word check() {
        return this.wordChecker.checkSpelling();
    }

    public static void main(String[] args) {
        final String[] wordsToCheck = { "Omaha", "Java", "Users", "Group" };

        for (String word : wordsToCheck) {
            WordChecker wordChecker = ClientResource.create(BASE + "/spellchecker/" + word, WordChecker.class);
            SpellChecker spellChecker = new SpellChecker(wordChecker);

            System.out.println("Checking " + word + ": " + spellChecker.check());
        }
    }
}
