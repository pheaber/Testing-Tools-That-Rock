package spelling.server;

import java.io.File;
import java.util.List;

import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import spelling.Word;
import spelling.common.WordChecker;

import com.swabunga.spell.engine.GenericSpellDictionary;
import com.swabunga.spell.engine.SpellDictionary;
import com.swabunga.spell.event.SpellChecker;

/**
 * Roughly based off the example from http://www.javaworld.com/javaworld/jw-12-2008/jw-12-rest-series-2.html
 */
public class WordManagerResource extends ServerResource implements WordChecker {

    private static final String DICTIONARY = "/sowpods.txt";
    // private static final String DICTIONARY = "/combined.dic";

    private static final SpellChecker SPELL_CHECKER;

    static {
        try {
            SpellDictionary spellingDictionary = new GenericSpellDictionary(new File(WordManagerResource.class
                    .getResource(DICTIONARY).getFile()));
            SPELL_CHECKER = new SpellChecker(spellingDictionary);
        } catch (Exception e) {
            throw new RuntimeException("Unable to find dictionary: " + DICTIONARY, e);
        }
    }

    private String word;

    /**
     * Retrieve the identifier based on the URI path variable "username" declared in the URI template attached to the
     * application router.
     */
    @Override
    protected void doInit() throws ResourceException {
        this.word = (String) getRequestAttributes().get("word");
    }

    @Override
    public Word checkSpelling() {
        Word checkedWord = new Word(this.word);

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": Checking " + this.word);

        if (!SPELL_CHECKER.isCorrect(this.word)) {
            @SuppressWarnings("unchecked")
            List<com.swabunga.spell.engine.Word> suggestions = SPELL_CHECKER.getSuggestions(this.word, 5);

            for (com.swabunga.spell.engine.Word suggestion : suggestions) {
                checkedWord.addSuggestion(suggestion.getWord());
            }
        }

        System.out.println(threadName + ": Found " + checkedWord);

        return checkedWord;
    }

}
