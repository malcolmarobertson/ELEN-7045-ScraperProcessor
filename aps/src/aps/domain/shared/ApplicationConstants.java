package aps.domain.shared;

public class ApplicationConstants {

    /**
     * Constants for Customer Account Status
     */
    public static final String ACTIVE = "ACTIVE";
    public static final String INACTIVE = "INACTIVE";
    public static final String TRYING = "TRYING";

    /**
     * Sample Scrape Response xml file paths
     */
    public static final String VALID_TELKOM_SCRAPE_FILE = "src/resources/scrape/telkom-scrape.xml";
    public static final String INVALID_CITY_OF_JOBURG_SCRAPE_FILE = "src/resources/scrape-error/joburg-scrape-error.xml";
    public static final String INVALID_EDGARS_SCRAPE_FILE = "src/resources/scrape-error/edgars-scrape-error.xml";
    public static final String SCRAPE_ERROR_FILE_BASE_PATH = "src/resources/scrape-error/";
    public static final String BILLING_COMPANY_FILE_BASE_PATH = "src/resources/billingcompany/";
    public static final String SCRAPE_FILE_BASE_PATH = "src/resources/scrape/";
    public static final String CUSTOMER_FILE_BASE_PATH = "src/resources/customer/";
    public static final String STATEMENT_FILE_BASE_PATH = "src/resources/statement/";
    public static final String XML_EXTENSION = ".xml";

    /**
     * Scrape Error messages returned back to the user.
     */
    public static final String INVALID_CREDENTIALS = "Invalid Credentials! Please update credentials before attempting to scrape again.";
    public static final String CUSTOMER_ACTION_REQUIRED = "Action Required by User! Please agree to the new Ts & Cs before attempting to scrape again.";
    public static final String BROKEN_SCRIPT = "Error occured! Please contact the Technical Team for support.";
    public static final String ERROR_PAGE = "Currently experience high volumes. Please try again later";
    public static final String NOT_SIGNED_FOR_EBILLING = "Not signed up for e-Billing! Please complete the signup process before the scrape is attempted again";
    public static final String DATA_INTEGRITY = "Error occured! Please contact the Technical Team for support.";
    public static final String DATA_INTEGRITY_CONSISTENCY = "Inconsistent data retrieved! Please contact the Technical Team for support";
    public static final String INCORRECT_ACCOUNT = "An incorrect Account Number was entered! Please enter the correct account number before attempting to scrape again.";
    public static final String SITE_DOWN = "The site is down for maintenance until 22h00 ETA. Please wait until service is restored before attempting to scrape again";

    /**
     * Scrape successful response
     */
    public static final String SCRAP_SUCCESSFUL = "Scraping completed successfully for url: ";

    /**
     * Password Encryption Salt and Key
     */
    public static final String SALT = "5b3241141d41bf84e7ed3e14";
    public static final String KEY = "5b3241141d41bf84e7ed3e14";

}
