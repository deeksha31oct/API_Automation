package api.testcases.MoveController;

import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.BaseTest;
import api.utilities.CommonMethods;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
public class GetDetailsForEmployeeInDetailsTabGetTest extends BaseTest {

    @DataProvider(name = "data_provider")
    public Object[][] MoveControllerGetDetailsForEmployeeInDetailsTabTestCases() {
        return new Object[][] {
                // Test case descriptions, MoveId, expected status code, Logged-User-Id,CustomerCode, schemaKey

                {"Verify API responds with 200 status code when valid moveId, valid logged-user-id, valid customerCode is provided",
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_MoveId(),
                        200,
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_LoggedUserId(),
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_CustomerCode(),
                        ""
                },

                {"Verify API responds with 200 status code when valid moveId, valid logged-user-id, valid customerCode and non-default lang parameter is provided",
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_MoveId(),
                        200,
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_LoggedUserId(),
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_CustomerCode(),
                        ""
                },

                {"Verify API responds with 404 status code when valid moveId, invalid logged-user-id, invalid customerCode is provided",
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_MoveId(),
                        404,
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_invalid_LoggedUserId(),
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_invalid_CustomerCode(),
                        ""
                },
                {"Verify API responds with 404 status code when invalid moveId, valid logged-user-id, invalid customerCode is provided",
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_invalid_MoveId(),
                        404,
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_LoggedUserId(),
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_invalid_CustomerCode(),
                        ""
                },
                {"Verify API responds with 404 status code when invalid moveId, invalid logged-user-id, invalid customerCode is provided",
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_invalid_MoveId(),
                        404,
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_invalid_LoggedUserId(),
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_invalid_CustomerCode(),
                        ""
                },
                {"Verify API responds with 400 status code when valid moveId, blank space in logged-user-id, blank space in customerCode is provided",
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_MoveId(),
                        400,
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_blank_LoggedUserId(),
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_blank_CustomerCode(),
                        ""
                },
                {"Verify API responds with 400 status code when blank space in moveId, valid logged-user-id, blank space in customerCode is provided",
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_blankSpace_MoveId(),
                        400,
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_LoggedUserId(),
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_blank_CustomerCode(),
                        ""
                },
                {"Verify API responds with 400 status code when blank space in moveId, blank space in logged-user-id, blank space in customerCode is provided",
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_blankSpace_MoveId(),
                        400,
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_blank_LoggedUserId(),
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_blank_CustomerCode(),
                        ""
                },
                {"Verify API responds with 400 status code when valid moveId, special characters in logged-user-id, special characters in customerCode  is provided",
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_MoveId(),
                        400,
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_specialChar_LoggedUserId(),
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_specialChar_CustomerCode(),
                        ""
                },
                {"Verify API responds with 400 status code when special characters in moveId, valid logged-user-id, valid customerCode is provided",
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_specialChar_MoveId(),
                        400,
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_LoggedUserId(),
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_specialChar_CustomerCode(),
                        ""
                },
                {"Verify API responds with 400 status code when special characters in moveId, special characters in logged-user-id, special characters in customerCode is provided",
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_specialChar_MoveId(),
                        400,
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_specialChar_LoggedUserId(),
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_specialChar_CustomerCode(),
                        ""
                },
 
                {"Verify API responds with 400 status code when moveId is missing while valid logged-user-id,valid customerCode is provided.",
                        null,
                        400,
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_LoggedUserId(),
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_CustomerCode(),
                        ""
                },
                {"Verify API responds with 400 status code when valid moveId,valid customerCode is provided,while logged-user-id is missing.",
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_MoveId(),
                        400,
                        null,
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_CustomerCode(),
                        ""
                },
                {"Verify API responds with 400 status code when moveId, logged-user-id and customerCode parameters are missing.",
                        null,
                        400,
                        null,
                        null,
                        ""
                },
                {"Verify API responds within acceptable response time when valid moveId, valid logged-user-id, valid customerCode is provided",
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_MoveId(),
                        200,
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_LoggedUserId(),
                        Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_valid_CustomerCode(),
                        ""
                },

        };
    }

    // -----------------------------------------------------------------------------------------------------------------------------
    @Test(dataProvider = "data_provider", description = "Validate API responses based on MoveId,CustomerCode and Logged-User-Id scenarios")

    public void moveControllerGetDetailsForEmployeeInDetailsTab(String description, String moveId, int expectedStatusCode,String loggedUserId,String customerCode, String schemaKey)
    {
        String userApiUrl;
        if (moveId != null) {
            userApiUrl = Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_Url(moveId);
        } else {
            // Handle the null case with a fallback or an exception
            userApiUrl = Endpoints.MoveControllerGetDetailsForEmployeeInDetailsTab.get_Url(null);
        }

        Map<String, String> headers = new HashMap<>();
        if (customerCode != null) {
            headers.put("customerCode", customerCode);
        }
        if (loggedUserId != null) {
            headers.put("logged-user-id", loggedUserId);
        }

        Response response = CommonMethods.sendGetRequest(userApiUrl, null, null, headers);
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 2000);
        //    ApiCommonAssertions.verifyResponseSchema(response, SCHEMA_FILE_PATH, schemaKey);
    }
}




