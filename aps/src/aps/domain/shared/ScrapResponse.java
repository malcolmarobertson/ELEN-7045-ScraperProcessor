package aps.domain.shared;

import java.io.Serializable;

/**
 * Response object returned by the Scrap Component of the system containing the scrap xml file or error response.
 */
public class ScrapResponse implements Serializable {
    //TODO: To refactor object to contain correct variables.
    //TODO: Should ErrorCode be changed to generic ResponseCode which encompases both success and failure scenarios?
    private String xmlResponse;
    private String srapeResult;

    public String getXmlResponse() {
        return xmlResponse;
    }

    public void setXmlResponse(String xmlResponse) {
        this.xmlResponse = xmlResponse;
    }

    public String getSrapeResult() {
        return srapeResult;
    }

    public void setSrapeResult(String srapeResult) {
        this.srapeResult = srapeResult;
    }
}
