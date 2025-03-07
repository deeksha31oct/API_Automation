package api.testcases.AssignmentController;
import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.BaseTest;
import api.utilities.CommonMethods;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetSingleAssignmentTest extends BaseTest {

    @DataProvider(name = "data_provider")
    public Object[][] GetSingleAssignment() {
        return new Object[][]{
                // Test case description,expected status code, Id,  Logged-User-Id,CustomerCode, schemaKey

                {"TC_Assignment_Controller_197 - Verify API responds with 200 status code for valid logged-user-id, valid customerCode, and valid Id path parameter.",
                        200,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_Id(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_LoggedUserId(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_CustomerCode(),
                        ""
                }
                ,
                {"TC_Assignment_Controller_198 - Verify API responds with 404 status code when ld path parameter contains invalid value and valid customerCode and logged-user-id are provided.",
                        404,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_invalid_Id(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_LoggedUserId(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_CustomerCode(),
                        ""
                },
                {"TC_Assignment_Controller_199 - Verify API responds with 404 status code when customerCode header contains invalid value and valid logged-user-id and Id are provided.",
                        404,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_Id(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_LoggedUserId(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_invalid_CustomerCode(),
                        ""
                },
                {"TC_Assignment_Controller_200 - Verify API responds with 404 status code when logged-user-id header contains invalid value and valid customercode and Id are provided.",
                        404,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_Id(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_invalid_LoggedUserId(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_CustomerCode(),
                        ""
                },
                {"TC_Assignment_Controller_201 - Verify API responds with 400 status code when logged-user-id header is missing and valid customerCode and Id are provided.",
                        400,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_Id(),
                        null,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_CustomerCode(),
                        ""
                },
                {"TC_Assignment_Controller_202 - Verify API responds with 400 status code when customerCode header is missing and valid logged-user-id and Id are provided.",
                        400,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_Id(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_LoggedUserId(),
                        null,
                        ""
                },
                {"TC_Assignment_Controller_203 - Verify API responds with 400 status code when Id path parameter is missing and valid logged-user-id and customerCode are provided.",
                        400,
                        null,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_LoggedUserId(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_CustomerCode(),
                        ""
                },
                {"TC_Assignment_Controller_204 - Verify API responds with 400 status code when logged-user-id header contains special characters and valid customerCode and Id are provided.",
                        400,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_Id(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_specialChar_LoggedUserId(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_CustomerCode(),
                        ""
                },
                {"TC_Assignment_Controller_205 - Verify API responds with 400 status code when customerCode header contains special characters and valid logged-user-id and Id are provided.",
                        400,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_Id(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_LoggedUserId(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_specialChar_CustomerCode(),
                        ""
                },
                {"TC_Assignment_Controller_206 - Verify API responds with 400 status code when Id path parameter contains special characters and valid logged-user-id and customerCode are provided.",
                        400,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_specialChar_Id(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_LoggedUserId(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_CustomerCode(),
                        ""
                },
                {"TC_Assignment_Controller_207 - Verify API responds with 400 status code when Id path parameter contains less than minimum character limit and valid logged-user-id and customerCode are provided.",
                        400,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_minlength_Id(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_LoggedUserId(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_CustomerCode(),
                        ""
                },
                {"TC_Assignment_Controller_208 - Verify API responds with 400 status code when Id path parameter contains more than maximum character limit and valid logged-user-id and customerCode are provided.",
                        400,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_maxlength_Id(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_LoggedUserId(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_CustomerCode(),
                        ""
                },
                {"TC_Assignment_Controller_209 - Verify API responds with 400 status code when logged-user-id header contains blank spaces and valid customerCode and Id are provided.",
                        400,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_Id(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_blank_LoggedUserId(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_CustomerCode(),
                        ""
                },
                {"TC_Assignment_Controller_210 - Verify API responds with 400 status code when customerCode header contains blank spaces and valid logged-user-id and Id are provided.",
                        400,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_Id(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_LoggedUserId(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_blank_CustomerCode(),
                        ""
                },
                {"TC_Assignment_Controller_211 - Verify API responds with 400 status code when Id path parameter contains blank spaces and valid logged-user-id and customerCode are provided.",
                        400,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_blank_Id(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_LoggedUserId(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_CustomerCode(),
                        ""
                },
                {"TC_Assignment_Controller_212 - Verify API responds within acceptable response time for valid logged-user-id, valid customerCode, and valid Id path parameter.",
                        200,
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_Id(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_LoggedUserId(),
                        Endpoints.AssigmentControllerGetSingleAssignment.get_valid_CustomerCode(),
                        ""
                }

        };
    }

    // -----------------------------------------------------------------------------------------------------------------------------
    @Test(dataProvider = "data_provider", description = "Validate API responses based on Id,CustomerCode and Logged-User-Id scenarios")

    public void getSingleAssignment(String description,int expectedStatusCode, String Id, String loggedUserId, String customerCode, String schemaKey) {
        String userApiUrl;
        if (Id != null) {
            userApiUrl = Endpoints.AssigmentControllerGetSingleAssignment.get_Url(Id);
        } else {
            // Handle the null case with a fallback or an exception
            userApiUrl = Endpoints.AssigmentControllerGetSingleAssignment.get_Url(null);
        }

        Map<String, String> headers = new HashMap<>();
        if (customerCode != null) {
            headers.put("customerCode", customerCode);
        }
        if (loggedUserId != null) {
            headers.put("logged-user-id", loggedUserId);
        }
        /*
        System.out.println(userApiUrl);
        System.out.println(headers);
        System.out.println("*************************************************************************");
        */

        Response response = CommonMethods.sendGetRequest(userApiUrl, null, null, headers);
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 2000);
        //    ApiCommonAssertions.verifyResponseSchema(response, SCHEMA_FILE_PATH, schemaKey);
    }
}




