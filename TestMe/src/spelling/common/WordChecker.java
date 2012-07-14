package spelling.common;

import org.restlet.resource.Get;

import spelling.Word;

public interface WordChecker {

    @Get
    Word checkSpelling();

}
