package api.testcases.CostEstimateController;
import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.BaseTest;
import api.utilities.CommonMethods;
import api.utilities.SchemaValidation;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Map;


public class SpendestimatedasyncGetTests extends BaseTest {
    @DataProvider(name = "moveIdProvider")
    public Object[][] moveIdProvider() {
        return new Object[][] {
                {Endpoints.GetCostEstimateSpendEstimatedAsync.getValidMoveId(), 200, "getCostEstimateSchema",
                        "Verify response with 200 status code for validCustomerCode and validMoveId", SchemaValidation.REQUIRED},
                {Endpoints.GetCostEstimateSpendEstimatedAsync.getInvalidMoveId(), 400, "InvalidMoveId",
                        "Verify response with 400 status code for invalidCustomerCode and invalidMoveId", SchemaValidation.NOT_REQUIRED},
                {Endpoints.GetCostEstimateSpendEstimatedAsync.getBlankMoveId(), 400, "MoveIdWithBlank",
                        "Verify response with 400 status code for validCustomerCode and invalidMoveId", SchemaValidation.NOT_REQUIRED},
                {Endpoints.GetCostEstimateSpendEstimatedAsync.getIncorrectMoveId(), 400, "IncorrectFormatMoveId",
                        "Verify response with 400 status code for invalidCustomerCode and validMoveId", SchemaValidation.NOT_REQUIRED},
                {Endpoints.GetCostEstimateSpendEstimatedAsync.getBlankMoveId(), 400, "BlankCustomerCodeAndMoveId",
                        "Verify response with 400 status code for blankCustomerCode and blankMoveId", SchemaValidation.NOT_REQUIRED},
                {Endpoints.GetCostEstimateSpendEstimatedAsync.getCustomerCodeWithSpaces(), 400, "CustomerCodeWithSpacesAndMoveIdWithSpaces",
                        "Verify response with 400 status code for customerCodeWithSpaces and moveIdWithSpaces", SchemaValidation.NOT_REQUIRED},
                {Endpoints.GetCostEstimateSpendEstimatedAsync.getCustomerCodeWithSpecialChars(), 400, "CustomerCodeWithSpecialChars",
                        "Verify response with 400 status code for customerCodeWithSpecialChars and validMoveId", SchemaValidation.NOT_REQUIRED},
                {Endpoints.GetCostEstimateSpendEstimatedAsync.getValidMoveId(), 400, "ValidCustomerCodeAndMoveIdWithSpaces",
                        "Verify response with 400 status code for validCustomerCode and moveIdWithSpaces", SchemaValidation.NOT_REQUIRED},
                {Endpoints.GetCostEstimateSpendEstimatedAsync.getBlankMoveId(), 400, "ValidCustomerCodeAndBlankMoveId",
                        "Verify response with 400 status code for validCustomerCode and blankMoveId", SchemaValidation.NOT_REQUIRED},
                {Endpoints.GetCostEstimateSpendEstimatedAsync.getBlankCustomerCode(), 400, "BlankCustomerCodeAndValidMoveId",
                        "Verify response with 400 status code for blankCustomerCode and validMoveId", SchemaValidation.NOT_REQUIRED},
                {Endpoints.GetCostEstimateSpendEstimatedAsync.getCustomerCodeWithSpacesAndSpecialChars(), 400, "CustomerCodeWithSpacesAndSpecialChars",
                        "Verify response with 400 status code for customerCodeWithSpacesAndSpecialChars and validMoveId", SchemaValidation.NOT_REQUIRED},
                {Endpoints.GetCostEstimateSpendEstimatedAsync.getValidMoveId(), 200, "getCostEstimateSchema",
                        "Verify response time is within acceptable limits for validCustomerCode and validMoveId", SchemaValidation.REQUIRED},
                {Endpoints.GetCostEstimateSpendEstimatedAsync.getValidMoveId(), 400, "LangWithSpaces",
                        "Verify response with 400 status code for validCustomerCode, validMoveId, and lang containing only blank spaces", SchemaValidation.NOT_REQUIRED}
        };
    }
    @Test(dataProvider = "moveIdProvider", description = "Validate Cost Estimate API responses")
    public void testCostEstimateApiWithMoveId(String moveId, int expectedStatusCode, String schemaKey, String description, SchemaValidation schemaValidation) {
//        test = extent.createTest("Activity Report PWS-9070 : Verify that the Activity report page should be accessible");
        String costEstimateUrl = Endpoints.GetCostEstimateSpendEstimatedAsync.getCostEstimateUrl(moveId);
        String customerCode = Endpoints.GetCostEstimateSpendEstimatedAsync.getCustomerCode();
        Map<String, String> headers =
                Map.of("customerCode", customerCode);
        Response response = CommonMethods.sendGetRequest(costEstimateUrl, null, null, headers);
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 2000);
//        ApiCommonAssertions.verifyResponseSchema(response, schemaKey, schemaValidation);

    }
}

