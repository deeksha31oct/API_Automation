package api.utilities;
import api.payloads.loginPayload;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Map;

public class BaseTest extends CommonMethods {

    protected static ConfigReader configReader;
    protected static String baseUrl;
    protected static String authToken;

    @BeforeClass
    public void setUp() {
        // Initialize ConfigReader and base URL
        configReader = new ConfigReader("qa");
        baseUrl = configReader.getQaApiBaseUrl();
        RestAssured.baseURI = baseUrl;
    }
    protected Response performLogin() {
        String username = configReader.getUserName();
        String password = configReader.getPassword();
        String tenantId = configReader.getClientId();
        loginPayload payload = new loginPayload();
        payload.setUsername(username);
        payload.setPassword(password);

        Response response = sendPostRequest(
                "/authentication/authenticate", payload, Map.of("tenantId", tenantId), null
        );
        LoggerUtils.info("Login Response Body: " + response.asString());

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Login failed with status code: " + response.getStatusCode());
        }

        // Return the Response object for further processing
        return response; // Return the Response directly
    }
    @AfterClass
    public void tearDown() {
        // Any global tear down tasks
        System.out.println("Teardown: Cleaning up resources...");
        // Cleanup logic goes here, if needed
    }

}
