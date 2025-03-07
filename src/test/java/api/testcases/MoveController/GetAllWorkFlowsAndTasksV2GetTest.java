package api.testcases.MoveController;

import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.CommonMethods;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import java.util.Map;

public class GetAllWorkFlowsAndTasksV2GetTest {
    @DataProvider(name = "workflowsAndTasksApiTestCases")
    public Object[][] workflowsAndTasksApiTestCases() {
        return new Object[][]{
                // Description, customerCode, moveId, expectedStatusCode, schemaKey
                {"Verify API responds with 200 status code for valid customer_code header and valid moveId path parameter.",
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getValidCustomerCode(),
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getValidMoveId(), 200, "validSchema"},
                {"Verify API responds with 400 status code when customer_code header is missing and valid moveId path parameter is provided.",
                        null, Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getValidMoveId(), 400, "missingCustomerCodeSchema"},
                {"Verify API responds with 400 status code when customer_code header contains only blank spaces and valid moveId path parameter is provided.",
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getBlankCustomerCode(),
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getValidMoveId(), 400, "blankSpaceCustomerCodeSchema"},
                {"Verify API responds with 400 status code when customer_code header contains special characters and valid moveId path parameter is provided.",
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getSpecialCharCustomerCode(),
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getValidMoveId(), 400, "specialCharCustomerCodeSchema"},
                {"Verify API responds with 404 status code when customer_code header contains an invalid value and valid moveId path parameter is provided.",
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getInvalidCustomerCode(),
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getValidMoveId(), 404, "invalidCustomerCodeSchema"},
                {"Verify API responds with 400 status code when moveId path parameter is missing and valid customer_code header is provided.",
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getValidCustomerCode(),
                        null, 400, "missingMoveIdSchema"},
                {"Verify API responds with 400 status code when moveId path parameter contains only blank spaces and valid customer_code header is provided.",
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getValidCustomerCode(),
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getBlankMoveId(), 400, "blankSpaceMoveIdSchema"},
                {"Verify API responds with 400 status code when moveId path parameter contains special characters and valid customer_code header is provided.",
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getValidCustomerCode(),
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getSpecialCharMoveId(), 400, "specialCharMoveIdSchema"},
                {"Verify API responds with 404 status code when moveId path parameter contains an invalid value and valid customer_code header is provided.",
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getValidCustomerCode(),
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getInvalidMoveId(), 404, "invalidMoveIdSchema"},
                {"Verify API responds with 404 status code when moveId path parameter contains a non-existing value and valid customer_code header is provided.",
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getValidCustomerCode(),
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getNonExistentMoveId(), 404, "nonExistentMoveIdSchema"},
                {"Verify API responds with 400 status code when both customer_code header and moveId path parameter are missing.",
                        null, null, 400, "missingBothSchema"},
                {"Verify API responds with 400 status code when both customer_code header and moveId path parameter contain only blank spaces.",
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getBlankCustomerCode(),
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getBlankMoveId(), 400, "blankBothSchema"},
                {"Verify API responds with 400 status code when both customer_code header and moveId path parameter contain special characters.",
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getSpecialCharCustomerCode(),
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getSpecialCharMoveId(), 400, "specialCharBothSchema"},
                {"Verify API responds with 400 status code when both customer_code header and moveId path parameter contain invalid values.",
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getInvalidCustomerCode(),
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getInvalidMoveId(), 400, "invalidBothSchema"},
                {"Verify API responds within acceptable response time for valid customer_code header and valid moveId path parameter.",
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getValidCustomerCode(),
                        Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getValidMoveId(), 200, "validResponseTime"}
        };
    }
    @Test(dataProvider = "workflowsAndTasksApiTestCases", description = "Validate Move Controller Get All Workflows and Tasks API responses")
    public void workflowsAndTasksTest(String description, String customerCode, String moveId, int expectedStatusCode, String schemaKey) {
        String workflowsAndTasksUrl = Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getWorkflowsAndTasksUrl(moveId);
        Map<String, String> headers = Map.of(
                "customerCode", customerCode != null ? customerCode : ""
        );
        Response response = CommonMethods.sendGetRequest(workflowsAndTasksUrl, null, null, headers);
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        // Verify response time (for valid cases)
        if (expectedStatusCode == 200) {
            ApiCommonAssertions.verifyResponseTime(response, Endpoints.MoveControllerGetAllWorkflowsAndTasksV2TestData.getResponseTimeThreshold());
        }
        // ApiCommonAssertions.verifyResponseSchema(response, SCHEMA_FILE_PATH, schemaKey);
    }
}

