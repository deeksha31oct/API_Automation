package api.testcases.PermissionsController;

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

public class GetAssignmentScreenFeaturePermissionsTest extends BaseTest {

    @DataProvider(name = "GetAssignmentScreenFeaturePermissions_Dataprovider")
    public Object[][] GetAssignmentScreenFeaturePermissions_Dataprovider() {
        return new Object[][]{
                // TC_01
                {
                        "Verify API responds with 200 status code for valid logged-user-id and customer code",
                        200,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_logged_user_id(),
                        "GetExplores_schema",
                        SchemaValidation.NOT_REQUIRED
                },
              // TC_02
                {
                        "Verify API responds within acceptable response time (5 ms) for valid  logged-user-id  and customer code",
                        200,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_logged_user_id(),
                        "GetExplores_schema_02",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_03
                {
                        "Verify API responds with 404 status code for invalid  logged-user-id  and valid  customer code ",
                        404,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_invalid_logged_user_id(),
                        "GetExplores_schema_02",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_04
                {
                        "Verify API responds with 404 status code for valid  logged-user-id  and invalid  customer code ",
                        404,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_invalid_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_logged_user_id(),
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_05
                {
                        "Verify API responds with 404 status code for invalid  logged-user-id  and invalid  customer code   ",
                        404,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_invalid_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_invalid_logged_user_id(),
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_06
                {
                        "Verify API responds with 400 status code for missing value of logged-user-id  and valid  customer code  ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_invalid_customerCode(),
                        null,
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_07
                {
                        "Verify API responds with 400 status code for valid  logged-user-id  and missing value   customer code ",
                        400,
                        null,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_invalid_logged_user_id(),
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_08
                {
                        "Verify API responds with 400 status code for both  missing value   logged-user-id  and   customer code  ",
                        400,
                        null,
                       null,
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_09
                {
                        "Verify API responds with 400 status code for blankspace  of logged-user-id  and valid  customer code  ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_invalid_customerCode(),
                        " ",
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_10
                {
                        "Verify API responds with 400 status code for valid  logged-user-id  and blankspacecustomer code  ",
                        400,
                        "",
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_invalid_logged_user_id(),
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_11
                {
                        "Verify API responds with 400 status code for both  blankspace logged-user-id  and   customer code  ",
                        400,
                        "",
                        "",
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_12
                {
                        "Verify API responds with 400 status code for logged-user-id contain more than X character   and valid  customer code  ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_maxlength_logged_user_id(),
                        "GetExplores_schema_02",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_13
                {
                        "Verify API responds with 400 status code for valid  logged-user-id  and customer code contain more than X character   ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_maxlength_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_logged_user_id(),
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_14
                {
                        "Verify API responds with 400 status code for both contain more than X character logged-user-id  and   customer code  ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_maxlength_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_maxlength_logged_user_id(),
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_15
                {
                        "Verify API responds with 400 status code for logged-user-id contain less than X character   and valid  customer code  ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_minlength_logged_user_id(),
                        "GetExplores_schema_02",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_16
                {
                        "Verify API responds with 400 status code for valid  logged-user-id  and customer code contain less than X character   ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_minlength_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_logged_user_id(),
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_17
                {
                        "Verify API responds with 400 status code for both contain less than X character logged-user-id  and   customer code  ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_minlength_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_minlength_logged_user_id(),
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_18
                {
                        "Verify API responds with 400 status code for logged-user-id contain special  character   and valid  customer code ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_specialChar_logged_user_id(),
                        "GetExplores_schema_02",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_19
                {
                        "Verify API responds with 400 status code for valid  logged-user-id  and customer code contain special character  ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_specialChar_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_logged_user_id(),
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_20
                {
                        "Verify API responds with 400 status code for both contain special character logged-user-id  and   customer code  ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_specialChar_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_specialChar_logged_user_id(),
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_21
                {
                        "Verify API responds with 400 status code for logged-user-id contain alpha numeric character   and valid  customer code  ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_alphaNumeric_logged_user_id(),
                        "GetExplores_schema_02",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_22
                {
                        "Verify API responds with 400 status code for valid  logged-user-id  and customer code contain alpha numeric character  ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_alphaNumeric_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_logged_user_id(),
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_23
                {
                        "Verify API responds with 400 status code for both contain alphanumeric character logged-user-id  and   customer code  ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_alphaNumeric_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_alphaNumeric_logged_user_id(),
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_24
                {
                        "Verify API responds with 400 status code for logged-user-id contain SQLinjection    and valid  customer code   ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_sqlInjection_logged_user_id(),
                        "GetExplores_schema_02",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_25
                {
                        "Verify API responds with 400 status code for valid  logged-user-id  and customer code contain SQLinjection   ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_sqlInjection_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_valid_logged_user_id(),
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
                // TC_26
                {
                        "Verify API responds with 400 status code for both contain SQLinjection   logged-user-id  and   customer code  ",
                        400,
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_sqlInjection_customerCode(),
                        Endpoints.GetAssignmentScreenFeaturePermissions.get_sqlInjection_logged_user_id(),
                        "GetExplores_schema_03",
                        SchemaValidation.NOT_REQUIRED
                },
        };
    }

    @Test(dataProvider = "GetAssignmentScreenFeaturePermissions_Dataprovider", description = "Validate API responses for logged-user-id and customer code scenarios")
    public void GetAssignmentScreenFeaturePermissions(String description, int expectedStatusCode, String customerCode,String loggedUserId, String schemaKey, SchemaValidation schemaValidation) {
        // Generate API endpoint URL
        String apiEndpoint = Endpoints.GetAssignmentScreenFeaturePermissions.get_Url();

        // Prepare the headers map
        Map<String, String> headers = new HashMap<>();
        if (customerCode != null) {
            headers.put("customerCode", customerCode);
        }
        if (loggedUserId != null) {
            headers.put("logged-user-id", loggedUserId);
        }

        // Log the URL and headers for debugging purposes
        System.out.println("*************************************************************************");
        System.out.println("Description: " + description);
        System.out.println("API Endpoint: " + apiEndpoint);
        System.out.println("Headers: " + headers);
        System.out.println("*************************************************************************");

        // Send the GET request and capture the response
        Response response = CommonMethods.sendGetRequest(apiEndpoint, null, null, headers);

        // Perform assertions on the response
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 3000);

        // Perform schema validation if required
        if (schemaValidation == SchemaValidation.REQUIRED) {
            ApiCommonAssertions.verifyResponseSchema(response,schemaKey , schemaValidation);
        }
    }
}


