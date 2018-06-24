package aps.domain.shared;

import aps.application.util.ScrapeResult;

import java.io.Serializable;

/**
 * Response object returned by the Scrap Component of the system containing the scrap xml file or error response.
 */
public class ScrapeResponse implements Serializable {
    private String xmlResponse;
    private ScrapeResult scrapeResult;

    public String getXmlResponse() {
        return xmlResponse;
    }

    public void setXmlResponse(String xmlResponse) {
        this.xmlResponse = xmlResponse;
    }

    public ScrapeResult getScrapeResult() {
        return scrapeResult;
    }

    public void setScrapeResult(ScrapeResult scrapeResult) {
        this.scrapeResult = scrapeResult;
    }
}
