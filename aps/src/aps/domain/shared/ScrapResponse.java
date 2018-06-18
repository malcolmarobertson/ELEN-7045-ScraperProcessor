package aps.domain.shared;

import java.io.Serializable;

/**
 * Response object returned by the Scrap Component of the system containing the scrap xml file or error response.
 */
public class ScrapResponse implements Serializable {
    //TODO: To refactor object to contain correct variables.
    //TODO: Should ErrorCode be changed to generic ResponseCode which encompases both success and failure scenarios?
    private String xmlResponse;
    private String ErrorCode;

    public String getXmlResponse() {
        return xmlResponse;
    }

    public void setXmlResponse(String xmlResponse) {
        this.xmlResponse = xmlResponse;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }
}
