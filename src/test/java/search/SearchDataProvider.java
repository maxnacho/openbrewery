package search;

import org.testng.annotations.DataProvider;

import static utilities.Randomizer.Mode.*;
import static utilities.Randomizer.generateString;

public class SearchDataProvider {

    @DataProvider(name = "paramsForSuccessfulFindElements")
     static Object[][] paramsForSuccessfulFindElements() {
        return new String[][]{
                new String[]{""},
                new String[]{" Dr"},
                new String[]{"&fake=value"}
        };
    }

    @DataProvider(name = "paramsForEmptyResponse")
    static Object[][] paramsForEmptyResponse() {
        return new String[][]{
                new String[]{""},
                new String[]{generateString(5, CYRILLIC)},
                new String[]{generateString(3, CYRILLIC) + " " + generateString(2, CYRILLIC)},
                new String[]{generateString(257, ALPHA)},
                new String[]{generateString(257, ALPHANUMERIC)},
                new String[]{generateString(257, NUMERIC)}
        };
    }

    @DataProvider(name = "unsupportedMethods")
    static Object[][] unsupportedMethods() {
        return new String[][]{
                new String[]{"?query=fish", "post"},
                new String[]{"?query=fish", "put"},
                new String[]{"?query=fish", "delete"},
                new String[]{"", "post"},
                new String[]{"", "put"},
                new String[]{"", "delete"},
        };
    }
}
