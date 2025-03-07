package api.utilities;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import java.io.File;
import java.io.FileNotFoundException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ApiCommonAssertions {
    private static final String SCHEMAS_FOLDER_PATH = "/Users/atif.khan/Documents/Testing_Materials/api-tests/src/main/resources/schemas";  // Update if necessary


    // Verify Status Code
    public static void verifyStatusCode(Response response, int statusCode) {
        try {
            assertEquals(response.getStatusCode(), statusCode, "Status code mismatch");
        } catch (AssertionError e) {
            LoggerUtils.error("Status Code Assertion Failed. Expected: " + statusCode + ", but got: " + response.getStatusCode(), e);
            throw e;
        }
    }
    public static void verifyResponseSchema(Response response, String schemaKey, SchemaValidation schemaValidation) {
        if (schemaValidation == SchemaValidation.REQUIRED) {
            String schemaFilePath = getSchemaFilePath(schemaKey);  // Fetch schema file path dynamically based on API key
            if (schemaFilePath != null) {
                validateSchema(response, schemaFilePath);
            } else {
                throw new RuntimeException("Schema file path is not defined for API key: " + schemaKey);
            }
        } else {
            LoggerUtils.info("Skipping schema validation for this test case.");
        }
    }
    public static String getSchemaFilePath(String schemaKey) {
        // Construct the full path to the schema file based on the schemaKey
        String schemaFilePath = SCHEMAS_FOLDER_PATH + File.separator + schemaKey + ".json";
        File schemaFile = new File(schemaFilePath);
        if (schemaFile.exists()) {
            return schemaFilePath;  // Return the file path if the file exists
        } else {
            LoggerUtils.error("Schema file not found: " + schemaFilePath, new FileNotFoundException("File not found: " + schemaFilePath));  // Pass a generic exception
            return null;
        }
    }
    // Method to actually validate the schema
    private static void validateSchema(Response response, String schemaFilePath) {
        try {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(schemaFilePath)));
            LoggerUtils.info("Schema validation successful for response.");
        } catch (AssertionError e) {
            LoggerUtils.error("Schema validation failed: " + e.getMessage(), e);
            throw e;
        }
    }

    public static void verifyResponseTime(Response response, long maxExpectedTime) {
        long actualResponseTime = response.getTime(); // Get the response time in milliseconds
        // Log the actual response time for debugging
        LoggerUtils.info("Actual Response Time: " + actualResponseTime + " ms");
        // Assert that the actual response time is less than or equal to the maximum expected time
        try {
            assertTrue(actualResponseTime <= maxExpectedTime,
                    String.format("Response time is too high! Expected: <= %d ms but got: %d ms", maxExpectedTime, actualResponseTime));
        } catch (AssertionError e) {
            LoggerUtils.error("Response Time Assertion Failed. Expected: <= " + maxExpectedTime + " ms, but got: " + actualResponseTime + " ms", e);
            throw e;
        }
    }
    public static void verifyFieldEquals(String actualValue, String expectedValue, String errorMessage) {
        try {
            assertEquals(actualValue, expectedValue, errorMessage);
        } catch (AssertionError e) {
            LoggerUtils.error("Field verification failed: " + errorMessage, e);
            throw e;
        }
    }
    public static void verifyFieldBasedOnCondition(Response response, String conditionField, String conditionValue,
                                                   String targetField, String targetValue, String message) {
        // Check if the response is an array or a single object
        String conditionFieldValue;

        // If response is an array, get the first element (index 0)
        if (!response.jsonPath().getList("$").isEmpty()) {
            // Access the first object in the array
            conditionFieldValue = response.jsonPath().getString("[0]." + conditionField);
        } else {
            // Otherwise, the response is a single object
            conditionFieldValue = response.jsonPath().getString(conditionField);
        }

        // Check if the condition is met
        if (conditionValue.equals(conditionFieldValue)) {
            // If condition is met, verify the target field value
            String targetFieldValue;

            // If response is an array, get the target field value from the first element
            if (!response.jsonPath().getList("$").isEmpty()) {
                targetFieldValue = response.jsonPath().getString("[0]." + targetField);
            } else {
                targetFieldValue = response.jsonPath().getString(targetField);
            }

            verifyFieldEquals(targetFieldValue, targetValue, message);
        } else {
            // If condition is not met, log the message and fail the test
            throw new AssertionError("Condition not met. " + message + " Condition field: "
                    + conditionField + " does not equal " + conditionValue + " (Actual: " + conditionFieldValue + ")");
        }
    }



}

