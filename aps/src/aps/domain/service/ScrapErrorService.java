package aps.domain.service;

import aps.application.IScrapErrorService;
import aps.domain.model.scraperror.ScrapeError;
import aps.domain.model.scraperror.ScrapeErrorCode;
import aps.domain.shared.GenericXmlParser;

import static aps.domain.model.scraperror.ScrapeErrorCode.INVALID_CREDENTIALS;

public class ScrapErrorService implements IScrapErrorService {

    public void handleScrapeError(String xmlResponse) {
        GenericXmlParser genericXmlParser = new GenericXmlParser(ScrapeError.class);
        ScrapeError scrapeError = (ScrapeError) genericXmlParser.parseScrapXml(xmlResponse);

        if (INVALID_CREDENTIALS.toString().equals(scrapeError.getScrapeErrorCode())) {

        }
    }
}
