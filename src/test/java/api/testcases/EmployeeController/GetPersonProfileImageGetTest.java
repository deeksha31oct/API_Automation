package api.testcases.EmployeeController;

import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.CommonMethods;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Map;
//EMPLOYYECONTROLLER
public class GetPersonProfileImageGetTest {

    @DataProvider(name = "profileImageRetrievalProvider")
    public Object[][] profileImageRetrievalProvider() {
        return new Object[][] {
                // Test case description, topiaPersonId, expected status code, customerCode, logged-user-id, schema key
                {"Verify successful response with valid topiaPersonId, customerCode, and logged-user-id",
                        Endpoints.ProfileImage.getValidTopiaPersonId(),
                        200,
                        Endpoints.ProfileImage.getValidCustomerCode(),
                        Endpoints.ProfileImage.getValidLoggedUserId(),
                        "ValidTopiaPersonIdCustomerCodeAndLoggedUserId"},

                {"Verify response with invalid topiaPersonId and valid customerCode and logged-user-id",
                        Endpoints.ProfileImage.getInvalidTopiaPersonId(),
                        400,
                        Endpoints.ProfileImage.getValidCustomerCode(),
                        Endpoints.ProfileImage.getValidLoggedUserId(),
                        "InvalidTopiaPersonIdValidCustomerCodeAndLoggedUserId"},

                {"Verify response with valid topiaPersonId, invalid customerCode, and valid logged-user-id",
                        Endpoints.ProfileImage.getValidTopiaPersonId(),
                        400,
                        Endpoints.ProfileImage.getInvalidCustomerCode(),
                        Endpoints.ProfileImage.getValidLoggedUserId(),
                        "ValidTopiaPersonIdInvalidCustomerCodeAndLoggedUserId"},

                {"Verify response with valid topiaPersonId and customerCode but invalid logged-user-id",
                        Endpoints.ProfileImage.getValidTopiaPersonId(),
                        404,
                        Endpoints.ProfileImage.getValidCustomerCode(),
                        Endpoints.ProfileImage.getInvalidLoggedUserId(),
                        "ValidTopiaPersonIdValidCustomerCodeAndInvalidLoggedUserId"},

                {"Verify response when topiaPersonId, customerCode, or logged-user-id is empty",
                        "",
                        400,
                        "",
                        "",
                        "EmptyTopiaPersonIdCustomerCodeAndLoggedUserId"},

                {"Verify response time for profile image retrieval with valid topiaPersonId, customerCode, and logged-user-id",
                        Endpoints.ProfileImage.getValidTopiaPersonId(),
                        200,
                        Endpoints.ProfileImage.getValidCustomerCode(),
                        Endpoints.ProfileImage.getValidLoggedUserId(),
                        "VerifyResponseTimeWithValidTopiaPersonIdCustomerCodeAndLoggedUserId"},

                {"Verify response with special characters and maximum length for topiaPersonId, valid customerCode, and logged-user-id",
                        Endpoints.ProfileImage.getSpecialCharTopiaPersonId(),
                        400,
                        Endpoints.ProfileImage.getValidCustomerCode(),
                        Endpoints.ProfileImage.getValidLoggedUserId(),
                        "SpecialCharAndMaxLengthTopiaPersonIdValidCustomerCodeAndLoggedUserId"}
        };
    }

    @Test(dataProvider = "profileImageRetrievalProvider", description = "Validate Profile Image Retrieval API responses based on topiaPersonId, customerCode, and logged-user-id scenarios")
    public void ProfileImageRetrieval(String description, String topiaPersonId, int expectedStatusCode,
                                                                      String customerCode, String loggedUserId, String schemaKey) {
        // Construct the API URL for profile image retrieval
        String profileImageUrl = (topiaPersonId != null)
                ? Endpoints.ProfileImage.getProfileImageUrl(topiaPersonId)
                : Endpoints.ProfileImage.getProfileImageUrl("");
        Map<String, String> headers = Map.of(
                "customerCode", customerCode != null && !customerCode.trim().isEmpty() ? customerCode : "",
                "logged-user-id", loggedUserId != null && !loggedUserId.trim().isEmpty() ? loggedUserId : ""
        );
        Response response = CommonMethods.sendGetRequest(profileImageUrl, null, null, headers);
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 5000);
        // ApiCommonAssertions.verifyResponseSchema(response, SCHEMA_FILE_PATH, schemaKey);
    }
}


