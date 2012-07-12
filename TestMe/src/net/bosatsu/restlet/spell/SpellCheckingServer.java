package net.bosatsu.restlet.spell;

import java.io.File;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

import com.swabunga.spell.engine.GenericSpellDictionary;
import com.swabunga.spell.engine.SpellDictionary;
import com.swabunga.spell.event.SpellChecker;

/**
 * Based off the example from http://www.javaworld.com/javaworld/jw-12-2008/jw-12-rest-series-2.html
 */
public class SpellCheckingServer extends Application {
    public static String dictionary = "/combined.dic";
    public static SpellDictionary spellingDict;
    public static SpellChecker spellChecker;
    public static Restlet spellCheckerRestlet;

    static {
        try {
            spellingDict = new GenericSpellDictionary(new File(SpellCheckingServer.class.getResource(dictionary)
                    .getFile()));
            spellChecker = new SpellChecker(spellingDict);
            spellCheckerRestlet = new SpellCheckerRestlet(spellChecker);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8182);

        SpellCheckingServer spellingService = new SpellCheckingServer();
        component.getDefaultHost().attach("", spellingService);
        component.start();
    }

    @Override
    public Restlet createRoot() {
        Router router = new Router(getContext());
        router.attach("/spellchecker/{word}", spellCheckerRestlet);
        return router;
    }
}