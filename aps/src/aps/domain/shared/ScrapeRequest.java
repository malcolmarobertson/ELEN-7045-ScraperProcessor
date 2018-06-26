package aps.domain.shared;

import java.io.Serializable;

/**
 * Request Object sent to the Scrap component of the system. Contains the Website URL and Identification and Authentification
 * credentials.
 */
public class ScrapeRequest implements Serializable {

    private String baseUrl;
    private String userIdentification;
    private String passCode;
    private String accountNumber;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUserIdentification() {
        return userIdentification;
    }

    public void setUserIdentification(String userIdentification) {
        this.userIdentification = userIdentification;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
