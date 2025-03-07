package api.testcases.BusinessDocumentsController;

import api.endpoints.Endpoints;
import api.utilities.BaseTest;
import api.utilities.ApiCommonAssertions;
import api.utilities.CommonMethods;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class BusinessDocumentsControllerGetAssignmentBizdocByPropertyNameTest extends BaseTest {
    // DataProvider method providing the test data
    @DataProvider(name = "GetAssignmentBizdocByPropertyName_Dataprovider")
    public Object[][] GetAssignmentBizdocByPropertyName_Dataprovider() {
        return new Object[][]{
               //TC_01
                {
                        "Verify API responds with 200 status code for valid logged-user-id header, customer code, and valid assignmentId path parameter, businessDocumentCode.",
                        200,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_02
                {
                        "Verify API responds within acceptable response time (5 ms) for valid logged-user-id header , customer code  and valid assignmentId path parameter , businessDocumentCode",
                        200,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_03
                {
                        "Verify API responds with 404 status code when logged-user-id header contains invalid value  , valid  customer code header and valid assignmentId  and valid businessDoxumentCode are provided.",
                        404,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_invalid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_04
                {
                        "Verify API responds with 404 status code when logged-user-id header contains valid value  , invalid  customer code header and valid assignmentId  and valid businessDoxumentCode are provided.",
                        404,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_invalid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_05
                {
                        "Verify API responds with 404 status code when logged-user-id header contains valid value  , valid  customer code header and invalid assignmentId  and valid businessDoxumentCode are provided..",
                        404,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_invalid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_06
                {
                        "Verify API responds with 404 status code when logged-user-id header contains valid value  , valid  customer code header and valid assignmentId  and invalid businessDoxumentCode are provided.",
                        404,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_invalid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_07
                {
                        "Verify API responds with 400 status code when logged-user-id header contains missing value   , valid  customer code header and valid assignmentId  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_invalid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        null,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_08
                {
                        "Verify API responds with 400 status code when logged-user-id header contains valid value  , missing   customer code header and valid assignmentId  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_invalid_businessDocumentCode(),
                        null,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_09
                {
                        "Verify API responds with 400 status code when  valid logged-user-id header ,   valid  customer code header and missing assignmentId  and valid businessDoxumentCode are provided.",
                        400,
                        null,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                }, //TC_010
                {
                        "Verify API responds with 400 status code when  valid logged-user-id ,  valid   customer code header and valid assignmentId  and missing  businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        null,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_11
                {
                        "Verify API responds with 400 status code when logged-user-id header contains blankspace  value   , valid  customer code header and valid assignmentId  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_invalid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        " ",
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_12
                {
                        "Verify API responds with 400 status code when logged-user-id header contains valid value  ,  customer code header contain blankspace value  and valid assignmentId  and valid businessDoxumentCode are provided..",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_invalid_businessDocumentCode(),
                        " ",
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_13
                {
                        "Verify API responds with 400 status code when  valid logged-user-id header ,   valid  customer code header and assignmentId contain blankspace value   and valid businessDoxumentCode are provided.",
                        400,
                        " ",
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_invalid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_14
                {
                        "Verify API responds with 400 status code when  valid logged-user-id ,  valid   customer code header and valid assignmentId  and businessDoxumentCode  contain blankspace value are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        " ",
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_15
                {
                        "Verify API responds with 400 status code when logged-user-id header contains more than X character   value   , valid  customer code header and valid assignmentId  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_maxlength_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_16
                {
                        "Verify API responds with 400 status code when logged-user-id header contains valid value  ,  customer code header  contain more than X character   value  and valid assignmentId  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_maxlength_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_17
                {
                        "Verify API responds with 400 status code when  valid logged-user-id header ,   valid  customer code header and assignmentId contain more than X character   value  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_maxlength_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_18
                {
                        "Verify API responds with 400 status code when  valid logged-user-id ,  valid   customer code header and valid assignmentId  and businessDoxumentCode  contain more than X character   value are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_maxlength_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_19
                {
                        "Verify API responds with 400 status code when logged-user-id header contains less than X character   value   , valid  customer code header and valid assignmentId  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_minlength_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_20
                {
                        "Verify API responds with 400 status code when logged-user-id header contains valid value  ,  customer code header  contain less than X character   value  and valid assignmentId  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_minlength_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_21
                {
                        "Verify API responds with 400 status code when  valid logged-user-id header ,   valid  customer code header and assignmentId contain less than X character  value  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_minlength_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_22
                {
                        "Verify API responds with 400 status code when  valid logged-user-id ,  valid   customer code header and valid assignmentId  and businessDoxumentCode  contain less than X character  value are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_minlength_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_23
                {
                        "Verify API responds with 400 status code when logged-user-id header contains special character   value   , valid  customer code header and valid assignmentId  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_specialChar_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_24
                {
                        "Verify API responds with 400 status code when logged-user-id header contains valid value  ,  customer code header  contain special character   value  and valid assignmentId  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_specialChar_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_25
                {
                        "Verify API responds with 400 status code when  valid logged-user-id header ,   valid  customer code header and assignmentId contain special character   value  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_specialChar_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_26
                {
                        "Verify API responds with 400 status code when  valid logged-user-id ,  valid   customer code header and valid assignmentId  and businessDoxumentCode  contain special character   value are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_specialChar_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_27
                {
                        "Verify API responds with 400 status code when logged-user-id header contains alpha numeric  value   , valid  customer code header and valid assignmentId  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_alphaNumeric_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_28
                {
                        "Verify API responds with 400 status code when logged-user-id header contains valid value  ,  customer code header  contain alpha numeric  value  and valid assignmentId  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_alphaNumeric_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_29
                {
                        "Verify API responds with 400 status code when  valid logged-user-id header ,   valid  customer code header and assignmentId contain alpha numeric  value  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_alphaNumeric_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_30
                {
                        "Verify API responds with 400 status code when  valid logged-user-id ,  valid   customer code header and valid assignmentId  and businessDoxumentCode  contain alpha numeric  value   are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_alphaNumeric_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_31
                {
                        "Verify API responds with 400 status code when logged-user-id header contains SQL injection character    , valid  customer code header and valid assignmentId  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_sqlInjection_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_32
                {
                        "Verify API responds with 400 status code when logged-user-id header contains valid value  ,  customer code header  contain SQL injection character  and valid assignmentId  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_sqlInjection_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_33
                {
                        "Verify API responds with 400 status code when  valid logged-user-id header ,   valid  customer code header and assignmentId contain SQL injection character   value  and valid businessDoxumentCode are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_sqlInjection_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
                //TC_34
                {
                        "Verify API responds with 400 status code when  valid logged-user-id ,  valid   customer code header and valid assignmentId  and businessDoxumentCode  contain SQL injection character value are provided.",
                        400,
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_AssignmentId(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_sqlInjection_businessDocumentCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_customerCode(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_valid_logged_user_id(),
                        Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_lang(),
                        ""
                },
        };
    }

    // Test method to validate API responses based on AssignmentId and Logged-User-Id
    @Test(dataProvider = "GetAssignmentBizdocByPropertyName_Dataprovider", description = "Validate API responses based on AssignmentId and Logged-User-Id scenarios")
    public void getBusinessDocumentsControllerGetAssignmentBizdocByPropertyName(String description, int expectedStatusCode, String assignmentId, String businessDocumentCode, String customerCode, String loggedUserId, String lang , String schemaKey) {
        String apiEndpoint = Endpoints.BusinessDocumentsControllerGetAssignmentBizdocByPropertyName.get_Url(assignmentId, businessDocumentCode);

        // Prepare the headers map
        Map<String, String> headers = new HashMap<>();
        if (loggedUserId != null) {
            headers.put("logged-user-id", loggedUserId);
        }
        if (customerCode != null) {
            headers.put("customerCode", customerCode);
        }
        Map<String, String> queryParams = new HashMap<>();
        if (lang != null) {
            queryParams.put("lang", lang);
        }

            // Log the URL and headers for debugging purposes
            System.out.println("*************************************************************************");
            System.out.println(apiEndpoint);
            System.out.println(headers);
            System.out.println("*************************************************************************");

            // Send the GET request and capture the response
            Response response = CommonMethods.sendGetRequest(apiEndpoint, null, null, headers);

            // Perform assertions on the response
          //  ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
            ApiCommonAssertions.verifyResponseTime(response, 3000);
            //    ApiCommonAssertions.verifyResponseSchema(response, SCHEMA_FILE_PATH, schemaKey);
        }
    }
