package aps.domain.model.scraperror;

import java.util.Date;
import java.util.Objects;

public class ScrapError {
    private ScrapErrorType scrapErrorTypeCode;
    private String description;
    private Date timeOccured;
    private String websiteBaseUrl;

    public ScrapErrorType getScrapErrorTypeCode() {
        return scrapErrorTypeCode;
    }

    public void setScrapErrorTypeCode(ScrapErrorType scrapErrorTypeCode) {
        this.scrapErrorTypeCode = scrapErrorTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimeOccured() {
        return timeOccured;
    }

    public void setTimeOccured(Date timeOccured) {
        this.timeOccured = timeOccured;
    }

    public String getWebsiteBaseUrl() {
        return websiteBaseUrl;
    }

    public void setWebsiteBaseUrl(String websiteBaseUrl) {
        this.websiteBaseUrl = websiteBaseUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrapError that = (ScrapError) o;
        return scrapErrorTypeCode == that.scrapErrorTypeCode &&
                Objects.equals(description, that.description) &&
                Objects.equals(timeOccured, that.timeOccured) &&
                Objects.equals(websiteBaseUrl, that.websiteBaseUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(scrapErrorTypeCode, description, timeOccured, websiteBaseUrl);
    }
}
