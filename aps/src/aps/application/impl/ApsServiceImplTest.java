package aps.application.impl;

import aps.application.IApsService;
import aps.application.IScrapService;
import aps.application.util.ScrapeResult;
import aps.domain.model.customer.Customer;
import aps.domain.shared.ScrapeRequest;
import aps.domain.shared.ScrapeResponse;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import static aps.domain.shared.ApplicationConstants.SCRAP_SUCCESSFUL;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class ApsServiceImplTest {

    @Mock
    IScrapService scrapService;

    @Test
    public void getCustomer() {
    }

    @Ignore
    @Test
    public void shouldReturnSuccessfulResponse() {
        //given
        IApsService apsService = new ApsServiceImpl();
        Customer customer = new Customer();
        ScrapeRequest scrapeRequest = new ScrapeRequest();
        ScrapeResponse scrapeResponse = buildScrapResponse();

        when(scrapService.scrapWebsite(scrapeRequest)).thenReturn(scrapeResponse);

        //when
        String scrapResponse = apsService.scrapeWebsite(customer, "test");

        //then
        assertTrue(scrapResponse.contains(SCRAP_SUCCESSFUL));
    }

    @Test
    public void customerExceededMaxAllowedCredentialsForAccount() {
    }

    public ScrapeResponse buildScrapResponse(){
        ScrapeResponse scrapeResponse = new ScrapeResponse();
        scrapeResponse.setScrapeResult(ScrapeResult.SUCCESSFUL);
        scrapeResponse.setXmlResponse("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<scrape-session>\n" +
                "    <base-url>www.success-scrape-test.com</base-url>\n" +
                "    <date>10/01/2008</date>\n" +
                "    <time>13:50:00</time>\n" +
                "    <datapairs>\n" +
                "        <datapair id=\"001\">\n" +
                "            <text>Account no</text>\n" +
                "            <value>53844946068883</value>\n" +
                "        </datapair>\n" +
                "    </datapairs>\n" +
                "</scrape-session>");
        return scrapeResponse;
    }
}