package aps.domain.shared;

import aps.domain.model.scrape.ScrapeObject;
import org.junit.Before;

import static org.junit.Assert.*;

public class XmlParseHelperTest {

    XmlParseHelper toTest;
    ScrapeObject scrapeObject;

    @Before
    public void init() {
        toTest = new XmlParseHelper();
        scrapeObject = buildScrapSession();
    }

    private ScrapeObject buildScrapSession() {
        ScrapeObject scrapeObject = new ScrapeObject();
        return null;
    }

    @org.junit.Test
    public void parseScrapXml() {
        assertEquals("www.telkom.co.za", toTest.parseScrapXml(getSampleXmlResponse()).getBaseUrl());
        assertEquals("Account no", toTest.parseScrapXml(getSampleXmlResponse()).getDataPairs().get(0).getText());
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
}