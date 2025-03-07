package api.testcases.UserController;

import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.BaseTest;
import api.utilities.CommonMethods;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Map;
public class TopiaPersonIdGetTest extends BaseTest {
//    private static final String SCHEMA_FILE_PATH = "/Users/atif.khan/Documents/Testing_Materials/api-tests/src/main/resources/schemas/getUserControllerSchema.json";

    @DataProvider(name = "topiaPersonIdProvider")
    public Object[][] topiaPersonIdProvider() {
        return new Object[][] {
                // Test case descriptions, topiaPersonId, expected status code, customerCode, schemaKey
                {"Verify response with valid topiaPersonId and customerCode.", Endpoints.UserController.getValidTopiaPersonId(), 200, Endpoints.UserController.getValidCustomerCode(), "ValidPersonIdAndCustomerCode"},
                {"Verify response with invalid topiaPersonId and invalid customerCode.", Endpoints.UserController.getInvalidTopiaPersonId(), 400, Endpoints.UserController.getInvalidCustomerCode(), "InvalidPersonIdAndInvalidCustomerCode"},
                {"Verify response with topiaPersonId and customerCode containing blank spaces.", Endpoints.UserController.getBlankTopiaPersonId(), 404, Endpoints.UserController.getBlankCustomerCode(), "PersonIdAndCustomerCodeWithBlankSpaces"},
                {"Verify response with blank customerCode header.", Endpoints.UserController.getValidTopiaPersonId(), 400, Endpoints.UserController.getBlankCustomerCode(), "ValidPersonIdAndBlankCustomerCode"},
                {"Verify response with blank topiaPersonId header.", Endpoints.UserController.getBlankTopiaPersonId(), 404, Endpoints.UserController.getValidCustomerCode(), "BlankPersonIdAndValidCustomerCode"},
                {"Verify response with both topiaPersonId and customerCode missing.", null, 400, null, "MissingPersonIdAndMissingCustomerCode"},
                {"Verify response time with valid topiaPersonId and customerCode.", Endpoints.UserController.getValidTopiaPersonId(), 200, Endpoints.UserController.getValidCustomerCode(), "VerifyResponseTimeWithValidPersonIdAndCustomerCode"}
        };
    }
    @Test(dataProvider = "topiaPersonIdProvider", description = "Validate User API responses based on topiaPersonId and customerCode scenarios")
    public void UserControllerWithTopiaPersonId(String description, String topiaPersonId, int expectedStatusCode, String customerCode, String schemaKey) {
        String userApiUrl = (topiaPersonId != null) ? Endpoints.UserController.getUserApiUrl(topiaPersonId) : Endpoints.UserController.getUserApiUrl("");
        Map<String, String> headers = (customerCode != null && !customerCode.trim().isEmpty())
                ? Map.of("customerCode", customerCode)
                : Map.of();
        Response response = CommonMethods.sendGetRequest(userApiUrl, null, null, headers);
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 5000);
//        ApiCommonAssertions.verifyResponseSchema(response, SCHEMA_FILE_PATH, schemaKey);
    }
}




