package api.testcases.UserController;

import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.BaseTest;
import api.utilities.CommonMethods;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetMoveScreenFeaturePermissionsGetTest extends BaseTest {

    // DataProvider for the two test cases
    @DataProvider(name = "movePermissionsData")
    public Object[][] movePermissionsData() {
        return new Object[][] {
                {"Verify API returns a 200 status code for a valid request", "statusCode", 200},
                {"Verify the API responds within the acceptable response time (5 seconds)", "responseTime", Endpoints.UserControllerGetMoveScreenFeaturePermissionsTestData.getResponseTimeThreshold()} // Fetching response time from Endpoints
        };
    }

    // Test case 1: Verify API returns a 200 status code for a valid request
    @Test(dataProvider = "movePermissionsData", description = "Validate API responses")
    public void testUserControllerWithValidRequest(String description, String testType, int threshold) {
        String url = Endpoints.UserControllerGetMoveScreenFeaturePermissionsTestData.getMovePermissionsUrl();
        Response response = CommonMethods.sendGetRequest(url, null, null, null);
        if (testType.equals("statusCode")) {
            // Verify the response status code is 200
            ApiCommonAssertions.verifyStatusCode(response, threshold);
        } else if (testType.equals("responseTime")) {
            // Verify the response time is within the acceptable threshold (fetched from Endpoints)
            ApiCommonAssertions.verifyResponseTime(response, threshold);
        }
    }
}
