package aps.domain.shared;

import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.scraperror.ScrapeError;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Test class for the GenericXmlParser Class.
 */
public class GenericXmlParserTest {

    GenericXmlParser toTestScrapeObject;
    GenericXmlParser toTestScrapeError;

    @Before
    public void init() {
        toTestScrapeObject = new GenericXmlParser(ScrapeObject.class);
        toTestScrapeError = new GenericXmlParser(ScrapeError.class);
    }

    @org.junit.Test
    public void parseScrapXml() {
        assertEquals("www.telkom.co.za", ((ScrapeObject) toTestScrapeObject.parseScrapXml(getSampleXmlResponse())).getBaseUrl());
        assertEquals("Account no", ((ScrapeObject) toTestScrapeObject.parseScrapXml(getSampleXmlResponse())).getDataPairs().get(0).getText());
        assertEquals("www.telkom.co.za", ((ScrapeError) toTestScrapeError.parseScrapXml(getSampleErrorXmlResponse())).getWebsiteBaseUrl());
        assertEquals("INVALID_CREDENTIALS", ((ScrapeError) toTestScrapeError.parseScrapXml(getSampleErrorXmlResponse())).getScrapeErrorCode());
    }

    private String getSampleXmlResponse() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<scrape-session>\n" +
                "    <base-url>www.telkom.co.za</base-url>\n" +
                "    <date>10/01/2008</date>\n" +
                "    <time>13:50:00</time>\n" +
                "    <datapairs>\n" +
                "        <datapair id=\"001\">\n" +
                "            <text>Account no</text>\n" +
                "            <value>53844946068883</value>\n" +
                "        </datapair>\n" +
                "        <datapair id=\"002\">\n" +
                "            <text>Service ref</text>\n" +
                "            <value>0117838898</value>\n" +
                "        </datapair>\n" +
                "        <datapair id=\"003\">\n" +
                "            <text>Previous Invoice</text>\n" +
                "            <value>R512.22</value>\n" +
                "        </datapair>\n" +
                "        <datapair id=\"004\">\n" +
                "            <text>Payment</text>\n" +
                "            <value>R513.00</value>\n" +
                "        </datapair>\n" +
                "        <datapair id=\"005\">\n" +
                "            <text>Opening Balance</text>\n" +
                "            <value>R0.78</value>\n" +
                "        </datapair>\n" +
                "    </datapairs>\n" +
                "</scrape-session>";
    }

    private String getSampleErrorXmlResponse() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<scrape-session>\n" +
                "    <base-url>www.telkom.co.za</base-url>\n" +
                "    <date>10/01/2008</date>\n" +
                "    <time>13:50:00</time>\n" +
                "    <scrapeErrorCode>INVALID_CREDENTIALS</scrapeErrorCode>\n" +
                "</scrape-session>";
    }

}