package api.testcases.PeopleController;
import api.endpoints.Endpoints;
import api.utilities.BaseTest;
import api.utilities.ApiCommonAssertions;
import api.utilities.CommonMethods;
import api.utilities.SchemaValidation;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
public class GetAssignmentsTest extends BaseTest
{
    // DataProvider method providing the test data
    @DataProvider(name = "GetAssignmentsTest_Dataprovider")
    public Object[][] GetAssignmentsTest_Dataprovider() {
        return new Object[][]{
                //TC_01
                {
                        "Verify API responds with 200 status code for valid topiaPersonID  and  valid logged-user-id  .",
                        200,
                        Endpoints.GetAssignments.get_valid_LoggedUserId(),
                        Endpoints.GetAssignments.get_valid_TopiaPersonId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_02
                {
                        "Verify API responds within acceptable response time (3 ms) for valid topiaPersonID  and  valid logged-user-id.",
                        200,
                        Endpoints.GetAssignments.get_valid_LoggedUserId(),
                        Endpoints.GetAssignments.get_valid_TopiaPersonId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_03
                {
                        "Verify API responds with 404 status code for invalid topiaPersonID  and  valid logged-user-id  ",
                        404,
                        Endpoints.GetAssignments.get_valid_LoggedUserId(),
                        Endpoints.GetAssignments.get_invalid_TopiaPersonId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_04
                {
                        "Verify API responds with 404 status code for valid topiaPersonID  and  invalid logged-user-id  ",
                        404,
                        Endpoints.GetAssignments.get_invalid_LoggedUserId(),
                        Endpoints.GetAssignments.get_valid_TopiaPersonId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_05
                {
                        "Verify API responds with 404 status code for invalid topiaPersonID  and  invalid logged-user-id  ",
                        404,
                        Endpoints.GetAssignments.get_invalid_LoggedUserId(),
                        Endpoints.GetAssignments.get_invalid_TopiaPersonId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_06
                {
                        "Verify API responds with 400 status code for missing  topiaPersonID  and  valid logged-user-id  ",
                        400,
                        Endpoints.GetAssignments.get_invalid_LoggedUserId(),
                        null,
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_07
                {
                        "Verify API responds with 400 status code for valid topiaPersonID  and  missing logged-user-id  ",
                        400,
                        null,
                        Endpoints.GetAssignments.get_valid_TopiaPersonId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_08
                {
                        "Verify API responds with 400 status code for  topiaPersonID  and logged-user-id both are missing   ",
                        400,
                        null,
                        null,
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_09
                {
                        "Verify API responds with 400 status code for blankspace topiaPersonID  and  valid logged-user-id   ",
                        400,
                        Endpoints.GetAssignments.get_invalid_LoggedUserId(),
                        " ",
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_10
                {
                        "Verify API responds with 400 status code for valid topiaPersonID  and  blankspace logged-user-id  ",
                        400,
                        " ",
                        Endpoints.GetAssignments.get_valid_TopiaPersonId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_11
                {
                        "Verify API responds with 400 status code for  topiaPersonID  and logged-user-id both are contain blankspace   ",
                        400,
                        " ",
                        " ",
                        "",
                        SchemaValidation.NOT_REQUIRED
                },

        };
    }
    // Test method to validate API responses based on AssignmentId and Logged-User-Id
    @Test(dataProvider = "GetAssignmentsTest_Dataprovider", description = "Validate API responses based on AssignmentId and Logged-User-Id scenarios")
    public void GetAssignments(String description, int expectedStatusCode, String loggedUserId, String TopiaPersonId, String schemaKey, SchemaValidation schemaValidation) {
        String apiEndpoint = Endpoints.GetAssignments.get_Url(TopiaPersonId);

        // Prepare the headers map
        Map<String, String> headers = new HashMap<>();
        if (loggedUserId != null) {
            headers.put("logged-user-id", loggedUserId);
        }



        // Log the URL and headers for debugging purposes
        System.out.println("*************************************************************************");
        System.out.println(apiEndpoint);
        System.out.println(headers);
        System.out.println("*************************************************************************");

        // Send the GET request and capture the response
        Response response = CommonMethods.sendGetRequest(apiEndpoint, null, null, headers);

        // Perform assertions on the response
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 3000);
        //    ApiCommonAssertions.verifyResponseSchema(response, SCHEMA_FILE_PATH, schemaKey);
    }
}
