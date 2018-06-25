package aps.application.impl;

import aps.application.util.XmlFileReader;
import aps.domain.shared.ScrapeRequest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScrapServiceImplTest {
    ScrapServiceImpl toTest;
    ScrapeRequest scrapeRequestFailure;
    ScrapeRequest scrapeRequestSuccess;

    @Before
    public void init() {
        toTest = new ScrapServiceImpl();
        scrapeRequestFailure = buildScrapRequestFailure();
        scrapeRequestSuccess = buildScrapRequestSuccess();
    }

    @Ignore
    @Test
    public void scrapWebsite() {
        assertEquals("www.telkom.co.za", toTest.scrapWebsite(buildScrapRequestFailure()));
        assertEquals("Account no", toTest.getScrapResponse(buildScrapRequestSuccess()));
    }

    @Test
    public void getScrapResponse() {
    }

    private String readSampleScrapeResponse() {
//        return XmlFileReader.readFile("/scrape/telkom-scrape.xml");
        return null;
    }

    private ScrapeRequest buildScrapRequestFailure() {
        ScrapeRequest scrapeRequest = new ScrapeRequest();
        scrapeRequest.setUserIdentification("test_failure_user");
        scrapeRequest.setPassCode("test_passcode");
        scrapeRequest.setWebsiteUrl("www.scrape-test.com");
        return scrapeRequest;
    }

    private ScrapeRequest buildScrapRequestSuccess() {
        ScrapeRequest scrapeRequest = new ScrapeRequest();
        scrapeRequest.setUserIdentification("test_success_user");
        scrapeRequest.setPassCode("test_passcode");
        scrapeRequest.setWebsiteUrl("www.scrape-test.com");
        return scrapeRequest;
    }

    @Test
    public void handleScrapeError() {

    }
}
