package api.testcases.PolicyChnageController;

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

public class GetExploresTest extends BaseTest {


    @DataProvider(name = "GetExplores_Dataprovider")
    public Object[][] GetExplores_Dataprovider() {
        return new Object[][]{
                //TC_01
                {
                        "Verify API responds with 200 status code for valid customer code and valid MoveID",
                        200,
                        Endpoints.GetExplores.get_valid_MoveId(),
                        Endpoints.GetExplores.get_valid_customerCode(),
                        "GetExplores_schema",
                        null,
                        null,
                        SchemaValidation.REQUIRED
                },
                //TC_02
                {
                        "Verify API responds within acceptable response time (5 ms) for valid  customer code  and valid MoveId                                                                                                                                                              ",
                        200,
                        Endpoints.GetExplores.get_valid_MoveId(),
                        Endpoints.GetExplores.get_valid_customerCode(),
                        "GetExplores_schema_02",
                        null,
                        null,
                        SchemaValidation.REQUIRED

                },
                //TC_03
                {
                        "Verify API responds with 404 status code for invalid  customer code  and valid MoveID",
                        404,
                        Endpoints.GetExplores.get_valid_MoveId(),
                        Endpoints.GetExplores.get_invalid_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_04
                {
                        "Verify API responds with 404 status code for valid  customer code  and invalid MoveID",
                        404,
                        Endpoints.GetExplores.get_invalid_MoveId(),
                        Endpoints.GetExplores.get_valid_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_05
                {
                        "Verify API responds with 404 status code for invalid  customer code  and invalid MoveID",
                        404,
                        Endpoints.GetExplores.get_invalid_MoveId(),
                        Endpoints.GetExplores.get_invalid_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_06
                {
                        "Verify API responds with 400 status code for missing  customer code  and valid MoveID",
                        400,
                        Endpoints.GetExplores.get_invalid_MoveId(),
                        null,
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_07
                {
                        "Verify API responds with 400 status code for  valid customer code  and missing  MoveID",
                        400,
                        null,
                        Endpoints.GetExplores.get_invalid_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_08
                {
                        "Verify API responds with 400 status code for  both missing  customer code  and  MoveID",
                        400,
                        null,
                        null,
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_09
                {
                        "Verify API responds with 400 status code for  balnkspace customer code  and valid  MoveID",
                        400,
                        Endpoints.GetExplores.get_invalid_MoveId(),
                        " ",
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_10
                {
                        "Verify API responds with 400 status code for valid  customer code  and blankspace MoveID",
                        400,
                        " ",
                        Endpoints.GetExplores.get_invalid_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_11
                {
                        "Verify API responds with 400 status code for customer code more then X character  with valid MoveID",
                        400,
                        Endpoints.GetExplores.get_valid_MoveId(),
                        Endpoints.GetExplores.get_maxlength_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_12
                {
                        "Verify API responds with 400 status code for valid  customer code  and  MoveID more then X character ",
                        400,
                        Endpoints.GetExplores.get_maxlength_MoveId(),
                        Endpoints.GetExplores.get_valid_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_13
                {
                        "Verify API responds with 400 status code for  both customer code  and  MoveID are more than X character ",
                        400,
                        Endpoints.GetExplores.get_maxlength_MoveId(),
                        Endpoints.GetExplores.get_maxlength_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                }
                ,
                //TC_14
                {
                        "Verify API responds with 400 status code for customer code less then X character  with valid MoveID",
                        400,
                        Endpoints.GetExplores.get_valid_MoveId(),
                        Endpoints.GetExplores.get_minlength_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_15
                {
                        "Verify API responds with 400 status code for valid  customer code  and  MoveID less then X character ",
                        400,
                        Endpoints.GetExplores.get_minlength_MoveId(),
                        Endpoints.GetExplores.get_valid_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_16
                {
                        "Verify API responds with 400 status code for  both customer code  and  MoveID are less than X character ",
                        400,
                        Endpoints.GetExplores.get_minlength_MoveId(),
                        Endpoints.GetExplores.get_minlength_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_17
                {
                        "Verify API responds with 400 status code for customer code are special character  with valid MoveID",
                        400,
                        Endpoints.GetExplores.get_valid_MoveId(),
                        Endpoints.GetExplores.get_specialChar_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_18
                {
                        "Verify API responds with 400 status code for valid  customer code  and  MoveID are special character ",
                        400,
                        Endpoints.GetExplores.get_specialChar_MoveId(),
                        Endpoints.GetExplores.get_valid_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_19
                {
                        "Verify API responds with 400 status code for  both customer code  and  MoveID are special character  ",
                        400,
                        Endpoints.GetExplores.get_specialChar_MoveId(),
                        Endpoints.GetExplores.get_specialChar_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_20
                {
                        "Verify API responds with 400 status code for customer code are alpha numeric character  with valid MoveID",
                        400,
                        Endpoints.GetExplores.get_valid_MoveId(),
                        Endpoints.GetExplores.get_alphaNumeric_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_21
                {
                        "Verify API responds with 400 status code for valid  customer code  and  MoveID are alpha numeric  character  ",
                        400,
                        Endpoints.GetExplores.get_alphaNumeric_MoveId(),
                        Endpoints.GetExplores.get_valid_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_22
                {
                        "Verify API responds with 400 status code for  both customer code  and  MoveID are alpha numeric  character  ",
                        400,
                        Endpoints.GetExplores.get_alphaNumeric_MoveId(),
                        Endpoints.GetExplores.get_alphaNumeric_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_23
                {
                        "Verify API responds with 400 status code for customer code are contain SQL injections character   with valid MoveID",
                        400,
                        Endpoints.GetExplores.get_valid_MoveId(),
                        Endpoints.GetExplores.get_sqlInjection_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_24
                {
                        "Verify API responds with 400 status code for valid  customer code  and  MoveID are  contain SQL injections character  ",
                        400,
                        Endpoints.GetExplores.get_sqlInjection_MoveId(),
                        Endpoints.GetExplores.get_valid_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },
                //TC_25
                {
                        "Verify API responds with 400 status code for  both customer code  and  MoveID are  contain SQL injections character  ",
                        400,
                        Endpoints.GetExplores.get_sqlInjection_MoveId(),
                        Endpoints.GetExplores.get_sqlInjection_customerCode(),
                        " ",
                        null,
                        null,
                        SchemaValidation.NOT_REQUIRED,
                },

        };
    }

        @Test(dataProvider = "GetExplores_Dataprovider", description = "Validate API responses based on moveId and customerCode scenarios")
        public void GetExplores(String description, int expectedStatusCode, String moveID, String customerCode, String schemaKey,String moveStage,String benefitCode,  SchemaValidation schemaValidation) {
                // Generate API endpoint URL
                String apiEndpoint = Endpoints.GetExplores.get_Url(moveID);

                // Prepare the headers map
                Map<String, String> headers = new HashMap<>();
                if (customerCode != null) {
                        headers.put("customerCode", customerCode);
                }
                Map<String, String> queryparm = new HashMap<>();
                if (benefitCode != null) {
                        headers.put("benefitCode", benefitCode);
                }
                if (moveStage != null) {
                        headers.put("benefitCode", moveStage);
                }

                // Log the URL and headers for debugging purposes
                System.out.println("*************************************************************************");
                System.out.println("Description: " + description);
                System.out.println("API Endpoint: " + apiEndpoint);
                System.out.println("Headers: " + headers);
                System.out.println("*************************************************************************");

                // Send the GET request and capture the response
                Response response = CommonMethods.sendGetRequest(apiEndpoint, queryparm, null, headers);

                // Perform assertions on the response
                ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
                ApiCommonAssertions.verifyResponseTime(response, 2000);

                // Perform schema validation if required
                if (schemaValidation == SchemaValidation.REQUIRED) {
                        ApiCommonAssertions.verifyResponseSchema(response, "path/to/schema/file", schemaValidation);
                }
        }
}