package aps.domain.model.scraperror;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;

//TODO: Handle date and time portions seperately in the xml string.
//TODO: Handle xml unmarshalling using generic to re-use the ScrapeObject unmarshalling class.
@XmlRootElement(name = "scrape-session")
@XmlAccessorType(XmlAccessType.FIELD)
public class ScrapeError {

    @XmlElement
    private String scrapeErrorCode;

    @XmlElement(name = "base-url")
    private String websiteBaseUrl;

    private String description;
    private Date timeOccured;


    public String getScrapeErrorCode() {
        return scrapeErrorCode;
    }

    public void setScrapeErrorCode(String scrapeErrorCode) {
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
