package api.testcases.TransactionController;

import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.BaseTest;
import api.utilities.CommonMethods;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetAssignmentTotalsTest extends BaseTest {

    @DataProvider(name = "data_provider")
    public Object[][] getTestCases() {
        return new Object[][]{
                {
                        "Verify API responds with 200 status code for valid assignmentId path parameter and default currencyCode query parameter.",
                        200,
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_AssignmentId(),
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_currencyCode(),
                        ""
                },
                {
                        "Verify API responds with 200 status code for valid assignmentId path and on-default value in currencyCode query parameter.",
                        200,
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_AssignmentId(),
                        Endpoints.TransactionControllerGetAssignmentTotals.get_nonDeafult_currencyCode(),
                        ""
                },
                {
                        "Verify API responds within acceptable response time (5 ms) for valid assignmentId path parameter.",
                        200,
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_AssignmentId(),
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_currencyCode(),
                        ""
                },
                {
                        "Verify API responds with 404 status code when invalid assignmentId path parameter is provided.",
                        404,
                        Endpoints.TransactionControllerGetAssignmentTotals.get_invalid_AssignmentId(),
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_currencyCode(),
                        ""
                },
                {
                        "Verify API responds with 400 status code when assignmentId path parameter is missing.",
                        400,
                        null,
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_currencyCode(),
                        ""
                },
                {
                        "Verify API responds with 400 status code when special characters are provided in assignmentId path parameter.",
                        400,
                        Endpoints.TransactionControllerGetAssignmentTotals.get_specialChar_AssignmentId(),
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_currencyCode(),
                        ""
                },
                {
                        "Verify API responds with 400 status code when less than 5 characters are provided in assignmentId path parameter.",
                        400,
                        Endpoints.TransactionControllerGetAssignmentTotals.get_minlength_AssignmentId(),
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_currencyCode(),
                        ""
                },
                {
                        "Verify API responds with 400 status code when more than 5 characters are provided in assignmentId path parameter.",
                        400,
                        Endpoints.TransactionControllerGetAssignmentTotals.get_maxlength_AssignmentId(),
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_currencyCode(),
                        ""
                },
                {
                        "Verify API responds with 400 status code when blank spaces are provided in assignmentId path parameter.",
                        400,
                        "  ",
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_currencyCode(),
                        ""
                },
                {
                        "Verify API responds with 400 status code when alphanumeric characters are provided in assignmentId path parameter.",
                        400,
                        Endpoints.TransactionControllerGetAssignmentTotals.get_alphanumeric_AssignmentId(),
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_currencyCode(),
                        ""
                },
                {
                        "Verify API responds with 400 status code when SQL-Injection characters are provided in assignmentId path parameter.",
                        400,
                        Endpoints.TransactionControllerGetAssignmentTotals.get_sqlInjection_AssignmentId(),
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_currencyCode(),
                        ""
                },
                {
                        "Verify API responds with 400 status code when integer value is provided in currencyCode query parameter with a valid assignmentId.",
                        400,
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_AssignmentId(),
                        Endpoints.TransactionControllerGetAssignmentTotals.get_numeric_currencyCode(),
                        ""
                },
                {
                        "Verify API responds with 400 status code when special characters are provided in currencyCode query parameter with a valid assignmentId.",
                        400,
                        Endpoints.TransactionControllerGetAssignmentTotals.get_valid_AssignmentId(),
                        Endpoints.TransactionControllerGetAssignmentTotals.get_specialChar_currencyCode(),
                        ""
                }
        };
    }

    @Test(dataProvider = "data_provider", description = "Validate API responses based on AssignmentId and currencyCode scenarios")
    public void getAssignmentTotals(String description, int expectedStatusCode, String assignmentId, String currencyCode, String schemaKey) {
        String userApiUrl;

        // Determine the URL for the API request based on AssignmentId
        if (assignmentId != null) {
            userApiUrl = Endpoints.TransactionControllerGetAssignmentTotals.get_Url(assignmentId);
        } else {
            userApiUrl = Endpoints.TransactionControllerGetAssignmentTotals.get_Url(null);
        }

        // Prepare the query params map
        Map<String, String> queryParams = new HashMap<>();
        if (currencyCode != null) {
            queryParams.put("currencyCode", currencyCode);
        }

        // Log the URL and headers for debugging purposes
        /*
        System.out.println("*************************************************************************");
        System.out.println(userApiUrl);
        System.out.println(queryParams);
        System.out.println("*************************************************************************");
        */
        // Send the GET request and capture the response
        Response response = CommonMethods.sendGetRequest(userApiUrl, queryParams, null, null);

        // Perform assertions on the response
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 2000);
        // ApiCommonAssertions.verifyResponseSchema(response, SCHEMA_FILE_PATH, schemaKey);
    }
}
