package api.utilities;

import api.endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

import static api.utilities.LoggerUtils.*;

public class CommonMethods {

    public static Response sendPostRequest(String endpoint, Object payload, Map<String, String> queryParams, String token) {
        return sendRequest("POST", endpoint, payload, queryParams, token, null);
    }

    public static Response sendPutRequest(String endpoint, Object payload, Map<String, String> queryParams, String token) {
        return sendRequest("PUT", endpoint, payload, queryParams, token, null);
    }

    public static Response sendGetRequest(String endpoint, Map<String, String> queryParams, String token, Map<String, String> headers) {
        return sendRequest("GET", endpoint, null, queryParams, token, headers);
    }

    public static Response sendPatchRequest(String endpoint, Object payload, Map<String, String> queryParams, String token) {
        return sendRequest("PATCH", endpoint, payload, queryParams, token, null);
    }
    public static Response sendDeleteRequest(String endpoint, Map<String, String> queryParams, String token) {
        return sendRequest("DELETE", endpoint, null, queryParams, token, null);
    }
    private static Response sendRequest(String method, String endpoint, Object payload, Map<String, String> queryParams, String token,Map<String, String> headers) {
        if (endpoint == null || endpoint.isEmpty()) {
            throw new IllegalArgumentException("Endpoint cannot be null or empty");
        }
            RequestSpecification request = RestAssured.given().contentType("application/json");

        // Adding Bearer token if provided
        if (token != null && !token.isEmpty()) {
            request.header("Authorization", "Bearer " + token);
        }
        if (headers != null && !headers.isEmpty()) {
            headers.forEach(request::header);
        }
        // Adding request body if provided
        if (payload != null) {
            request.body(payload);
        }
        if (queryParams != null) {
            request.queryParams(queryParams);
        }

        // Making the API call based on the HTTP method
        Response response = switch (method) {
            case "POST" -> request.post(endpoint);
            case "PUT" -> request.put(endpoint);
            case "GET" -> request.get(endpoint);
            case "PATCH" -> request.patch(endpoint);
            default -> throw new IllegalArgumentException("Invalid HTTP method: " + method);
        };

        // Logging response details
        info("Response Status Code: " + response.getStatusCode());
        response.prettyPrint();
        return response;
    }
}
