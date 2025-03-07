package api.endpoints;

import api.utilities.ConfigReader;

public class
Endpoints {
    private static final String ENVIRONMENT = "qa"; // You can change this to "dev" as needed
    private static final ConfigReader configReader = new ConfigReader(ENVIRONMENT); // Create a static instance
    public static final String Base_Url = configReader.getConfigValue(ENVIRONMENT, "api_base_url");

    public static class GetCostEstimateSpendEstimatedAsync {
        // Fetch move IDs
        public static String getValidMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateSpendEstimatedAsync", "validMoveId");
        }

        public static String getInvalidMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateSpendEstimatedAsync", "invalidMoveId");
        }

        public static String getIncorrectMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateSpendEstimatedAsync", "incorrectMoveId");
        }

        public static String getBlankMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateSpendEstimatedAsync", "blankMoveId");
        }

        public static String getMoveIdWithSpaces() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateSpendEstimatedAsync", "moveIdWithSpaces");
        }

        public static String getCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateSpendEstimatedAsync", "customerCode");
        }

        public static String getBlankCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateSpendEstimatedAsync", "blankCustomerCode");
        }

        public static String getCustomerCodeWithSpaces() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateSpendEstimatedAsync", "customerCodeWithSpaces");
        }

        public static String getCustomerCodeWithSpecialChars() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateSpendEstimatedAsync", "customerCodeWithSpecialChars");
        }

        public static String getCustomerCodeWithSpacesAndSpecialChars() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateSpendEstimatedAsync", "customerCodeWithSpacesAndSpecialChars");
        }

        public static String getLang() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateSpendEstimatedAsync", "lang");
        }

        public static String getLangWithSpaces() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateSpendEstimatedAsync", "langWithSpaces");
        }

        public static String getOptionalLang() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateSpendEstimatedAsync", "optionalLang");
        }

        // Updated URL method based on provided test case structure
        public static String getCostEstimateUrl(String moveId) {
            return Base_Url + "/v1/cost-estimate/move/" + moveId + "/spend-estimated";
        }
    }

    public static class UserController {

        // Fetch topiaPerson IDs
        public static String getValidTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "userController", "validTopiaPersonId");
        }

        public static String getInvalidTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "userController", "invalidTopiaPersonId");
        }

        public static String getBlankTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "userController", "blankTopiaPersonId");
        }

        public static String getEmptyTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "userController", "emptyTopiaPersonId");
        }

        public static String getNonIntegerTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "userController", "nonIntegerTopiaPersonId");
        }

        // Fetch customer codes
        public static String getValidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "userController", "validCustomerCode");
        }

        public static String getInvalidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "userController", "invalidCustomerCode");
        }

        public static String getMissingCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "userController", "missingCustomerCode");
        }

        public static String getBlankCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "userController", "blankCustomerCode");
        }

        public static String getEmptyCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "userController", "emptyCustomerCode");
        }

        public static String getUnsupportedCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "userController", "unsupportedCustomerCode");
        }

        // Constructing the User API URL with topiaPersonId
        public static String getUserApiUrl(String topiaPersonId) {
            // If the topiaPersonId is passed, append it to the URL, otherwise return the URL without it
            return topiaPersonId != null && !topiaPersonId.trim().isEmpty()
                    ? Base_Url + "/v1/users/" + topiaPersonId
                    : Base_Url + "/v1/users";  // If personId is null or empty, return the base URL without personId
        }
    }

    public static class FeatureToggleController {
        // Fetch Person IDs and Customer Codes from configuration
        public static String getValidPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "featureToggleController", "validPersonId");
        }

        public static String getInvalidPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "featureToggleController", "invalidPersonId");
        }

        public static String getBlankPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "featureToggleController", "blankPersonId");
        }

        public static String getValidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "featureToggleController", "validCustomerCode");
        }

        public static String getInvalidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "featureToggleController", "invalidCustomerCode");
        }

        public static String getBlankCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "featureToggleController", "blankCustomerCode");
        }

        public static String getResponseTimeThreshold() {
            return configReader.getConfigValue("getBaseVariableValue", "featureToggleController", "responseTimeThreshold");
        }

        public static String getLang() {
            return configReader.getConfigValue("getBaseVariableValue", "featureToggleController", "lang");
        }

        // Method to construct Feature Toggle URL with headers (PersonId and CustomerCode)
        public static String getFeatureToggleUrl() {
            String validPersonId = getValidPersonId();
            String validCustomerCode = getValidCustomerCode();

            // Construct the URL dynamically by appending the valid personId and customerCode
            return Base_Url + "/v1/feature-toggle/ui?personId=" + validPersonId + "&customerCode=" + validCustomerCode;
        }

    }

    public static class ProfileImage {

        // Fetch Topia Person IDs
        public static String getValidTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "profileImageRetrieval", "validTopiaPersonId");
        }

        public static String getInvalidTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "profileImageRetrieval", "invalidTopiaPersonId");
        }

        public static String getSpecialCharTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "profileImageRetrieval", "specialCharTopiaPersonId");
        }

        public static String getMaxLengthTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "profileImageRetrieval", "maxLengthTopiaPersonId");
        }

        public static String getEmptyTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "profileImageRetrieval", "emptyTopiaPersonId");
        }

        // Fetch Customer Codes
        public static String getValidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "profileImageRetrieval", "validCustomerCode");
        }

        public static String getInvalidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "profileImageRetrieval", "invalidCustomerCode");
        }

        public static String getEmptyCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "profileImageRetrieval", "emptyCustomerCode");
        }

        // Fetch Logged User IDs
        public static String getValidLoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "profileImageRetrieval", "validLoggedUserId");
        }

        public static String getInvalidLoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "profileImageRetrieval", "invalidLoggedUserId");
        }

        public static String getEmptyLoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "profileImageRetrieval", "emptyLoggedUserId");
        }

        // Construct Profile Image URL
        public static String getProfileImageUrl(String topiaPersonId) {
            return Base_Url + "/v1/employees/" + topiaPersonId + "/profile-image";
        }
    }

    public static class savedSearchController {

        // Fetch View Table Codes
        public static String getValidViewTableCode() {
            return configReader.getConfigValue("getBaseVariableValue", "savedSearchController", "validViewTableCode");
        }

        public static String getInvalidViewTableCode() {
            return configReader.getConfigValue("getBaseVariableValue", "savedSearchController", "invalidViewTableCode");
        }

        public static String getSpecialCharViewTableCode() {
            return configReader.getConfigValue("getBaseVariableValue", "savedSearchController", "specialCharViewTableCode");
        }

        public static String getMaxLengthViewTableCode() {
            return configReader.getConfigValue("getBaseVariableValue", "savedSearchController", "maxLengthViewTableCode");
        }

        public static String getBlankViewTableCode() {
            return configReader.getConfigValue("getBaseVariableValue", "savedSearchController", "blankViewTableCode");
        }

        public static String getViewTableCodeWithSpaces() {
            return configReader.getConfigValue("getBaseVariableValue", "savedSearchController", "viewTableCodeWithSpaces");
        }

        // Fetch Customer Codes
        public static String getValidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "savedSearchController", "validCustomerCode");
        }

        public static String getInvalidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "savedSearchController", "invalidCustomerCode");
        }

        public static String getBlankCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "savedSearchController", "blankCustomerCode");
        }

        public static String getMissingCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "savedSearchController", "missingCustomerCode");
        }

        // Construct Saved Search URL
        public static String getSavedSearchUrl(String viewTableCode) {
            return Base_Url + "/api/v1/savedsearches/" + viewTableCode;
        }
    }

    public static class TaskFullControllerTaskCategories {
        // Fetch Customer Codes
        public static String getValidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "TaskFullControllerTaskCategories", "validCustomerCode");
        }

        public static String getInvalidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "TaskFullControllerTaskCategories", "invalidCustomerCode");
        }

        public static String getBlankCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "TaskFullControllerTaskCategories", "blankCustomerCode");
        }

        public static String getSpecialCharCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "TaskFullControllerTaskCategories", "specialCharCustomerCode");
        }

        public static String getCustomerCodeWithSpaces() {
            return configReader.getConfigValue("getBaseVariableValue", "TaskFullControllerTaskCategories", "customerCodeWithSpaces");
        }

        // Fetch Logged User
        public static String getValidLoggedUser() {
            return configReader.getConfigValue("getBaseVariableValue", "TaskFullControllerTaskCategories", "validLoggedUser");
        }

        public static String getInvalidLoggedUser() {
            return configReader.getConfigValue("getBaseVariableValue", "TaskFullControllerTaskCategories", "invalidLoggedUser");
        }

        public static String getBlankLoggedUser() {
            return configReader.getConfigValue("getBaseVariableValue", "TaskFullControllerTaskCategories", "blankLoggedUser");
        }

        public static String getSpecialCharLoggedUser() {
            return configReader.getConfigValue("getBaseVariableValue", "TaskFullControllerTaskCategories", "specialCharLoggedUser");
        }

        public static String getLoggedUserWithSpaces() {
            return configReader.getConfigValue("getBaseVariableValue", "TaskFullControllerTaskCategories", "loggedUserWithSpaces");
        }

        // Fetch Response Time Threshold
        public static String getResponseTimeThreshold() {
            return configReader.getConfigValue("getBaseVariableValue", "TaskFullControllerTaskCategories", "responseTimeThreshold");
        }

        // Construct Task Categories URL (no customerCode and loggedUser in URL, these are in headers)
        public static String getTaskCategoriesUrl() {
            return Base_Url + "/v1/taskfull/task-categories";
        }
    }

    public static class DovControllerGets {

        // Fetch valid data
        public static String getValidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "DovControllerGets", "validCustomerCode");
        }

        public static String getValidDOV() {
            return configReader.getConfigValue("getBaseVariableValue", "DovControllerGets", "validDOV");
        }

        // Fetch missing data
        public static String getMissingCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "DovControllerGets", "missingCustomerCode");
        }

        public static String getMissingDOV() {
            return configReader.getConfigValue("getBaseVariableValue", "DovControllerGets", "missingDOV");
        }

        // Fetch invalid data
        public static String getInvalidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "DovControllerGets", "invalidCustomerCode");
        }

        public static String getInvalidDOV() {
            return configReader.getConfigValue("getBaseVariableValue", "DovControllerGets", "invalidDOV");
        }

        // Fetch special character data
        public static String getSpecialCharDOV() {
            return configReader.getConfigValue("getBaseVariableValue", "DovControllerGets", "specialCharDOV");
        }

        // Fetch blank data
        public static String getBlankCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "DovControllerGets", "blankCustomerCode");
        }

        public static String getBlankDOV() {
            return configReader.getConfigValue("getBaseVariableValue", "DovControllerGets", "blankDOV");
        }

        // Fetch data with spaces
        public static String getCustomerCodeWithSpaces() {
            return configReader.getConfigValue("getBaseVariableValue", "DovControllerGets", "customerCodeWithSpaces");
        }

        // Fetch response time threshold
        public static int getResponseTimeThreshold() {
            return Integer.parseInt(configReader.getConfigValue("getBaseVariableValue", "DovControllerGets", "responseTimeThreshold"));
        }

        // Construct API URL
        public static String getDovUrl(String dov) {
            // Agar dov null ya empty hai, toh placeholder use karo
            if (dov == null || dov.isEmpty()) {
                dov = "missingDOV";  // Ya koi aur default value
            }
            return Base_Url + "/v1/dovs/" + dov;
        }

    }

    public static class GetLeftmenuPermissionsTestData {

        // Fetch valid data
        public static String getValidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetLeftmenuPermissionsTestData", "validCustomerCode");
        }

        public static String getValidLoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetLeftmenuPermissionsTestData", "validLoggedUserId");
        }

        // Fetch invalid data
        public static String getInvalidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetLeftmenuPermissionsTestData", "invalidCustomerCode");
        }

        public static String getInvalidLoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetLeftmenuPermissionsTestData", "invalidLoggedUserId");
        }

        // Fetch blank data
        public static String getBlankCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetLeftmenuPermissionsTestData", "blankCustomerCode");
        }

        public static String getBlankLoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetLeftmenuPermissionsTestData", "blankLoggedUserId");
        }

        // Fetch special character data
        public static String getSpecialCharCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetLeftmenuPermissionsTestData", "specialCharCustomerCode");
        }

        public static String getSpecialCharLoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetLeftmenuPermissionsTestData", "specialCharLoggedUserId");
        }

        // Fetch blank space data
        public static String getBlankSpaceCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetLeftmenuPermissionsTestData", "blankSpaceCustomerCode");
        }

        public static String getBlankSpaceLoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetLeftmenuPermissionsTestData", "blankSpaceLoggedUserId");
        }

        // Fetch customer code with spaces
        public static String getCustomerCodeWithSpaces() {
            return configReader.getConfigValue("getBaseVariableValue", "GetLeftmenuPermissionsTestData", "customerCodeWithSpaces");
        }

        // Fetch logged user id with spaces
        public static String getLoggedUserIdWithSpaces() {
            return configReader.getConfigValue("getBaseVariableValue", "GetLeftmenuPermissionsTestData", "loggedUserIdWithSpaces");
        }

        // Fetch response time threshold
        public static int getResponseTimeThreshold() {
            return Integer.parseInt(configReader.getConfigValue("getBaseVariableValue", "GetLeftmenuPermissionsTestData", "responseTimeThreshold"));
        }

        public static String getLeftMenuPermissionsUrl() {
            return Base_Url + "/v1/permissions/left-menu";
        }

    }

    public static class PeopleListControllerGetSavedSearchesTestData {

        // Fetch valid data
        public static String getValidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "PeopleListControllerGetSavedSearchesTestData", "validCustomerCode");
        }

        public static String getValidId() {
            return configReader.getConfigValue("getBaseVariableValue", "PeopleListControllerGetSavedSearchesTestData", "validId");
        }

        // Fetch invalid data
        public static String getInvalidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "PeopleListControllerGetSavedSearchesTestData", "invalidCustomerCode");
        }

        public static String getInvalidId() {
            return configReader.getConfigValue("getBaseVariableValue", "PeopleListControllerGetSavedSearchesTestData", "invalidId");
        }

        // Fetch blank data
        public static String getBlankCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "PeopleListControllerGetSavedSearchesTestData", "blankCustomerCode");
        }

        public static String getBlankId() {
            return configReader.getConfigValue("getBaseVariableValue", "PeopleListControllerGetSavedSearchesTestData", "blankId");
        }

        // Fetch special character data
        public static String getSpecialCharCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "PeopleListControllerGetSavedSearchesTestData", "specialCharCustomerCode");
        }

        public static String getSpecialCharId() {
            return configReader.getConfigValue("getBaseVariableValue", "PeopleListControllerGetSavedSearchesTestData", "specialCharId");
        }

        // Fetch blank space data
        public static String getBlankSpaceCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "PeopleListControllerGetSavedSearchesTestData", "blankSpaceCustomerCode");
        }

        public static String getBlankSpaceId() {
            return configReader.getConfigValue("getBaseVariableValue", "PeopleListControllerGetSavedSearchesTestData", "blankSpaceId");
        }

        // Fetch customer code with spaces
        public static String getCustomerCodeWithSpaces() {
            return configReader.getConfigValue("getBaseVariableValue", "PeopleListControllerGetSavedSearchesTestData", "customerCodeWithSpaces");
        }

        // Fetch id with spaces
        public static String getIdWithSpaces() {
            return configReader.getConfigValue("getBaseVariableValue", "PeopleListControllerGetSavedSearchesTestData", "idWithSpaces");
        }

        // Fetch response time threshold
        public static int getResponseTimeThreshold() {
            return Integer.parseInt(configReader.getConfigValue("getBaseVariableValue", "PeopleListControllerGetSavedSearchesTestData", "responseTimeThreshold"));
        }

        // Get the URL for saved searches
        public static String getSavedSearchUrl(String id) {
            return Base_Url + "/v1/peoplelist/savedSearches?id=" + id; // URL with query parameter
        }

    }

    // Pankaj 22-Nov-2024 Move Controller endpoint ~ /api/v1/moves/{moveId}/details/employee
    public static class MoveControllerGetPeopleDetail {

        public static String get_valid_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "validMoveId");
        }

        public static String get_valid_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "validCustomerCode");
        }

        public static String get_valid_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "validLoggedUserId");
        }

        public static String get_invalid_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "invalidMoveId");
        }

        public static String get_invalid_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "invalidCustomerCode");
        }

        public static String get_invalid_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "invalidLoggedUserId");
        }

        public static String get_blank_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "blankSpaceMoveId");
        }

        public static String get_blank_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "blankSpaceCustomerCode");
        }

        public static String get_blank_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "blankLoggedUserId");
        }

        public static String get_specialChar_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "specialCharMoveId");
        }

        public static String get_specialChar_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "specialCharCustomerCode");
        }

        public static String get_specialChar_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "specialCharLoggedUserId");
        }

        public static String get_responseTimeThreshold() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "responseTimeThreshold");
        }

        // Construct Task Categories URL (no customerCode and loggedUser in URL, these are in headers)

        public static String get_Url(String moveId) {
            if (moveId == null) {
                // Handle the null case
                return Base_Url + "/v1/moves/details//personHeader";
            }
            return Base_Url + "/v1/moves/" + moveId + "/personHeader";
        }
    }

    // Pankaj 25-Nov-2024 Move Controller endpoint ~ /api/v1/moves/{moveId}/details/employee
    public static class MoveControllerGetDetailsForEmployeeInDetailsTab {

        public static String get_valid_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "validMoveId");
        }

        public static String get_valid_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "validCustomerCode");
        }

        public static String get_valid_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "validLoggedUserId");
        }

        public static String get_invalid_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "invalidMoveId");
        }

        public static String get_invalid_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "invalidCustomerCode");
        }

        public static String get_invalid_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "invalidLoggedUserId");
        }

        public static String get_blankSpace_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "blankSpaceMoveId");
        }

        public static String get_blank_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "blankSpaceCustomerCode");
        }

        public static String get_blank_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "blankLoggedUserId");
        }

        public static String get_specialChar_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "specialCharMoveId");
        }

        public static String get_specialChar_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "specialCharCustomerCode");
        }

        public static String get_specialChar_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "specialCharLoggedUserId");
        }

        public static String get_lang() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "lang");
        }

        // Fetch Response Time Threshold
        public static String get_responseTimeThreshold() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetPeopleDetail", "responseTimeThreshold");
        }

        // Construct Task Categories URL (no customerCode and loggedUser in URL, these are in headers)
        public static String get_Url(String moveId) {
            if (moveId == null) {
                // Handle the null case
                return Base_Url + "/v1/moves/details//employee";
            }
            return Base_Url + "/v1/moves/" + moveId + "/details/employee";
        }
    }

    //Implement by Atif
    public static class MoveControllerGetAllWorkflowsAndTasksV2TestData {

        public static String getValidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveController_GetAllWorkFlowsAndTasks_V2_TestData", "validCustomerCode");
        }

        public static String getValidMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveController_GetAllWorkFlowsAndTasks_V2_TestData", "validMoveId");
        }

        // Fetch invalid data
        public static String getInvalidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveController_GetAllWorkFlowsAndTasks_V2_TestData", "invalidCustomerCode");
        }

        public static String getInvalidMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveController_GetAllWorkFlowsAndTasks_V2_TestData", "invalidMoveId");
        }

        // Fetch non-existent data
        public static String getNonExistentMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveController_GetAllWorkFlowsAndTasks_V2_TestData", "nonExistentMoveId");
        }

        // Fetch blank data
        public static String getBlankCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveController_GetAllWorkFlowsAndTasks_V2_TestData", "blankCustomerCode");
        }

        public static String getBlankMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveController_GetAllWorkFlowsAndTasks_V2_TestData", "blankMoveId");
        }

        // Fetch special character data
        public static String getSpecialCharCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveController_GetAllWorkFlowsAndTasks_V2_TestData", "specialCharCustomerCode");
        }

        public static String getSpecialCharMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveController_GetAllWorkFlowsAndTasks_V2_TestData", "specialCharMoveId");
        }

        // Fetch blank space data
        public static String getBlankSpaceCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveController_GetAllWorkFlowsAndTasks_V2_TestData", "blankSpaceCustomerCode");
        }

        public static String getBlankSpaceMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveController_GetAllWorkFlowsAndTasks_V2_TestData", "blankSpaceMoveId");
        }

        // Fetch response time threshold
        public static int getResponseTimeThreshold() {
            return Integer.parseInt(configReader.getConfigValue("getBaseVariableValue", "MoveController_GetAllWorkFlowsAndTasks_V2_TestData", "responseTimeThreshold"));
        }

        // Get the URL for the workflows and tasks API
        public static String getWorkflowsAndTasksUrl(String moveId) {
            return Base_Url + "/v1/moves/api/v2/moves/" + moveId + "/tasks"; // Corrected URL with path parameter
        }
    }

    public static class EmployeeControllerGetTopiaPersonId {

        // Fetch valid data
        public static String getValidLoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "validLoggedUserId");
        }

        public static String getValidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "validCustomerCode");
        }

        public static String getValidTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "validTopiaPersonId");
        }

        // Fetch invalid data
        public static String getInvalidLoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "invalidLoggedUserId");
        }

        public static String getInvalidCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "invalidCustomerCode");
        }

        public static String getInvalidTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "invalidTopiaPersonId");
        }

        // Fetch blank data
        public static String getBlankLoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "blankLoggedUserId");
        }

        public static String getBlankCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "blankCustomerCode");
        }

        public static String getBlankTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "blankTopiaPersonId");
        }

        // Fetch special character data
        public static String getSpecialCharLoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "specialCharLoggedUserId");
        }

        public static String getSpecialCharCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "specialCharCustomerCode");
        }

        public static String getSpecialCharTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "specialCharTopiaPersonId");
        }

        // Fetch blank space data
        public static String getBlankSpaceLoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "blankSpaceLoggedUserId");
        }

        public static String getBlankSpaceCustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "blankSpaceCustomerCode");
        }

        public static String getBlankSpaceTopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "blankSpaceTopiaPersonId");
        }

        // Fetch TopiaPersonId less than 5 characters
        public static String getTopiaPersonIdLessThan5() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "topiaPersonIdLessThan5");
        }

        // Fetch TopiaPersonId more than 5 characters
        public static String getTopiaPersonIdMoreThan5() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "topiaPersonIdMoreThan5");
        }

        // Fetch response time threshold
        public static int getResponseTimeThreshold() {
            return Integer.parseInt(configReader.getConfigValue("getBaseVariableValue", "EmployeeControllerGetTopiaPersonId", "responseTimeThreshold"));
        }

        public static String getTopiaPersonIdUrl(String topiaPersonId) {
            return Base_Url + "/v1/employees/" + topiaPersonId; // Corrected URL with path parameter
        }
    }

    public static class EmployeeFeedbackGetSatisfactionScoreByMoveTestData {

        // Fetch valid data
        public static String getValidMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeFeedback_getSatisfactionScoreByMove_TestData", "validMoveId");
        }

        // Fetch missing data
        public static String getMissingMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeFeedback_getSatisfactionScoreByMove_TestData", "missingMoveId");
        }

        // Fetch special character data
        public static String getSpecialCharacterMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeFeedback_getSatisfactionScoreByMove_TestData", "specialCharacterMoveId");
        }

        // Fetch alphanumeric data
        public static String getAlphanumericMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeFeedback_getSatisfactionScoreByMove_TestData", "alphanumericMoveId");
        }

        // Fetch letters only data
        public static String getLettersOnlyMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeFeedback_getSatisfactionScoreByMove_TestData", "lettersOnlyMoveId");
        }

        // Fetch short move ID data
        public static String getShortMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeFeedback_getSatisfactionScoreByMove_TestData", "shortMoveId");
        }

        // Fetch long move ID data
        public static String getLongMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeFeedback_getSatisfactionScoreByMove_TestData", "longMoveId");
        }

        // Fetch blank spaces move ID data
        public static String getBlankSpacesMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeFeedback_getSatisfactionScoreByMove_TestData", "blankSpacesMoveId");
        }

        // Fetch invalid move ID data
        public static String getInvalidMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeFeedback_getSatisfactionScoreByMove_TestData", "invalidMoveId");
        }

        // Fetch SQL injection data
        public static String getSqlInjectionMoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "EmployeeFeedback_getSatisfactionScoreByMove_TestData", "sqlInjectionMoveId");
        }

        public static int getResponseTimeThreshold() {
            return Integer.parseInt(configReader.getConfigValue("getBaseVariableValue", "EmployeeFeedback_getSatisfactionScoreByMove_TestData", "responseTimeThreshold"));
        }

        public static String getSatisfactionScoreByMoveUrl(String moveId) {
            // Check if moveId is null; if so, return the URL without the moveId
            if (moveId != null && !moveId.isEmpty()) {
                return Base_Url + "/v1/moves/" + moveId + "/satisfaction-score";  // Valid moveId case
            } else {
                return Base_Url + "/v1/moves/satisfaction-score";  // Default URL if moveId is null or empty
            }
        }

    }

    // Pankaj 26-Nov-2024 Move Controller endpoint ~ /api/v1/moves/{moveId}/header
    public static class MoveControllerGetMoveHeaderInfo {

        public static String get_valid_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "validMoveId");
        }

        public static String get_valid_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "validCustomerCode");
        }

        public static String get_valid_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "validLoggedUserId");
        }

        public static String get_invalid_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "invalidMoveId");
        }

        public static String get_invalid_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "invalidCustomerCode");
        }

        public static String get_invalid_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "invalidLoggedUserId");
        }

        public static String get_maxlength_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "maxLenghtMoveId");
        }

        public static String get_maxlength_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "maxLenghtCustomerCode");
        }

        public static String get_maxlength_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "maxLenghtLoggedUserId");
        }

        public static String get_blank_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "blankSpaceMoveId");
        }

        public static String get_blank_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "blankSpaceCustomerCode");
        }

        public static String get_blank_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "blankLoggedUserId");
        }

        public static String get_specialChar_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "specialCharMoveId");
        }

        public static String get_specialChar_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "specialCharCustomerCode");
        }

        public static String get_specialChar_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "specialCharLoggedUserId");
        }

        public static String get_responseTimeThreshold() {
            return configReader.getConfigValue("getBaseVariableValue", "MoveControllerGetMoveHeaderInfo", "responseTimeThreshold");
        }

        public static String get_Url(String moveId) {
            if (moveId == null) {
                // Handle the null case
                return Base_Url + "/v1/moves//header";
            }
            return Base_Url + "/v1/moves/" + moveId + "/header";
        }
    }

    // Pankaj 27-Nov-2024 Assignment Controller endpoint ~ /api/v1/assignments/{id}
    public static class AssigmentControllerGetSingleAssignment {

        public static String get_valid_Id() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "valid_Id");
        }

        public static String get_valid_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "valid_CustomerCode");
        }

        public static String get_valid_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "valid_LoggedUserId");
        }

        public static String get_invalid_Id() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "invalid_Id");
        }

        public static String get_invalid_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "invalid_CustomerCode");
        }

        public static String get_invalid_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "invalid_LoggedUserId");
        }

        public static String get_maxlength_Id() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "maxLenght_Id");
        }

        public static String get_maxlength_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "maxLenght_CustomerCode");
        }

        public static String get_maxlength_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "maxLenght_LoggedUserId");
        }

        public static String get_minlength_Id() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "minLenght_Id");
        }

        public static String get_minlength_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "minLenght_CustomerCode");
        }

        public static String get_minlength_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "minLenght_LoggedUserId");
        }

        public static String get_blank_Id() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "blankSpace_Id");
        }

        public static String get_blank_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "blankSpace_CustomerCode");
        }

        public static String get_blank_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "blankLogged_UserId");
        }

        public static String get_specialChar_Id() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "specialChar_Id");
        }

        public static String get_specialChar_CustomerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "specialChar_CustomerCode");
        }

        public static String get_specialChar_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "specialChar_LoggedUserId");
        }

        public static String get_responseTimeThreshold() {
            return configReader.getConfigValue("getBaseVariableValue", "AssigmentControllerGetSingleAssignment", "responseTimeThreshold");
        }

        public static String get_Url(String Id) {
            if (Id == null) {
                // Handle the null case/api/v1/assignments/{id}
                return Base_Url + "/v1/assignments/";
            }
            return Base_Url + "/v1/assignments/" + Id;
        }
    }

    // Pankaj 28-Nov-2024 BusinessDocuments Controller endpoint ~ /api/v1/assignments/{assignmentId}/businessdocuments
    public static class BusinessDocumentsControllerGetBusinessDocuments {

        public static String get_valid_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "valid_AssignmentId");
        }

        public static String get_valid_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "valid_LoggedUserId");
        }

        public static String get_invalid_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "invalid_AssignmentId");
        }

        public static String get_invalid_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "invalid_LoggedUserId");
        }

        public static String get_maxlength_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "maxLenght_AssignmentId");
        }

        public static String get_maxlength_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "maxLenght_LoggedUserId");
        }

        public static String get_minlength_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "minLenght_AssignmentId");
        }

        public static String get_minlength_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "minLenght_LoggedUserId");
        }

        public static String get_blank_Id() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "blankSpace_Id");
        }

        public static String get_blank_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "blankLogged_UserId");
        }

        public static String get_specialChar_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "specialChar_AssignmentId");
        }

        public static String get_specialChar_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "specialChar_LoggedUserId");
        }

        public static String get_alphanumeric_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "alphaNumeric_AssignmentId");
        }

        public static String get_alphanumeric_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "alphaNumeric_LoggedUserId");
        }

        public static String get_sqlInjection_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "sqlInjection_AssignmentId");
        }

        public static String get_sqlInjection_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "sqlInjection_LoggedUserId");
        }

        public static String get_responseTimeThreshold() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetBusinessDocuments", "responseTimeThreshold");
        }

        public static String get_Url(String AssignmentId) {
            if (AssignmentId == null) {
                // Handle the null case/api/v1/assignments/{id}
                return Base_Url + "/v1/assignments//businessdocuments";
            }
            return Base_Url + "/v1/assignments/" + AssignmentId + "/businessdocuments";
        }
    }

    // Pankaj 02-Dec-2024 transaction-controller endpoint ~ /api/v1/transactions/assignments/{assignmentId}/totals
    public static class TransactionControllerGetAssignmentTotals {

        public static String get_valid_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "valid_AssignmentId");
        }

        public static String get_valid_currencyCode() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "valid_currencyCode");
        }

        public static String get_invalid_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "invalid_AssignmentId");
        }

        public static String get_nonDeafult_currencyCode() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "nonDefault_currencyCode");
        }

        public static String get_maxlength_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "maxLenght_AssignmentId");
        }

        public static String get_maxlength_currencyCode() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "maxLenght_currencyCode");
        }

        public static String get_minlength_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "minLenght_AssignmentId");
        }

        public static String get_minlength_currencyCode() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "minLenght_currencyCode");
        }

        public static String get_blank_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "blankSpace_AssignmentId");
        }

        public static String get_blank_currencyCode() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "blankSpace_currencyCode");
        }

        public static String get_specialChar_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "specialChar_AssignmentId");
        }

        public static String get_specialChar_currencyCode() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "specialChar_currencyCode");
        }

        public static String get_alphanumeric_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "alphaNumeric_AssignmentId");
        }

        public static String get_numeric_currencyCode() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "Numeric_currencyCode");
        }

        public static String get_sqlInjection_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "sqlInjection_AssignmentId");
        }

        public static String get_sqlInjection_currencyCode() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionControllerGetAssignmentTotals", "sqlInjection_currencyCode");
        }

        public static String get_responseTimeThreshold() {
            return configReader.getConfigValue("getBaseVariableValue", "TransactionDocumentsControllerGetAssignmentTotals", "responseTimeThreshold");
        }

        public static String get_Url(String AssignmentId) {
            if (AssignmentId == null) {
                // Handle the null case/api/v1/assignments/{id}
                return Base_Url + "v1/transactions/assignments//totals";
            }
            return Base_Url + "/v1/transactions/assignments/" + AssignmentId + "/totals";
        }
    }

    //Deeksha businessdocumentcode  and endpoint - "/api/v1/assignments/{assignmentId}/businessdocuments/code/{businessDocumentCode}"
    public static class BusinessDocumentsControllerGetAssignmentBizdocByPropertyName {
        public static String get_valid_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "valid_AssignmentId");
        }

        public static String get_valid_businessDocumentCode() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "valid_businessDocumentCode");
        }

        public static String get_valid_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "valid_logged_user_id");
        }

        public static String get_valid_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "valid_customerCode");
        }

        public static String get_invalid_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "invalid_AssignmentId");
        }

        public static String get_invalid_businessDocumentCode() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "invalid_businessDocumentCode");
        }

        public static String get_invalid_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "invalid_logged_user_id");
        }

        public static String get_invalid_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "invalid_customerCode");
        }

        public static String get_maxlength_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "maxlength_AssignmentId");
        }

        public static String get_maxlength_businessDocumentCode() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "maxlength_businessDocumentCode");
        }

        public static String get_maxlength_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "maxlength_logged_user_id");
        }

        public static String get_maxlength_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "maxlength_customerCode");
        }

        public static String get_minlength_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "minlength_AssignmentId");
        }

        public static String get_minlength_businessDocumentCode() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "minlength_businessDocumentCode");
        }

        public static String get_minlength_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "minlength_logged_user_id");
        }

        public static String get_minlength_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "minlength_customerCode");
        }

        public static String get_specialChar_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "specialChar_AssignmentId");
        }

        public static String get_specialChar_businessDocumentCode() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "specialChar_businessDocumentCode");
        }

        public static String get_specialChar_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "specialChar_logged_user_id");
        }

        public static String get_specialChar_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "specialChar_customerCode");
        }

        public static String get_sqlInjection_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "sqlInjection_AssignmentId");
        }

        public static String get_sqlInjection_businessDocumentCode() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "sqlInjection_businessDocumentCode");
        }

        public static String get_sqlInjection_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "sqlInjection_logged_user_id");
        }

        public static String get_sqlInjection_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "sqlInjection_customerCode");
        }

        public static String get_alphaNumeric_AssignmentId() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "alphaNumeric_AssignmentId");
        }

        public static String get_alphaNumeric_businessDocumentCode() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "alphaNumeric_businessDocumentCode");
        }

        public static String get_alphaNumeric_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "alphaNumeric_logged_user_id");
        }

        public static String get_alphaNumeric_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "alphaNumeric_customerCode");
        }

        public static String get_lang() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "lang");
        }


        public static String get_responseTimeThreshold() {
            return configReader.getConfigValue("getBaseVariableValue", "BusinessDocumentsControllerGetAssignmentBizdocByPropertyName", "responseTimeThreshold");
        }

        public static String get_Url(String AssignmentId, String BusinessDocumentCode) {
            if (AssignmentId == null) {

                return Base_Url + "/v1/assignments//businessdocuments/code/" + BusinessDocumentCode;
            } else if (BusinessDocumentCode == null) {

                return Base_Url + "/v1/assignments/" + AssignmentId + "/businessdocuments/code/";
            }
            return Base_Url + "/v1/assignments/" + AssignmentId + "/businessdocuments/code/" + BusinessDocumentCode;
        }
    }

    //  @ Deeksha Policychange and endpoint - "/api/v1/policy-changes/move-id/{moveId}"
    public static class GetExplores {
        public static String get_valid_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "valid_MoveId");
        }

        public static String get_valid_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "valid_customerCode");
        }

        public static String get_invalid_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "invalid_MoveId");
        }

        public static String get_invalid_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "invalid_customerCode");
        }

        public static String get_maxlength_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "maxlength_MoveId");
        }

        public static String get_maxlength_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "maxlength_customerCode");
        }

        public static String get_minlength_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "minlength_MoveId");
        }

        public static String get_minlength_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "minlength_customerCode");
        }

        public static String get_specialChar_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "specialChar_MoveId");
        }

        public static String get_specialChar_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "specialChar_customerCode");
        }

        public static String get_alphaNumeric_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "alphaNumeric_MoveId");
        }

        public static String get_alphaNumeric_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "alphaNumeric_customerCode");
        }

        public static String get_sqlInjection_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "sqlInjection_MoveId");
        }

        public static String get_sqlInjection_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "sqlInjection_customerCode");
        }

        public static String get_responseTimeThreshold() {
            return configReader.getConfigValue("getBaseVariableValue", "GetExplores", "responseTimeThreshold");
        }

        public static String get_Url(String MoveId) {
            if (MoveId == null) {

                return Base_Url + "/v1/policy-changes/move-id/";
            }
            return Base_Url + "/v1/policy-changes/move-id/" + MoveId;
        }

    }

    //atif
    public static class UserControllerGetMoveScreenFeaturePermissionsTestData {
        public static String getResponseTimeThreshold() {
            return configReader.getConfigValue("getBaseVariableValue", "UserController_getMoveScreenFeaturePermissions_TestData", "responseTimeThreshold");
        }

        public static String getMovePermissionsUrl() {
            return Base_Url + "/v1/users/permissions/move";
        }// Replace with actual base URL concatenation logic

    }

    //@ Deeksha permission assigment and endpoint - "/api/v1/permissions/assignment"
    public static class GetAssignmentScreenFeaturePermissions {
        public static String get_valid_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "valid_logged_user_id");
        }

        public static String get_valid_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "valid_customerCode");
        }

        public static String get_invalid_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "invalid_logged_user_id");
        }

        public static String get_invalid_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "invalid_customerCode");
        }

        public static String get_maxlength_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "maxlength_logged_user_id");
        }

        public static String get_maxlength_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "maxlength_customerCode");
        }

        public static String get_minlength_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "minlength_logged_user_id");
        }

        public static String get_minlength_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "minlength_customerCode");
        }

        public static String get_specialChar_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "specialChar_logged_user_id");
        }

        public static String get_specialChar_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "specialChar_customerCode");
        }

        public static String get_alphaNumeric_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "alphaNumeric_logged_user_id");
        }

        public static String get_alphaNumeric_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "alphaNumeric_customerCode");
        }

        public static String get_sqlInjection_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "sqlInjection_logged_user_id");
        }

        public static String get_sqlInjection_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "sqlInjection_customerCode");
        }

        public static String get_responseTimeThreshold() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "responseTimeThreshold");
        }

        public static String get_benefitCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "benefitCode");
        }

        public static String get_moveStage() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignmentScreenFeaturePermissions", "moveStage");
        }

        public static String get_Url() {
            return Base_Url + "/v1/permissions/assignment";
        }
    }

    //@ Deeksha costEstimateversion  and endpoint - "api/v1/cost-estimate/move/{moveId}/versions"
    public static class GetCostEstimateVersionsAsync {
        public static String get_valid_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateVersionsAsync", "valid_MoveId");
        }

        public static String get_valid_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateVersionsAsync", "valid_customerCode");
        }

        public static String get_valid_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateVersionsAsync", "valid_logged_user_id");
        }

        public static String get_invalid_MoveId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateVersionsAsync", "invalid_MoveId");
        }

        public static String get_invalid_customerCode() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateVersionsAsync", "invalid_customerCode");
        }

        public static String get_invalid_logged_user_id() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateVersionsAsync", "invalid_logged_user_id");
        }

        public static String get_responseTimeThreshold() {
            return configReader.getConfigValue("getBaseVariableValue", "GetCostEstimateVersionsAsync", "responseTimeThreshold");
        }

        public static String get_Url(String MoveId) {
            if (MoveId == null) {

                return Base_Url + "v1/cost-estimate/move/{moveId}/versions";
            }
            {
                return Base_Url + "v1/cost-estimate/move/versions" + MoveId;
            }
        }

    }

    //Deeksha - people controller get assigments and endpoint - "/api/v1/people/{topiaPersonId}/moves"

    public static class GetAssignments {
        public static String get_valid_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignments", "valid_LoggedUserId");
        }

        public static String get_valid_TopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignments", "valid_TopiaPersonId");
        }

        public static String get_invalid_LoggedUserId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignments", "invalid_LoggedUserId");
        }

        public static String get_invalid_TopiaPersonId() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignments", "invalid_TopiaPersonId");
        }

        public static String get_responseTimeThreshold() {
            return configReader.getConfigValue("getBaseVariableValue", "GetAssignments", "responseTimeThreshold");
        }

        public static String get_Url(String TopiaPersonId) {
            if (TopiaPersonId == null) {
                return Base_Url + "v1/people/{topiaPersonId}/moves";
            }
            {
                return Base_Url + "v1/people/" + TopiaPersonId + "/moves";
            }
        }
    }

}


