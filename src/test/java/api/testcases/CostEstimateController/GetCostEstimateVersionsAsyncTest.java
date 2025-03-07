package api.testcases.CostEstimateController;
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
public class GetCostEstimateVersionsAsyncTest extends BaseTest
{
    // DataProvider method providing the test data
    @DataProvider(name = "GetCostEstimateVersionsAsyncTest_Dataprovider")
    public Object[][] GetCostEstimateVersionsAsyncTest_Dataprovider() {
        return new Object[][]{
                //TC_01
                {
                        "Verify API responds with 200 status code for valid logged-user-id, valid customerCode, and valid moveId path parameter.",
                        200,
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_customerCode(),
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_logged_user_id(),
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_MoveId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_02
                {
                        "Verify API responds within acceptable response time (5 ms) for valid logged-user-id, valid customerCode, and valid moveId path parameter.",
                        200,
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_customerCode(),
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_logged_user_id(),
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_MoveId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_03
                {
                        "Verify API responds with 404 status code for invalid logged-user-id, valid customerCode, and valid moveId path parameter",
                        404,
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_customerCode(),
                        Endpoints.GetCostEstimateVersionsAsync.get_invalid_logged_user_id(),
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_MoveId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_04
                {
                        "Verify API responds with 404 status code for valid logged-user-id, invalid customerCode, and valid moveId path parameter.",
                        404,
                        Endpoints.GetCostEstimateVersionsAsync.get_invalid_customerCode(),
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_logged_user_id(),
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_MoveId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_05
                {
                        "Verify API responds with 404 status code for valid logged-user-id, valid customerCode, and invalid moveId path parameter.",
                        404,
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_customerCode(),
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_logged_user_id(),
                        Endpoints.GetCostEstimateVersionsAsync.get_invalid_MoveId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_06
                {
                        "Verify API responds with 404 status code for invalid logged-user-id, invalid customerCode, and invalid moveId path parameter.",
                        404,
                        Endpoints.GetCostEstimateVersionsAsync.get_invalid_customerCode(),
                        Endpoints.GetCostEstimateVersionsAsync.get_invalid_logged_user_id(),
                        Endpoints.GetCostEstimateVersionsAsync.get_invalid_MoveId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_07
                {
                        "Verify API responds with 400 status code for missing logged-user-id, valid customerCode, and valid moveId path parameter.",
                        400,
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_customerCode(),
                        null,
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_MoveId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_08
                {
                        "Verify API responds with 400 status code for valid logged-user-id, missing customerCode, and valid moveId path parameter.",
                        400,
                        null,
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_logged_user_id(),
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_MoveId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_09
                {
                        "Verify API responds with 400 status code for valid logged-user-id, valid customerCode, and missing moveId path parameter.",
                        400,
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_customerCode(),
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_logged_user_id(),
                        null,
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_10
                {
                        "Verify API responds with 400 status code for logged-user-id,  customerCode, and  moveId path parameter are missing ",
                        400,
                        null,
                        null,
                       null,
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_11
                {
                        "Verify API responds with 400 status code for  logged-user-id contain blankspace, valid customerCode, and valid moveId path parameter.",
                        400,
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_customerCode(),
                        " ",
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_MoveId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_12
                {
                        "Verify API responds with 400 status code for valid logged-user-id, customerCode contain blankspace, and valid moveId path parameter..",
                        400,
                        " ",
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_logged_user_id(),
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_MoveId(),
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_13
                {
                        "Verify API responds with 400 status code for valid logged-user-id, valid customerCode, and  moveId path parameter contain blankspace.",
                        400,
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_customerCode(),
                        Endpoints.GetCostEstimateVersionsAsync.get_valid_logged_user_id(),
                        " ",
                        "",
                        SchemaValidation.NOT_REQUIRED
                },
                //TC_14
                {
                        "Verify API responds with 400 status code for logged-user-id,  customerCode, and  moveId path parameter are blankspace  ",
                        400,
                        " ",
                        " ",
                        " ",
                        "",
                        SchemaValidation.NOT_REQUIRED
                },

        };
    }
    // Test method to validate API responses based on AssignmentId and Logged-User-Id
    @Test(dataProvider = "GetCostEstimateVersionsAsyncTest_Dataprovider", description = "Validate API responses based on AssignmentId and Logged-User-Id scenarios")
    public void GetCostEstimateVersionsAsync(String description, int expectedStatusCode, String loggedUserId, String customerCode, String MoveId , String schemaKey, SchemaValidation schemaValidation) {
        String apiEndpoint = Endpoints.GetCostEstimateVersionsAsync.get_Url(MoveId);

        // Prepare the headers map
        Map<String, String> headers = new HashMap<>();
        if (loggedUserId != null) {
            headers.put("logged-user-id", loggedUserId);
        }
        if (customerCode != null) {
            headers.put("customerCode", customerCode);
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
