package aps.application.impl;

import aps.application.util.ScrapeResult;
import aps.domain.shared.ScrapeRequest;
import aps.domain.shared.ScrapeResponse;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
//        assertEquals("www.telkom.co.za", toTest.scrapWebsite(buildScrapRequestFailure()).getBaseUrl());
        assertEquals("Account no", toTest.getScrapResponse(buildScrapRequestSuccess()).getXmlResponse());
    }

    @Test
    public void getScrapResponse() {
    }

    @Test
    public void shouldReturnScrapeSuccessfulResponse() {
        //given
        toTest = new ScrapServiceImpl();
        ScrapeRequest scrapeRequest = buildScrapRequestSuccess();
        //when
        ScrapeResponse scrapResponse = toTest.getScrapResponse(scrapeRequest);
        //then
        assertEquals(scrapResponse.getScrapeResult(), ScrapeResult.SUCCESSFUL);
    }

    @Test
    public void shouldReturnScrapeFailedResponse() {
        //given
        toTest = new ScrapServiceImpl();
        ScrapeRequest scrapeRequest = buildScrapRequestFailure();
                //when
        ScrapeResponse scrapResponse = toTest.getScrapResponse(scrapeRequest);
        //then
        assertEquals(scrapResponse.getScrapeResult(), ScrapeResult.FAILED);
    }

    private String readSampleScrapeResponse() {
//        return XmlFileReader.readFile("/scrape/telkom-scrape.xml");
        return null;
    }

    private ScrapeRequest buildScrapRequestFailure() {
        ScrapeRequest scrapeRequest = new ScrapeRequest();
        scrapeRequest.setUserIdentification("test_failure_user");
        scrapeRequest.setPassCode("test_passcode");
        scrapeRequest.setBaseUrl("www.failure-scrape-test.com");
        return scrapeRequest;
    }

    private ScrapeRequest buildScrapRequestSuccess() {
        ScrapeRequest scrapeRequest = new ScrapeRequest();
        scrapeRequest.setUserIdentification("test_success_user");
        scrapeRequest.setPassCode("test_passcode");
        scrapeRequest.setBaseUrl("www.success-scrape-test.com");
        return scrapeRequest;
    }

    @Test
    public void handleScrapeError() {

    }
}
