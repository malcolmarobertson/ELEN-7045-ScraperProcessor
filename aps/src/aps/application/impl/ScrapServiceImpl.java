package aps.application.impl;

import aps.application.IMappingService;
import aps.application.IScrapService;
import aps.application.util.XmlFileReader;
import aps.application.util.ScrapeResult;
import aps.domain.model.scrape.ScrapeObject;
import aps.domain.shared.ScrapeRequest;
import aps.domain.shared.ScrapeResponse;
import aps.domain.shared.XmlParseHelper;

/**
 * This is the class that mimics the module that performs the actual scrapping. It is linked to the Scrapping Component of the
 * system.
 */
public class ScrapServiceImpl implements IScrapService {

    IMappingService mappingService;

    @Override
    public ScrapeObject scrapWebsite(ScrapeRequest scrapeRequest) {
        ScrapeResponse scrapeResponse = getScrapResponse(scrapeRequest);
        ScrapeObject scrapeObject = null;
        if (scrapeResponse.getScrapeResult().equals(ScrapeResult.SUCCESSFUL)) {
            scrapeObject = XmlParseHelper.parseScrapXml(scrapeResponse.getXmlResponse());
        } else {
            //TODO: Handle parsing of ScrapeError
//            ScrapeError scrapeError =
        }
        return scrapeObject;
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
