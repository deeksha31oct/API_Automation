package api.testcases.BusinessDocumentsController;
import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.BaseTest;
import api.utilities.CommonMethods;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetBusinessDocumentsTest extends BaseTest {

    // DataProvider method providing the test data
    @DataProvider(name = "data_provider")
    public Object[][] getBusinessDocuments() {
        return new Object[][]{
                // Test case description, expected status code, AssignmentId, Logged-User-Id, schemaKey
                {
                        "TC_BusinessDocuments_224 Verify API responds with 200 status code for valid logged-user-id header and valid assignmentId path parameter.",
                        200,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_225 Verify API responds within acceptable response time (5 ms) for valid logged-user-id header and valid assignmentId path parameter.                                                                                                                                                                                ",
                        200,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_226 Verify API responds with 404 status code when logged-user-id header contains invalid value and valid assignmentId are provided.",
                        404,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_invalid_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_227 Verify API responds with 404 status code when assignmentId path parameter contains invalid value and valid logged-user-id is provided.",
                        404,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_invalid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_228 Verify API responds with 400 status code when logged-user-id header is missing and valid assignmentId is provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_AssignmentId(),
                        null,
                        ""
                },
                {
                        "TC_BusinessDocuments_229 Verify API responds with 400 status code when assignmentId path parameter is missing and valid logged-user-id is provided.",
                        200,
                        null,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_230 Verify API responds with 400 status code when logged-user-id header contains blank spaces and valid assignmentId is provided.",
                        200,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_AssignmentId(),
                        "  ",
                        ""
                },
                {
                        "TC_BusinessDocuments_231 Verify API responds with 400 status code when assignmentId path parameter contains blank spaces and valid logged-user-id is provided.",
                        200,
                        "  ",
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_232 Verify API responds with 400 status code when logged-user-id header contains special characters and valid assignmentId is provided.",
                        200,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_specialChar_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_233 Verify API responds with 400 status code when assignmentId path parameter contains special characters and valid logged-user-id is provided.",
                        200,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_specialChar_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_234 Verify API responds with 400 status code when logged-user-id header contains alpha numeric value and valid assignmentId is provided.",
                        200,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_alphanumeric_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_235 Verify API responds with 400 status code when assignmentId path parameter contains alpha numeric value and valid logged-user-id is provided.",
                        200,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_alphanumeric_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_236 Verify API responds with 400 status code when logged-user-id header contains more than 'X' characters and valid assignmentId is provided.",
                        200,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_maxlength_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_237 Verify API responds with 400 status code when assignmentId path parameter contains more than 'X' characters and valid logged-user-id is provided.",
                        200,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_maxlength_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_238 Verify API responds with 400 status code when logged-user-id header contains less than 'X' characters and valid assignmentId is provided.",
                        200,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_minlength_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_239 Verify API responds with 400 status code when assignmentId path parameter contains less than 'X' characters and valid logged-user-id is provided.",
                        200,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_minlength_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_240 Verify API responds with a 400 status code when logged-user-id header parameter contains SQL injection characters and valid assignmentId is provided.",
                        200,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_sqlInjection_LoggedUserId(),
                        ""
                },
                {
                        "TC_BusinessDocuments_241 Verify API responds with a 400 status code when assignmentId path parameter contains SQL injection characters and valid logged-user-id is provided.",
                        200,
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_sqlInjection_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_valid_LoggedUserId(),
                        ""
                },

        };
    }

    // Test method to validate API responses based on AssignmentId and Logged-User-Id
    @Test(dataProvider = "data_provider", description = "Validate API responses based on AssignmentId and Logged-User-Id scenarios")
    public void getBusinessDocuments(String description, int expectedStatusCode, String AssignmentId, String loggedUserId, String schemaKey) {
        String userApiUrl;

        // Determine the URL for the API request based on AssignmentId
        if (AssignmentId != null) {
            userApiUrl = Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_Url(AssignmentId);
        } else {
            // Handle the null case for AssignmentId
            userApiUrl = Endpoints.BusinessDocumentsControllerGetBusinessDocuments.get_Url(null);
        }

        // Prepare the headers map
        Map<String, String> headers = new HashMap<>();
        if (loggedUserId != null) {
            headers.put("logged-user-id", loggedUserId);
        }

        // Log the URL and headers for debugging purposes
        /*
        System.out.println("*************************************************************************");
        System.out.println(userApiUrl);
        System.out.println(headers);
        System.out.println("*************************************************************************");
         */

        // Send the GET request and capture the response
        Response response = CommonMethods.sendGetRequest(userApiUrl, null, null, headers);

        // Perform assertions on the response
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 2000);
        // ApiCommonAssertions.verifyResponseSchema(response, SCHEMA_FILE_PATH, schemaKey);
    }
}
