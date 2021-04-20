package search;

import org.testng.annotations.Test;
import utilities.Basic;

import static search.SearchService.verifyGetResponse;

public class Search extends Basic {

    @Test(dataProviderClass = SearchDataProvider.class, dataProvider = "paramsForSuccessfulFindElements",
            description = "Find existing record.")
    public void findExistingRecord(String additionalQueryParam) {
        verifyGetResponse("search?query=fish" + additionalQueryParam, 200,
                "schemas/search/successfulSearch.json");
    }

    @Test(dataProviderClass = SearchDataProvider.class, dataProvider = "paramsForEmptyResponse",
            description = "Cases, when endpoint returns 200 and empty json.")
    public void emptyResponse(String value) {
        verifyGetResponse("search?query=" + value, 200,
                "schemas/search/emptyResponse.json");
    }

    @Test(dataProviderClass = SearchDataProvider.class, dataProvider = "unsupportedMethods",
            description = "Unsupported methods with & without query string")
    public void unsupportedMethods(String query, String method) {
        SearchService.verifyUnsupportedMethods(method, query, 404);
    }

}
