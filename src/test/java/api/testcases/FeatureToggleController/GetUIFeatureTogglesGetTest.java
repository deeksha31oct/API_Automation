package api.testcases.FeatureToggleController;

import api.endpoints.Endpoints;
import api.utilities.ApiCommonAssertions;
import api.utilities.BaseTest;
import api.utilities.CommonMethods;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Map;
import io.restassured.response.Response;

public class GetUIFeatureTogglesGetTest extends BaseTest {
//    private static final String SCHEMA_FILE_PATH = "/path/to/your/schemas/featureToggleSchema.json";

    @DataProvider(name = "featureToggleProvider")
    public Object[][] featureToggleProvider() {
        return new Object[][] {
                {"Verify response with valid personId and customerCode.", Endpoints.FeatureToggleController.getValidPersonId(), 200, Endpoints.FeatureToggleController.getValidCustomerCode(), "ValidPersonIdAndCustomerCode"},
                {"Verify response with invalid personId and invalid customerCode.", Endpoints.FeatureToggleController.getInvalidPersonId(), 400, Endpoints.FeatureToggleController.getInvalidCustomerCode(), "InvalidPersonIdAndInvalidCustomerCode"},
                {"Verify response with personId and customerCode containing blank spaces.", Endpoints.FeatureToggleController.getBlankPersonId(), 404, Endpoints.FeatureToggleController.getBlankCustomerCode(), "PersonIdAndCustomerCodeWithBlankSpaces"},
                {"Verify response with blank customerCode header.", Endpoints.FeatureToggleController.getValidPersonId(), 400, Endpoints.FeatureToggleController.getBlankCustomerCode(), "ValidPersonIdAndBlankCustomerCode"},
                {"Verify response with blank personId header.", Endpoints.FeatureToggleController.getBlankPersonId(), 404, Endpoints.FeatureToggleController.getValidCustomerCode(), "BlankPersonIdAndValidCustomerCode"},
                {"Verify response with both personId and customerCode missing.", null, 400, null, "MissingPersonIdAndMissingCustomerCode"},
                {"Verify response time with valid personId and customerCode.", Endpoints.FeatureToggleController.getValidPersonId(), 200, Endpoints.FeatureToggleController.getValidCustomerCode(), "VerifyResponseTimeWithValidPersonIdAndCustomerCode"}
        };
    }
    @Test(dataProvider = "featureToggleProvider", description = "Validate Feature Toggle API responses based on personId and customerCode scenarios")
    public void featureToggleControllerWithPersonId(String description, String personId, int expectedStatusCode, String customerCode, String schemaKey) {
        String featureToggleApiUrl = Endpoints.FeatureToggleController.getFeatureToggleUrl();
        Map<String, String> headers = Map.of(
                "personId", personId != null ? personId : "",
                "customerCode", customerCode != null ? customerCode : ""
        );
        Response response = CommonMethods.sendGetRequest(featureToggleApiUrl, null, null, headers);
        ApiCommonAssertions.verifyStatusCode(response, expectedStatusCode);
        ApiCommonAssertions.verifyResponseTime(response, 5000);
//        ApiCommonAssertions.verifyResponseSchema(response, SCHEMA_FILE_PATH, schemaKey);
    }
}