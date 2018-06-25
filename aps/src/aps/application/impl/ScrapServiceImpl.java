package aps.application.impl;

import aps.application.IScrapErrorService;
import aps.application.IScrapService;
import aps.application.util.XmlFileReader;
import aps.application.util.ScrapeResult;
import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.scraperror.*;
import aps.domain.shared.ScrapeRequest;
import aps.domain.shared.ScrapeResponse;
import aps.domain.shared.GenericXmlParser;

import static aps.domain.model.scraperror.ScrapeErrorCode.*;
import static aps.domain.model.scraperror.ScrapeErrorCode.BROKEN_SCRIPT;
import static aps.domain.model.scraperror.ScrapeErrorCode.ERROR_PAGE;

/**
 * This is the class that mimics the module that performs the actual scrapping. It is integrated to the Scrapping Component of the
 * system.
 */
public class ScrapServiceImpl implements IScrapService {
    private static final String SCRAP_SUCCESSFUL = "Scraping completed successfully for url: ";
    IScrapErrorService scrapErrorService;

    @Override
    public String scrapWebsite(ScrapeRequest scrapeRequest) {
        ScrapeResponse scrapeResponse = getScrapResponse(scrapeRequest);
        ScrapeObject scrapeObject = null;

        if (scrapeResponse.getScrapeResult().equals(ScrapeResult.SUCCESSFUL)) {
            GenericXmlParser genericXmlParser = new GenericXmlParser(ScrapeObject.class);
            scrapeObject = (ScrapeObject) genericXmlParser.parseScrapXml(scrapeResponse.getXmlResponse());
        } else {
            //TODO: Get Customer or CustomerBillingAccount object to pass for handling scrape errors.
            return handleScrapeError(scrapeResponse);
        }
        return SCRAP_SUCCESSFUL + scrapeObject.getBaseUrl();
    }

    public String handleScrapeError(ScrapeResponse scrapeResponse) {
        GenericXmlParser genericXmlParser = new GenericXmlParser(ScrapeError.class);
        ScrapeError scrapeObject = (ScrapeError) genericXmlParser.parseScrapXml(scrapeResponse.getXmlResponse());
        ScrapeErrorContext scrapeErrorContext = new ScrapeErrorContext();
        setCorrectScrapErrorContext(scrapeObject, scrapeErrorContext);
        return scrapeErrorContext.handleScrapeError();
    }

    private void setCorrectScrapErrorContext(ScrapeError scrapeObject, ScrapeErrorContext scrapeErrorContext) {
        if (INVALID_CREDENTIALS.toString().equals(scrapeObject.getScrapeErrorCode())) {
            scrapeErrorContext.setScrapeErrorStrategy(new InvalidCredentialsScrapeError());
        } else if (NOT_SIGNED_FOR_EBILLING.toString().equals(scrapeObject.getScrapeErrorCode())) {
            scrapeErrorContext.setScrapeErrorStrategy(new NotSignedForEBillingScrapeError());
        } else if (CUSTOMER_ACTION_REQUIRED.toString().equals(scrapeObject.getScrapeErrorCode())) {
            scrapeErrorContext.setScrapeErrorStrategy(new CustomerActionRequiredScrapeError());
        } else if (SITE_DOWN.toString().equals(scrapeObject.getScrapeErrorCode())) {
            scrapeErrorContext.setScrapeErrorStrategy(new SiteDownScrapeError());
        } else if (ERROR_PAGE.toString().equals(scrapeObject.getScrapeErrorCode())) {
            scrapeErrorContext.setScrapeErrorStrategy(new ErrorPageScrapeError());
        } else if (BROKEN_SCRIPT.toString().equals(scrapeObject.getScrapeErrorCode())) {
            scrapeErrorContext.setScrapeErrorStrategy(new BrokenScriptScrapeError());
        }
    }

    public ScrapeResponse getScrapResponse(ScrapeRequest scrapeRequest) {
        //Stub the response from the Scrap Component;
        ScrapeResponse scrapeResponse = new ScrapeResponse();
        scrapeResponse.setScrapeResult(ScrapeResult.SUCCESSFUL);
        scrapeResponse.setXmlResponse(XmlFileReader.readFile("src/resources/scrape/telkom-scrape.xml"));
        return scrapeResponse;
    }

    @Override
    public void editScrapScript() {
    }
}
