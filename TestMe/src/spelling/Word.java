package spelling;

import java.util.ArrayList;
import java.util.List;

public class Word {

    private String word;

    private final List<String> suggestions = new ArrayList<String>();

    public Word() {
    }

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getSuggestions() {
        return this.suggestions;
    }

    public void addSuggestion(String word) {
        this.suggestions.add(word);
    }

    public boolean isCorrect() {
        return this.suggestions.isEmpty();
    }

    /* private */void setCorrect(boolean correct) {
        // elegant workaround since Jackson wants a setter but we don't really need one
    }

    @Override
    public String toString() {
        return "word=" + this.word + ", suggestions=" + this.suggestions;
    }

}
