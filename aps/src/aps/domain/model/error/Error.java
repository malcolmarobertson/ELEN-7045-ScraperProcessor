package aps.domain.model.error;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

//TODO: Handle date and time portions seperately in the xml string.
//TODO: Handle xml unmarshalling using generic to re-use the ScrapeObject unmarshalling class.
@XmlRootElement(name = "scrape-session")
@XmlAccessorType(XmlAccessType.FIELD)
public class Error {

    @XmlElement
    private String scrapeErrorCode;

    @XmlElement(name = "base-url")
    private String baseUrl;

    @XmlElement
    private String date;

    @XmlElement
    private String time;

    private String description;

    private String billingCompanyName;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBillingCompanyName() {
        return billingCompanyName;
    }

    public void setBillingCompanyName(String billingCompanyName) {
        this.billingCompanyName = billingCompanyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Error that = (Error) o;
        return scrapeErrorCode == that.scrapeErrorCode &&
                Objects.equals(description, that.description) &&
                Objects.equals(time, that.time) &&
                Objects.equals(baseUrl, that.baseUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(scrapeErrorCode, description, time, baseUrl);
    }
}
