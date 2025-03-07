package api.testcases.PeopleListController;

import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.BaseTest;
import api.utilities.CommonMethods;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class GetLeftmenuPermissionsGetTest extends BaseTest {

    // DataProvider for Permission Controller Test Cases
    @DataProvider(name = "PermissionControllerTestData")
    public Object[][] providePermissionControllerTestData() {
        return new Object[][]{
                {"TC_permission-controller_094 - Verify API responds with 200 status code for valid customerCode and logged-user-id headers.",
                        Endpoints.GetLeftmenuPermissionsTestData.getValidCustomerCode(),
                        Endpoints.GetLeftmenuPermissionsTestData.getValidLoggedUserId(), 200},

                {"TC_permission-controller_095 - Verify API responds with 400 status code when both customerCode and logged-user-id headers are invalid.",
                        Endpoints.GetLeftmenuPermissionsTestData.getInvalidCustomerCode(),
                        Endpoints.GetLeftmenuPermissionsTestData.getInvalidLoggedUserId(), 400},

                {"TC_permission-controller_096 - Verify API responds with 400 status code when customerCode header is missing and valid logged-user-id is provided.",
                        null,
                        Endpoints.GetLeftmenuPermissionsTestData.getValidLoggedUserId(), 400},

                {"TC_permission-controller_097 - Verify API responds with 400 status code when logged-user-id header is missing and valid customerCode is provided.",
                        Endpoints.GetLeftmenuPermissionsTestData.getValidCustomerCode(),
                        null, 400},

                {"TC_permission-controller_098 - Verify API responds with 400 status code when both customerCode and logged-user-id headers are missing.",
                        null, null, 400},

                {"TC_permission-controller_099 - Verify API responds with 400 status code for invalid customerCode and valid logged-user-id.",
                        Endpoints.GetLeftmenuPermissionsTestData.getInvalidCustomerCode(),
                        Endpoints.GetLeftmenuPermissionsTestData.getValidLoggedUserId(), 400},

                {"TC_permission-controller_100 - Verify API responds with 400 status code for valid customerCode and invalid logged-user-id.",
                        Endpoints.GetLeftmenuPermissionsTestData.getValidCustomerCode(),
                        Endpoints.GetLeftmenuPermissionsTestData.getInvalidLoggedUserId(), 400},

                {"TC_permission-controller_101 - Verify API responds with 400 status code when customerCode header contains blank value and valid logged-user-id is provided.",
                        Endpoints.GetLeftmenuPermissionsTestData.getBlankCustomerCode(),
                        Endpoints.GetLeftmenuPermissionsTestData.getValidLoggedUserId(), 400},

                {"TC_permission-controller_102 - Verify API responds with 400 status code when logged-user-id header contains blank value and valid customerCode is provided.",
                        Endpoints.GetLeftmenuPermissionsTestData.getValidCustomerCode(),
                        Endpoints.GetLeftmenuPermissionsTestData.getBlankLoggedUserId(), 400},

                {"TC_permission-controller_103 - Verify API responds with 400 status code when both customerCode and logged-user-id headers contain blank values.",
                        Endpoints.GetLeftmenuPermissionsTestData.getBlankCustomerCode(),
                        Endpoints.GetLeftmenuPermissionsTestData.getBlankLoggedUserId(), 400},

                {"TC_permission-controller_104 - Verify API responds with 400 status code when customerCode header contains only spaces and valid logged-user-id is provided.",
                        Endpoints.GetLeftmenuPermissionsTestData.getCustomerCodeWithSpaces(),
                        Endpoints.GetLeftmenuPermissionsTestData.getValidLoggedUserId(), 400},

                {"TC_permission-controller_105 - Verify API responds with 400 status code when logged-user-id header contains only spaces and valid customerCode is provided.",
                        Endpoints.GetLeftmenuPermissionsTestData.getValidCustomerCode(),
                        Endpoints.GetLeftmenuPermissionsTestData.getLoggedUserIdWithSpaces(), 400},

                {"TC_permission-controller_106 - Verify API responds with 400 status code when both customerCode and logged-user-id headers contain only spaces.",
                        Endpoints.GetLeftmenuPermissionsTestData.getCustomerCodeWithSpaces(),
                        Endpoints.GetLeftmenuPermissionsTestData.getLoggedUserIdWithSpaces(), 400},

                {"TC_permission-controller_107 - Verify API responds with 400 status code when customerCode header contains special characters and valid logged-user-id is provided.",
                        Endpoints.GetLeftmenuPermissionsTestData.getSpecialCharCustomerCode(),
                        Endpoints.GetLeftmenuPermissionsTestData.getValidLoggedUserId(), 400},

                {"TC_permission-controller_108 - Verify API responds with 400 status code when logged-user-id header contains special characters and valid customerCode is provided.",
                        Endpoints.GetLeftmenuPermissionsTestData.getValidCustomerCode(),
                        Endpoints.GetLeftmenuPermissionsTestData.getSpecialCharLoggedUserId(), 400},

                {"TC_permission-controller_109 - Verify API responds with 400 status code when both customerCode and logged-user-id headers contain special characters.",
                        Endpoints.GetLeftmenuPermissionsTestData.getSpecialCharCustomerCode(),
                        Endpoints.GetLeftmenuPermissionsTestData.getSpecialCharLoggedUserId(), 400},

                {"TC_permission-controller_110 - Verify API responds within acceptable response time for valid customerCode and logged-user-id headers.",
                        Endpoints.GetLeftmenuPermissionsTestData.getValidCustomerCode(),
                        Endpoints.GetLeftmenuPermissionsTestData.getValidLoggedUserId(), 200}
        };
    }

    @Test(dataProvider = "PermissionControllerTestData", description = "Validate Permission Controller API responses for various scenarios")
    public void testPermissionController(String description, String customerCode, String loggedUserId, int expectedStatusCode) {
//        System.out.println("Running test case: " + description);
        String apiUrl = Endpoints.GetLeftmenuPermissionsTestData.getLeftMenuPermissionsUrl();
        Map<String, String> headers = Map.of(
                "customerCode", customerCode != null ? customerCode : "",
                "logged-user-id", loggedUserId != null ? loggedUserId : ""
        );
//        System.out.println("Request Headers: " + headers);
        Response response = CommonMethods.sendGetRequest(apiUrl, null, null, headers);
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 5000);


    }
}

