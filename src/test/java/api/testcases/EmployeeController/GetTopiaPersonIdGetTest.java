package api.testcases.EmployeeController;

import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.CommonMethods;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetTopiaPersonIdGetTest {

    @DataProvider(name = "topiaPersonIdTestDataProvider")
    public Object[][] topiaPersonIdTestDataProvider() {
        return new Object[][]{
                // Test case description, topiaPersonId, expected status code, customerCode, logged-user-id, schema key
                {"TC_employee-controller_180: Verify API responds with 200 status code for valid logged-user-id, valid customerCode, and valid topiaPersonId path parameter",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidTopiaPersonId(),
                        200,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidLoggedUserId(),
                        "ValidTopiaPersonIdCustomerCodeAndLoggedUserId"},

                {"TC_employee-controller_181: Verify API responds with 400 status code when logged-user-id header is missing and valid customerCode and topiaPersonId are provided",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidTopiaPersonId(),
                        400,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidCustomerCode(),
                        "",
                        "MissingLoggedUserId"},

                {"TC_employee-controller_182: Verify API responds with 400 status code when customerCode header is missing and valid logged-user-id and topiaPersonId are provided",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidTopiaPersonId(),
                        400,
                        null,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidLoggedUserId(),
                        "MissingCustomerCode"},

                {"TC_employee-controller_183: Verify API responds with 400 status code when topiaPersonId path parameter is missing and valid logged-user-id and customerCode are provided",
                        null,
                        400,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidLoggedUserId(),
                        "MissingTopiaPersonId"},

                {"TC_employee-controller_184: Verify API responds with 400 status code when logged-user-id header contains invalid value and valid customerCode and topiaPersonId are provided",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidTopiaPersonId(),
                        400,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getInvalidLoggedUserId(),
                        "InvalidLoggedUserId"},
//for now CustomerCode Accept any string
                {"TC_employee-controller_185: Verify API responds with 400 status code when customerCode header contains invalid value and valid logged-user-id and topiaPersonId are provided",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidTopiaPersonId(),
                        400,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getInvalidCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidLoggedUserId(),
                        "InvalidCustomerCode"},

                {"TC_employee-controller_186: Verify API responds with 400 status code when logged-user-id header contains invalid value and valid customerCode and topiaPersonId are provided",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidTopiaPersonId(),
                        400,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getInvalidLoggedUserId(),
                        "InvalidLoggedUserId"},

                {"TC_employee-controller_187: Verify API responds with 400 status code when logged-user-id header contains special characters and valid customerCode and topiaPersonId are provided",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidTopiaPersonId(),
                        400,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getSpecialCharLoggedUserId(),
                        "SpecialCharLoggedUserId"},

                {"TC_employee-controller_188: Verify API responds with 400 status code when customerCode header contains special characters and valid logged-user-id and topiaPersonId are provided",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidTopiaPersonId(),
                        400,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getSpecialCharCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidLoggedUserId(),
                        "SpecialCharCustomerCode"},

                {"TC_employee-controller_189: Verify API responds with 400 status code when topiaPersonId path parameter contains special characters and valid logged-user-id and customerCode are provided",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getSpecialCharTopiaPersonId(),
                        400,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidLoggedUserId(),
                        "SpecialCharTopiaPersonId"},

                {"TC_employee-controller_190: Verify API responds with 400 status code when topiaPersonId path parameter contains less than 5 digits and valid logged-user-id and customerCode are provided",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getTopiaPersonIdLessThan5(),
                        400,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidLoggedUserId(),
                        "TopiaPersonIdLessThan5"},

                {"TC_employee-controller_191: Verify API responds with 400 status code when topiaPersonId path parameter contains more than 5 digits and valid logged-user-id and customerCode are provided",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getTopiaPersonIdMoreThan5(),
                        400,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidLoggedUserId(),
                        "TopiaPersonIdMoreThan5"},

                {"TC_employee-controller_192: Verify API responds with 400 status code when logged-user-id header contains blank spaces and valid customerCode and topiaPersonId are provided",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidTopiaPersonId(),
                        400,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getBlankSpaceLoggedUserId(),
                        "BlankSpaceLoggedUserId"},

                {"TC_employee-controller_193: Verify API responds with 400 status code when customerCode header contains blank spaces and valid logged-user-id and topiaPersonId are provided",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidTopiaPersonId(),
                        400,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getBlankSpaceCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidLoggedUserId(),
                        "BlankSpaceCustomerCode"},

                {"TC_employee-controller_194: Verify API responds with 400 status code when topiaPersonId path parameter contains blank spaces and valid logged-user-id and customerCode are provided",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getBlankSpaceTopiaPersonId(),
                        400,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidLoggedUserId(),
                        "BlankSpaceTopiaPersonId"},

                {"TC_employee-controller_195: Verify API responds within acceptable response time for valid logged-user-id, valid customerCode, and valid topiaPersonId path parameter",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidTopiaPersonId(),
                        200,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidLoggedUserId(),
                        "ResponseTimeValidTopiaPersonIdCustomerCodeAndLoggedUserId"},

                // Test case 196
                {"TC_employee-controller_196: Verify API responds within acceptable response time for valid logged-user-id, valid customerCode, and valid topiaPersonId path parameter",
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidTopiaPersonId(),
                        200,
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidCustomerCode(),
                        Endpoints.EmployeeControllerGetTopiaPersonId.getValidLoggedUserId(),
                        "ResponseTimeValidTopiaPersonIdCustomerCodeAndLoggedUserId"}
        };
    }

    @Test(dataProvider = "topiaPersonIdTestDataProvider", description = "Validate EmployeeController API responses based on topiaPersonId, customerCode, and logged-user-id scenarios")
    public void validateEmployeeControllerGetTopiaPersonId(String description, String topiaPersonId, int expectedStatusCode,
                                                                   String customerCode, String loggedUserId, String schemaKey) {
        String topiaPersonIdUrl = (topiaPersonId != null && !topiaPersonId.isEmpty())
                ? Endpoints.EmployeeControllerGetTopiaPersonId.getTopiaPersonIdUrl(topiaPersonId)
                : Endpoints.EmployeeControllerGetTopiaPersonId.getTopiaPersonIdUrl("");

        Map<String, String> headers = new HashMap<>();
        if (customerCode != null) {
            headers.put("customerCode", customerCode);
        }
        if (loggedUserId != null) {
            headers.put("logged-user-id", loggedUserId);
        }
        System.out.println("Request Headers: " + headers);
        Response response = CommonMethods.sendGetRequest(topiaPersonIdUrl, null, null, headers);
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 2000);
        if (description.contains("Verify API responds with 400 status code when logged-user-id header is missing") ||
                description.contains("Verify API responds with 400 status code when customerCode header is missing")) {
            // Assert that error field is "Bad Request"
            ApiCommonAssertions.verifyFieldEquals(
                    response.jsonPath().getString("error"),
                    "Bad Request",
                    "Error field should contain 'Bad Request' when 'logged-user-id' or 'customerCode' header is missing."
            );
        }

    }
}