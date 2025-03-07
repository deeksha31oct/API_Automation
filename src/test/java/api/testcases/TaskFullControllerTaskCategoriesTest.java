package api.testcases;

import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.util.Map;

public class TaskFullControllerTaskCategoriesTest {
    @DataProvider(name = "taskFullControllerTestCases")
    public Object[][] taskFullControllerTestCases() {
        return new Object[][]{
                // Test Cases
                {"Verify response with valid customerCode and valid loggedUser.",
                        Endpoints.TaskFullControllerTaskCategories.getValidCustomerCode(),
                        Endpoints.TaskFullControllerTaskCategories.getValidLoggedUser(),
                        200, "ValidCustomerCodeAndLoggedUser"},
                {"Verify response with valid customerCode and missing loggedUser.",
                        Endpoints.TaskFullControllerTaskCategories.getValidCustomerCode(),
                        null, 400, "ValidCustomerCodeAndMissingLoggedUser"},
                {"Verify response with invalid customerCode and valid loggedUser.",
                        Endpoints.TaskFullControllerTaskCategories.getInvalidCustomerCode(),
                        Endpoints.TaskFullControllerTaskCategories.getValidLoggedUser(),
                        400, "InvalidCustomerCodeAndValidLoggedUser"},
                {"Verify response with valid customerCode and blank loggedUser.",
                        Endpoints.TaskFullControllerTaskCategories.getValidCustomerCode(),
                        "", 400, "ValidCustomerCodeAndBlankLoggedUser"},
                {"Verify response with special character in customerCode and valid loggedUser.",
                        Endpoints.TaskFullControllerTaskCategories.getSpecialCharCustomerCode(),
                        Endpoints.TaskFullControllerTaskCategories.getValidLoggedUser(),
                        200, "SpecialCharCustomerCodeAndValidLoggedUser"},
                {"Verify response with valid customerCode and loggedUser with spaces.",
                        Endpoints.TaskFullControllerTaskCategories.getValidCustomerCode(),
                        Endpoints.TaskFullControllerTaskCategories.getLoggedUserWithSpaces(),
                        400, "ValidCustomerCodeAndLoggedUserWithSpaces"},
                {"Verify response time with valid customerCode and loggedUser.",
                        Endpoints.TaskFullControllerTaskCategories.getValidCustomerCode(),
                        Endpoints.TaskFullControllerTaskCategories.getValidLoggedUser(),
                        200, "ResponseTimeWithValidCustomerCodeAndLoggedUser"},
                {"Verify error response when customerCode is blank.",
                        "", Endpoints.TaskFullControllerTaskCategories.getValidLoggedUser(),
                        400, "BlankCustomerCodeAndValidLoggedUser"},
                {"Verify error response when loggedUser is blank.",
                        Endpoints.TaskFullControllerTaskCategories.getValidCustomerCode(),
                        "", 400, "ValidCustomerCodeAndBlankLoggedUser"}
        };
    }

    @Test(dataProvider = "taskFullControllerTestCases", description = "Validate Task Full Controller Task Categories API responses for various customerCode and loggedUser scenarios")
    public void taskFullControllerTest(String description, String customerCode, String loggedUser, int expectedStatusCode, String schemaKey) {
        // Constructing the Task Full API URL with customerCode and loggedUser
        String taskFullControllerApiUrl = Endpoints.TaskFullControllerTaskCategories.getTaskCategoriesUrl();
//        System.out.println(taskFullControllerApiUrl);
        // Setting up request headers with customerCode and loggedUser, if available
        Map<String, String> headers = Map.of(
                "customerCode", customerCode != null ? customerCode : "",
                "logged-in-user", loggedUser != null ? loggedUser : ""
        );
        System.out.println("Request Headers: " + headers);
        Response response = CommonMethods.sendGetRequest(taskFullControllerApiUrl, null, null, headers);
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 5000);
        // ApiCommonAssertions.verifyResponseSchema(response, SCHEMA_FILE_PATH, schemaKey);
    }
}
