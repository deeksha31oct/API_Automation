package api.endpoints;

import api.payloads.loginPayload;
import api.utilities.ConfigReader;
import api.utilities.LoggerUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class PostLogin {
    private static final ConfigReader configReader= new ConfigReader("qa");
    //Temporarily ignore the login method and its content
    /*
    public static Response login() {
        String username = configReader.getUserName();
        String password = configReader.getPassword();
        loginPayload payload = new loginPayload();
        payload.setUsername(username);
        payload.setPassword(password);
        RequestSpecification request = RestAssured.given()
                .contentType("application/json")
                .body(payload).queryParam("tenantId","NEWTESTCLIENT" );
                Response response= request.when()
                .post(Endpoints.LoginModule.postLogin);
        LoggerUtils.info("Response Status Code: " + response.getStatusCode());
        LoggerUtils.info("Response Body: ");
        response.prettyPrint();
        if (response.getStatusCode() != 200) {
            LoggerUtils.info("Request Body: ");
            request.log().body();  // Log the request body
        }
        return response;
    }

     */
}
