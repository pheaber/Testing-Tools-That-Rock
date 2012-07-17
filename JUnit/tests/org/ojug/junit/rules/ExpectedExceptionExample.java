package org.ojug.junit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Wholly "borrowed" from
 * https://raw.github.com/KentBeck/junit/23ffc6baf5768057e366e183e53f4dfa86fbb005/doc/ReleaseNotes4.7.txt
 */
public class ExpectedExceptionExample {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwsNothing() {

    }

    @Test
    public void throwsNullPointerException() {
        this.thrown.expect(NullPointerException.class);

        throw new NullPointerException();
    }

    @Test
    public void throwsNullPointerExceptionWithMessage() {
        this.thrown.expect(NullPointerException.class);
        this.thrown.expectMessage("happened?"); // this is a contains, there is another that uses a Matcher

        throw new NullPointerException("What happened?");
    }

}
