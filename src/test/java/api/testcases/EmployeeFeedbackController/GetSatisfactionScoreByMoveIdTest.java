package api.testcases.EmployeeFeedbackController;

import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.BaseTest;
import api.utilities.CommonMethods;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetSatisfactionScoreByMoveIdTest extends BaseTest {

    @DataProvider(name = "data_provider")
    public Object[][] employeeFeedbackGetSatisfactionScoreByMoveIdTestCases() {
        return new Object[][] {
                // Description, moveId, expectedStatusCode, schemaKey
                {"TC_EmployeeFeedback_213: Verify API responds with a 200 status code when the valid moveId path parameter is provided",
                        Endpoints.EmployeeFeedbackGetSatisfactionScoreByMoveTestData.getValidMoveId(),
                        200,
                        "GetSatisfactionScoreValidSchema"},

                {"TC_EmployeeFeedback_214: Verify API responds with a 404 status code when an invalid moveId is provided",
                        Endpoints.EmployeeFeedbackGetSatisfactionScoreByMoveTestData.getInvalidMoveId(),
                        404,
                        "GetSatisfactionScoreInvalidMoveIdSchema"},

                {"TC_EmployeeFeedback_215: Verify API responds with a 400 status code when the moveId path parameter is missing",
                        null,
                        400,
                        "GetSatisfactionScoreMissingMoveIdSchema"},

                {"TC_EmployeeFeedback_216: Verify API responds with a 400 status code when the moveId path parameter contains special characters",
                        Endpoints.EmployeeFeedbackGetSatisfactionScoreByMoveTestData.getSpecialCharacterMoveId(),
                        400,
                        "GetSatisfactionScoreSpecialCharMoveIdSchema"},

                {"TC_EmployeeFeedback_217: Verify API responds with a 400 status code when the moveId path parameter contains alphanumeric characters",
                        "123AB",
                        400,
                        "GetSatisfactionScoreAlphanumericMoveIdSchema"},

                {"TC_EmployeeFeedback_218: Verify API responds with a 400 status code when the moveId path parameter contains letters only",
                        "ABCDE",
                        400,
                        "GetSatisfactionScoreLettersOnlyMoveIdSchema"},

                {"TC_EmployeeFeedback_219: Verify API responds with a 400 status code when the moveId path parameter contains fewer than 5 digits",
                        "1234",
                        400,
                        "GetSatisfactionScoreFewerThan5DigitsMoveIdSchema"},

                {"TC_EmployeeFeedback_220: Verify API responds with a 400 status code when the moveId path parameter contains more than 5 digits",
                        "123456",
                        400,
                        "GetSatisfactionScoreMoreThan5DigitsMoveIdSchema"},

                {"TC_EmployeeFeedback_221: Verify API responds with a 400 status code when the moveId path parameter contains blank spaces only",
                        "   ",
                        400,
                        "GetSatisfactionScoreBlankSpacesMoveIdSchema"},

                {"TC_EmployeeFeedback_222: Verify API responds with a 400 status code when the moveId path parameter contains SQL injection characters",
                        "'; DROP TABLE --",
                        400,
                        "GetSatisfactionScoreSQLInjectionMoveIdSchema"},

                {"TC_EmployeeFeedback_223: Verify API responds within an acceptable response time when the valid moveId path parameter is provided",
                        Endpoints.EmployeeFeedbackGetSatisfactionScoreByMoveTestData.getValidMoveId(),
                        200,
                        "GetSatisfactionScoreValidSchema"}
        };
    }

    // -----------------------------------------------------------------------------------------------------------------------------
    @Test(dataProvider = "data_provider", description = "Validate API responses based on moveId scenarios")
    public void getSatisfactionScoreByMoveId(String description, String moveId, int expectedStatusCode, String schemaKey) {
        String userApiUrl = Endpoints.EmployeeFeedbackGetSatisfactionScoreByMoveTestData.getSatisfactionScoreByMoveUrl(moveId);
        Response response = CommonMethods.sendGetRequest(userApiUrl, null, null, null);
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 5000);
        // ApiCommonAssertions.verifySchema(response, schemaKey);
    }


}
