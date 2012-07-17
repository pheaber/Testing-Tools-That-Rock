package spelling.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import spelling.Word;
import spelling.common.WordChecker;

public class SpellCheckerTest {

    private static final String BASE = "http://localhost:8182";

    @Test
    public void check() {
        SpellChecker speller = getSpellChecker("testing");

        final Word checkedWord = speller.check();

        assertNotNull(checkedWord);
        assertEquals("testing", checkedWord.getWord());
        assertTrue(checkedWord.getSuggestions().isEmpty());
    }

    @Test
    public void checkMissppelledWord() {
        SpellChecker speller = getSpellChecker("tesing");

        final Word checkedWord = speller.check();

        assertNotNull(checkedWord);
        assertEquals("tesing", checkedWord.getWord());
        assertEquals("teasing", checkedWord.getSuggestions().get(0));
    }

    @Test(expected = ResourceException.class)
    public void checkCannotConnectToServer() {
        SpellChecker speller = getSpellChecker("tesing");

        speller.check();
    }

    private static SpellChecker getSpellChecker(String testWord) {
        WordChecker wordChecker = ClientResource.create(BASE + "/spellchecker/" + testWord, WordChecker.class);
        return new SpellChecker(wordChecker);
    }

}
