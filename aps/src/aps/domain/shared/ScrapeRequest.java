package aps.domain.shared;

import java.io.Serializable;

/**
 * Request Object sent to the Scrap component of the system. Contains the Website URL and Identification and Authentification
 * credentials.
 */
public class ScrapeRequest implements Serializable {

    private String websiteUrl;
    private String userIdentification;
    private String passCode;

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
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
}
