package api.testcases.SavedSearchController;

import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.CommonMethods;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.util.Map;

public class GetSavesSearchesForViewTableGetTest {

    @DataProvider(name = "savedSearchTestCases")
    public Object[][] savedSearchTestCases() {
        return new Object[][]{
                {"Verify response with valid viewTableCode and valid CustomerCode.", Endpoints.savedSearchController.getValidViewTableCode(), 200, Endpoints.savedSearchController.getValidCustomerCode(), "ValidViewTableCodeAndCustomerCode"},
                {"Verify response with valid viewTableCode and missing CustomerCode.", Endpoints.savedSearchController.getValidViewTableCode(), 400, null, "ValidViewTableCodeAndMissingCustomerCode"},
                {"Verify response with invalid viewTableCode and valid CustomerCode.", Endpoints.savedSearchController.getInvalidViewTableCode(), 404, Endpoints.savedSearchController.getValidCustomerCode(), "InvalidViewTableCodeAndValidCustomerCode"},
                {"Verify response with viewTableCode containing blank spaces and valid CustomerCode.", Endpoints.savedSearchController.getViewTableCodeWithSpaces(), 404, Endpoints.savedSearchController.getValidCustomerCode(), "ViewTableCodeWithSpacesAndValidCustomerCode"},
                {"Verify error response when viewTableCode is blank.", Endpoints.savedSearchController.getBlankViewTableCode(), 400, Endpoints.savedSearchController.getValidCustomerCode(), "BlankViewTableCodeAndValidCustomerCode"},
                {"Verify error response when CustomerCode is blank.", Endpoints.savedSearchController.getValidViewTableCode(), 400, Endpoints.savedSearchController.getBlankCustomerCode(), "ValidViewTableCodeAndBlankCustomerCode"},
                {"Verify response with both viewTableCode and CustomerCode missing.", null, 400, null, "MissingViewTableCodeAndCustomerCode"},
                {"Verify response time with valid viewTableCode and valid CustomerCode.", Endpoints.savedSearchController.getValidViewTableCode(), 200, Endpoints.savedSearchController.getValidCustomerCode(), "ResponseTimeWithValidViewTableCodeAndCustomerCode"},
                {"Verify response with viewTableCode containing special characters and maximum length, and valid CustomerCode.", Endpoints.savedSearchController.getSpecialCharViewTableCode(), 400, Endpoints.savedSearchController.getValidCustomerCode(), "SpecialCharMaxLengthViewTableCodeAndValidCustomerCode"}
        };
    }

    @Test(dataProvider = "savedSearchTestCases", description = "Validate Saved Search API responses for various viewTableCode and CustomerCode scenarios")
    public void savedSearchControllerTest(String description, String viewTableCode, int expectedStatusCode, String customerCode, String schemaKey) {
        String savedSearchApiUrl = Endpoints.savedSearchController.getSavedSearchUrl(
                viewTableCode != null ? viewTableCode : ""
        );
        Map<String, String> headers = customerCode != null
                ? Map.of("customerCode", customerCode)
                : Map.of(); // Empty headers if customerCode is null for missing case
        Response response = CommonMethods.sendGetRequest(savedSearchApiUrl, null, null, headers);
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 5000);
        // ApiCommonAssertions.verifyResponseSchema(response, SCHEMA_FILE_PATH, schemaKey);
    }
}


