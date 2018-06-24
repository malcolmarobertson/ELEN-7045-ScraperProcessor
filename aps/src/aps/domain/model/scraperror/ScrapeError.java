package aps.domain.model.scraperror;

import java.util.Date;
import java.util.Objects;

public class ScrapeError {
    private ScrapeErrorCode scrapeErrorCode;
    private String description;
    private Date timeOccured;
    private String websiteBaseUrl;

    public ScrapeErrorCode getScrapeErrorCode() {
        return scrapeErrorCode;
    }

    public void setScrapeErrorCode(ScrapeErrorCode scrapeErrorCode) {
        this.scrapeErrorCode = scrapeErrorCode;
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
        ScrapeError that = (ScrapeError) o;
        return scrapeErrorCode == that.scrapeErrorCode &&
                Objects.equals(description, that.description) &&
                Objects.equals(timeOccured, that.timeOccured) &&
                Objects.equals(websiteBaseUrl, that.websiteBaseUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(scrapeErrorCode, description, timeOccured, websiteBaseUrl);
    }
}
