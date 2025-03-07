package api.utilities;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ConfigReader {
    private final JSONObject jsonObject;
    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
    private String environment; // Hold current environment
    private static final String PATH= "src/main/resources/config.json";
    public ConfigReader(String environment) {
        this.environment = environment;
        this.jsonObject = loadConfig();
//        logger.info("Loaded Configuration: {}", jsonObject.toString(4));
//        logger.debug("Loaded Configuration: {}", jsonObject.toString(4));
// Pretty print the JSON
    }
    // Load the configuration file and return the JSONObject
    private JSONObject loadConfig() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(PATH)));
            return new JSONObject(content);
        } catch (IOException e) {
            logger.error("Failed to read configuration file for environment: {}", environment, e);
            throw new RuntimeException("Failed to read configuration file for environment: " + environment, e);
        }
    }
    // Generic method to get any parameter value using a key path
    public String getConfigValue(String environment, String... keys) {
        // Validate if keys are provided
        if (keys == null || keys.length == 0) {
            throw new IllegalArgumentException("At least one key must be provided.");
        }
        // Get the environment JSON object
        JSONObject currentObject = jsonObject.optJSONObject(environment);

        // If environment object is not found, log and return null
        if (currentObject == null) {
            logger.error("Environment '{}' not found in the configuration.", environment);
            return null;
        }
        // Traverse through each key except the last one
        for (int i = 0; i < keys.length - 1; i++) {
            if (!currentObject.has(keys[i]) || !(currentObject.get(keys[i]) instanceof JSONObject)) {
                logger.error("Key '{}' not found or is not a JSONObject in environment '{}'.", keys[i], environment);
                return null;
            }
            currentObject = currentObject.getJSONObject(keys[i]);
        }
        // Get the value for the last key
        String lastKey = keys[keys.length - 1];
        if (currentObject.has(lastKey)) {
            String value = currentObject.getString(lastKey);
            logger.info("Found value for key '{}': {}", lastKey, value);
            return value;
        } else {
            logger.error("Key '{}' not found in the environment '{}' configuration.", lastKey, environment);
            return null;
        }
    }
    public String getQaApiBaseUrl(){
        return jsonObject.getJSONObject("qa").getString("api_base_url");
    }
    public String getUserName(){
        return jsonObject.getJSONObject("qa").getString("username");
    }
    public String getPassword(){
        return jsonObject.getJSONObject("qa").getString("password");
    }
    public String getClientId(){
        return jsonObject.getJSONObject("qa").getString("client_id");
    }
    public String getEnvironmentVariable(String key) {
        try {
            return jsonObject.getJSONObject("environmentVariable").getString(key);
        } catch (Exception e) {
            logger.error("Failed to set getEnvironmentVariable from configuration file", e);
            throw new RuntimeException("Failed to get '" + key + "' from environmentVariable in config file", e);

        }
    }
    public void setEnvironmentVariable(String key, String value) {
        try {
            JSONObject envVars = jsonObject.getJSONObject("environmentVariable");
            envVars.put(key, value);
            saveConfig();
        } catch (Exception e) {
            logger.error("Failed to set setEnvironmentVariable in configuration file", e);
            throw new RuntimeException("Failed to set '" + key + "' in environmentVariable in config file", e);
        }
    }
    private void saveConfig() {
        try {
            Files.write(Paths.get(PATH), jsonObject.toString(4).getBytes());
        } catch (IOException e) {
            logger.error("Failed to save EnvironmentVariable in configuration file", e);
            throw new RuntimeException("Failed to save configuration file", e);
        }
    }
}