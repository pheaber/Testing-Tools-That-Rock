package net.bosatsu.restlet.spell;

import java.util.Iterator;
import java.util.List;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

import com.swabunga.spell.engine.Word;
import com.swabunga.spell.event.SpellChecker;

/**
 * Based off the example from http://www.javaworld.com/javaworld/jw-12-2008/jw-12-rest-series-2.html
 */
public class SpellCheckerRestlet extends Restlet {
	
    private final SpellChecker spellChecker;

    public SpellCheckerRestlet(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    @Override
    public void handle(Request request, Response response) {
        String word = (String) request.getAttributes().get("word");
        if (request.getMethod().equals(Method.GET)) {
            if (this.spellChecker.isCorrect(word)) {
                response.setStatus(Status.SUCCESS_NO_CONTENT);
            } else {
                String resp = null;
                StringBuilder sb = new StringBuilder();
                @SuppressWarnings("unchecked")
                List<Word> l = this.spellChecker.getSuggestions(word, 5);
                Iterator<Word> itor = l.iterator();

                while (itor.hasNext()) {
                    Word w = itor.next();
                    // Obviously hard-coding the URL like this is bad. Use the API to discover
                    // the actual HTTP context and build off of that.
                    sb.append("http://localhost:8182/spellchecker/");
                    sb.append(w.getWord());
                    sb.append("\n");
                }
                resp = sb.toString();
                response.setEntity(resp, MediaType.TEXT_PLAIN);
            }
        } else {
            response.setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
        }
    }
    
}