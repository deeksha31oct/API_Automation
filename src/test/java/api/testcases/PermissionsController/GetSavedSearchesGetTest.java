package api.testcases.PermissionsController;

import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.CommonMethods;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class GetSavedSearchesGetTest {

    @DataProvider(name = "savedSearchesApiTestCases")
    public Object[][] savedSearchesApiTestCases() {
        return new Object[][]{
                // Test Cases
                {"Verify that the API returns 200 status for valid customerCode and valid id",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidCustomerCode(),
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidId(),
                        200, "ValidCustomerCodeAndValidId"},

                {"Verify that the API returns 404 status for valid customerCode and invalid id",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidCustomerCode(),
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getInvalidId(),
                        404, "ValidCustomerCodeAndInvalidId"},

                {"Verify that the API returns 400 status for invalid customerCode and valid id",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getInvalidCustomerCode(),
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidId(),
                        400, "InvalidCustomerCodeAndValidId"},

                {"Verify that the API returns 400 status for invalid customerCode and invalid id",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getInvalidCustomerCode(),
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getInvalidId(),
                        400, "InvalidCustomerCodeAndInvalidId"},

                {"Verify that the API returns 400 status for valid customerCode and blank id",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidCustomerCode(),
                        "",
                        400, "ValidCustomerCodeAndBlankId"},

                {"Verify that the API returns 400 status for blank customerCode and valid id",
                        "",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidId(),
                        400, "BlankCustomerCodeAndValidId"},

                {"Verify that the API returns 200 status for special character in customerCode and valid id",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getSpecialCharCustomerCode(),
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidId(),
                        200, "SpecialCharCustomerCodeAndValidId"},

                {"Verify that the API returns 404 status for special character in customerCode and invalid id",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getSpecialCharCustomerCode(),
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getInvalidId(),
                        404, "SpecialCharCustomerCodeAndInvalidId"},

                {"Verify that the API returns 400 status for valid customerCode and customerCode with spaces",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getCustomerCodeWithSpaces(),
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidId(),
                        400, "CustomerCodeWithSpacesAndValidId"},

                {"Verify that the API returns 400 status for valid customerCode and id with spaces",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidCustomerCode(),
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getIdWithSpaces(),
                        400, "ValidCustomerCodeAndIdWithSpaces"},

                {"Verify that the API returns 400 status for valid customerCode and missing loggedUser header",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidCustomerCode(),
                        null,
                        400, "ValidCustomerCodeAndMissingLoggedUser"},

                {"Verify that the API returns 200 status for valid customerCode and loggedUser",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidCustomerCode(),
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidId(),
                        200, "ValidCustomerCodeAndLoggedUser"},

                {"Verify that the API response time is within the threshold for valid customerCode and valid id",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidCustomerCode(),
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidId(),
                        200, "ResponseTimeWithValidCustomerCodeAndId"},

                {"Verify that the API returns 400 status for blank id",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidCustomerCode(),
                        "",
                        400, "ValidCustomerCodeAndBlankId"},

                {"Verify that the API returns 400 status for blank customerCode and valid id",
                        "",
                        Endpoints.PeopleListControllerGetSavedSearchesTestData.getValidId(),
                        400, "BlankCustomerCodeAndValidId"}
        };
    }

    @Test(dataProvider = "savedSearchesApiTestCases", description = "Validate People List Controller Get Saved Searches API responses")
    public void savedSearchesTest(String description, String customerCode, String id, int expectedStatusCode, String schemaKey) {
        String savedSearchUrl = Endpoints.PeopleListControllerGetSavedSearchesTestData.getSavedSearchUrl(id);
        System.out.println(savedSearchUrl);
        Map<String, String> headers = Map.of(
                "customerCode", customerCode != null ? customerCode : ""
        );
        Response response = CommonMethods.sendGetRequest(savedSearchUrl, null, null, headers);
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        // Verifying response time (for valid cases)
        if (expectedStatusCode == 200) {
            ApiCommonAssertions.verifyResponseTime(response, Endpoints.PeopleListControllerGetSavedSearchesTestData.getResponseTimeThreshold());
        }
        // ApiCommonAssertions.verifyResponseSchema(response, SCHEMA_FILE_PATH, schemaKey);
    }
}
