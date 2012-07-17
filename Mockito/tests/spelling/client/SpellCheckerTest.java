package spelling.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import spelling.Word;
import spelling.common.WordChecker;

public class SpellCheckerTest {

    @Test
    public void checkCorrectlySpelledWord() {
        SpellChecker speller = makeSpellCheckerReturnCorrectlySpelledWord("testing");

        final Word checkedWord = speller.check();

        assertNotNull(checkedWord);
        assertEquals("testing", checkedWord.getWord());
        assertTrue(checkedWord.getSuggestions().isEmpty());
    }

    @Test
    public void checkMissppelledWord() {
        SpellChecker speller = makeSpellCheckerReturnMisspelledWord("testing");

        final Word checkedWord = speller.check();

        assertNotNull(checkedWord);
        assertEquals("testing", checkedWord.getWord());
        assertEquals("suggestedword", checkedWord.getSuggestions().get(0));
    }

    @Test(expected = ResourceException.class)
    public void checkCannotConnectToServer() {
        SpellChecker speller = makeSpellCheckerFailToConnect();

        speller.check();
    }

    private static SpellChecker makeSpellCheckerReturnCorrectlySpelledWord(String testWord) {
        WordChecker wordChecker = mock(WordChecker.class);

        Word checkedWord = new Word(testWord);

        when(wordChecker.checkSpelling()).thenReturn(checkedWord);

        return new SpellChecker(wordChecker);
    }

    private static SpellChecker makeSpellCheckerReturnMisspelledWord(String testWord) {
        WordChecker wordChecker = mock(WordChecker.class);

        Word correctedWord = new Word(testWord);
        correctedWord.addSuggestion("suggestedword");

        when(wordChecker.checkSpelling()).thenReturn(correctedWord);

        return new SpellChecker(wordChecker);
    }

    private static SpellChecker makeSpellCheckerFailToConnect() {
        WordChecker wordChecker = mock(WordChecker.class);

        when(wordChecker.checkSpelling()).thenThrow(
                new ResourceException(Status.CONNECTOR_ERROR_COMMUNICATION, "Can't find the server"));

        return new SpellChecker(wordChecker);
    }

}
