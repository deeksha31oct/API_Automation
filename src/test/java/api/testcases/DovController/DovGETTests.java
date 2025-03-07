package api.testcases.DovController;

import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.BaseTest;
import api.utilities.CommonMethods;
import api.utilities.LoggerUtils;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class DovGETTests extends BaseTest {

    // DataProvider to provide various test data
    @DataProvider(name = "DovControllerGets")
    public Object[][] provideDovTestCases() {
        return new Object[][]{
                // Test case 1: Valid customerCode and valid DOV
                {"TC_dov-controller_068-Verify response with 200 status code for valid customerCode and valid DOV",
                        Endpoints.DovControllerGets.getValidCustomerCode(),
                        Endpoints.DovControllerGets.getValidDOV(), 200},
                // Test case 2: Missing customerCode (null), valid DOV
                {"TC_dov-controller_069-Verify response with 400 status code for missing customerCode and valid DOV",
                        null, Endpoints.DovControllerGets.getValidDOV(), 400},

                // Test case 3: Missing DOV (null), valid customerCode
                {"TC_dov-controller_070-Verify response with 400 status code for missing DOV and valid customerCode",
                        Endpoints.DovControllerGets.getValidCustomerCode(),
                        null, 400},

                // Test case 4: Invalid customerCode, valid DOV
                {"TC_dov-controller_071-Verify response with 400 status code for invalid customerCode and valid DOV",
                        Endpoints.DovControllerGets.getInvalidCustomerCode(),
                        Endpoints.DovControllerGets.getValidDOV(), 400},

                // Test case 5: Valid customerCode, invalid DOV
                {"TC_dov-controller_072-Verify response with 400 status code for valid customerCode and invalid DOV",
                        Endpoints.DovControllerGets.getValidCustomerCode(),
                        Endpoints.DovControllerGets.getInvalidDOV(), 400},

                // Test case 6: Valid customerCode, special character DOV
                {"TC_dov-controller_073-Verify response with 400 status code for valid customerCode and DOV containing special characters",
                        Endpoints.DovControllerGets.getValidCustomerCode(),
                        Endpoints.DovControllerGets.getSpecialCharDOV(), 400},

                // Test case 7: Blank customerCode (empty), valid DOV
                {"TC_dov-controller_074-Verify response with 400 status code for blank customerCode and valid DOV",
                        Endpoints.DovControllerGets.getBlankCustomerCode(),
                        Endpoints.DovControllerGets.getValidDOV(), 400},

                // Test case 8: Blank DOV (empty), valid customerCode
                {"TC_dov-controller_075-Verify response with 400 status code for blank DOV and valid customerCode",
                        Endpoints.DovControllerGets.getValidCustomerCode(),
                        Endpoints.DovControllerGets.getBlankDOV(), 400},

                // Test case 9: customerCode and DOV with only blank spaces
                {"TC_dov-controller_076-Verify response with 400 status code for customerCode and DOV containing only blank spaces",
                        Endpoints.DovControllerGets.getCustomerCodeWithSpaces(),
                        Endpoints.DovControllerGets.getBlankDOV(), 400},

                // Test case 10: Verify response time for valid customerCode and valid DOV
                {"TC_dov-controller_077-Verify response time is within acceptable limits for valid customerCode and valid DOV",
                        Endpoints.DovControllerGets.getValidCustomerCode(),
                        Endpoints.DovControllerGets.getValidDOV(), 200}
        };
    }

    @Test(dataProvider = "DovControllerGets", description = "Validate DOV Controller API responses for various customerCode and DOV scenarios")
    public void testDovControllerGets(String description, String customerCode, String dov, int expectedStatusCode) {
//        System.out.println("Running test case: " + description);
        String dovControllerApiUrl = Endpoints.DovControllerGets.getDovUrl(dov);
        LoggerUtils.info("Request URL: " + dovControllerApiUrl);
        Map<String, String> headers = Map.of(
                "customerCode", customerCode != null ? customerCode : ""
        );
//        System.out.println("Request Headers: " + headers);
        Response response = CommonMethods.sendGetRequest(dovControllerApiUrl, null, null, headers);
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 5000);
        LoggerUtils.info("API Response: " + response.getBody().asString());
//        ApiCommonAssertions.verifyResponseSchema(response, SCHEMA_FILE_PATH, "dovSchemaKey");
        if (description.contains("TC_dov-controller_068-Verify response with 200 status code for valid customerCode and valid DOV")) {
            ApiCommonAssertions.verifyFieldBasedOnCondition(
                    response,
                    "assignmentStatusCategoryCode", "Draft",
                    "assignmentStatusDesc", "draftInitiation",
                    "When assignmentStatusCategoryCode is 'Draft', assignmentStatusDesc should be 'draftInitiation'"
            );
        }
    }
}