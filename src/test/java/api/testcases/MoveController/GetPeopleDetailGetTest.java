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

public class GetPeopleDetailGetTest extends BaseTest {

    @DataProvider(name = "data_provider")
    public Object[][] MoveControllerGetPeopleDetailTestCases() {
        return new Object[][] {
                // Test case descriptions, MoveId, expected status code, Logged-User-Id,CustomerCode, schemaKey

                {"Verify API responds with 200 status code when valid moveId, valid logged-user-id, and valid customerCode is provided",
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_MoveId(),
                        200,
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_LoggedUserId(),
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_CustomerCode(),
                        ""
                },

                {"Verify API responds with 404 status code when valid moveId, invalid logged-user-id, and invalid customerCode is provided",
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_MoveId(),
                        404,
                        Endpoints.MoveControllerGetPeopleDetail.get_invalid_LoggedUserId(),
                        Endpoints.MoveControllerGetPeopleDetail.get_invalid_CustomerCode(),
                        ""
                },
                {"Verify API responds with 404 status code when invalid moveId, valid logged-user-id, and invalid customerCode is provided",
                        Endpoints.MoveControllerGetPeopleDetail.get_invalid_MoveId(),
                        404,
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_LoggedUserId(),
                        Endpoints.MoveControllerGetPeopleDetail.get_invalid_CustomerCode(),
                        ""
                },
                {"Verify API responds with 404 status code when invalid moveId, invalid logged-user-id, and invalid customerCode is provided",
                        Endpoints.MoveControllerGetPeopleDetail.get_invalid_MoveId(),
                        404,
                        Endpoints.MoveControllerGetPeopleDetail.get_invalid_LoggedUserId(),
                        Endpoints.MoveControllerGetPeopleDetail.get_invalid_CustomerCode(),
                        ""
                },

                {"Verify API responds with 400 status code when valid moveId, blank space in logged-user-id, and blank space in customerCode is provided",
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_MoveId(),
                        400,
                        Endpoints.MoveControllerGetPeopleDetail.get_blank_LoggedUserId(),
                        Endpoints.MoveControllerGetPeopleDetail.get_blank_CustomerCode(),
                        ""
                },
                {"Verify API responds with 400 status code when blank space in moveId, valid logged-user-id, and blank space in customerCode is provided",
                        Endpoints.MoveControllerGetPeopleDetail.get_blank_MoveId(),
                        400,
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_LoggedUserId(),
                        Endpoints.MoveControllerGetPeopleDetail.get_blank_CustomerCode(),
                        ""
                },
                {"Verify API responds with 400 status code when blank space in moveId, blank space in logged-user-id, and blank space in customerCode is provided",
                        Endpoints.MoveControllerGetPeopleDetail.get_blank_MoveId(),
                        400,
                        Endpoints.MoveControllerGetPeopleDetail.get_blank_LoggedUserId(),
                        Endpoints.MoveControllerGetPeopleDetail.get_blank_CustomerCode(),
                        ""
                },

                {"Verify API responds with 400 status code when valid moveId, special characters in logged-user-id, and special characters in customerCode is provided",
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_MoveId(),
                        400,
                        Endpoints.MoveControllerGetPeopleDetail.get_specialChar_LoggedUserId(),
                        Endpoints.MoveControllerGetPeopleDetail.get_specialChar_CustomerCode(),
                        ""
                },
                {"Verify API responds with 400 status code when special characters in moveId, valid logged-user-id, and special characters customerCode is provided",
                        Endpoints.MoveControllerGetPeopleDetail.get_specialChar_MoveId(),
                        400,
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_LoggedUserId(),
                        Endpoints.MoveControllerGetPeopleDetail.get_specialChar_CustomerCode(),
                        ""
                },
                {"Verify API responds with 400 status code when special characters in moveId, special characters in logged-user-id, and special characters in customerCode is provided",
                        Endpoints.MoveControllerGetPeopleDetail.get_specialChar_MoveId(),
                        400,
                        Endpoints.MoveControllerGetPeopleDetail.get_specialChar_LoggedUserId(),
                        Endpoints.MoveControllerGetPeopleDetail.get_specialChar_CustomerCode(),
                        ""
                },

                {"Verify API responds with 400 status code when missing moveId, valid logged-user-id, and valid customerCode is provided",
                        null,
                        400,
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_LoggedUserId(),
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_CustomerCode(),
                        ""
                },
                {"Verify API responds with 400 status code when valid moveId, missing logged-user-id, and valid customerCode is provided",
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_MoveId(),
                        400,
                        null,
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_CustomerCode(),
                        ""
                },
                {"Verify API responds  with 400  status code when missing moveId, missing logged-user-id, and missing customerCode is provided",
                        null,
                        400,
                        null,
                        null,
                        ""
                },
				{"Verify API responds within acceptable response time when valid moveId, valid logged-user-id, and valid customerCode is provided",
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_MoveId(),
                        200,
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_LoggedUserId(),
                        Endpoints.MoveControllerGetPeopleDetail.get_valid_CustomerCode(),
                        ""
                }

        };
    }

    // -----------------------------------------------------------------------------------------------------------------------------
    @Test(dataProvider = "data_provider", description = "Validate API responses based on MoveId,CustomerCode and Logged-User-Id scenarios")

    public void moveControllerGetPeopleDetail(String description, String moveId, int expectedStatusCode,String loggedUserId,String customerCode, String schemaKey)
    {
        String userApiUrl;
        if (moveId != null) {
            userApiUrl =Endpoints.MoveControllerGetPeopleDetail.get_Url(moveId);
        } else {
            // Handle the null case with a fallback or an exception
            userApiUrl =Endpoints.MoveControllerGetPeopleDetail.get_Url(null);
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




