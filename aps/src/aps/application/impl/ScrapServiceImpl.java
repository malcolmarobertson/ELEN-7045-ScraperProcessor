package aps.application.impl;

import aps.application.IScrapService;
import aps.application.util.ScrapeResult;
import aps.application.util.XmlFileReader;
import aps.domain.model.customer.CustomerBillingAccount;
import aps.domain.shared.ApplicationConstants;
import aps.domain.shared.ScrapeRequest;
import aps.domain.shared.ScrapeResponse;

import java.io.File;
import java.nio.file.Paths;

import static aps.domain.shared.ApplicationConstants.CUSTOMER_FILE_BASE_PATH;
import static aps.domain.shared.ApplicationConstants.XML_EXTENSION;

/**
 * This is the class that mimics the module that performs the actual scrapping. It is integrated to the Scrapping Component of the
 * system.
 * We are mocking the ScrapeResponse. Using the City of Joburg Billing Company will return a scrap error of type INVALID_CREDENTIALS.
 * Using the Telkom Billing Company will return a valid scrape response.
 */
public class ScrapServiceImpl implements IScrapService {

    @Override
    public ScrapeResponse scrapWebsite(ScrapeRequest scrapeRequest) {
        return getScrapResponse(scrapeRequest);
    }

    /**
     * Mocking the Scrape Response from the Scrape component based on the filePath passed to it.
     *
     * @param scrapeRequest
     * @return
     */
    public ScrapeResponse getScrapResponse(ScrapeRequest scrapeRequest) {
        //Stub the response from the Scrap Component;
        ScrapeResponse scrapeResponse = new ScrapeResponse();

        if (scrapeRequest.getBaseUrl().equals("www.joburg.org.za")) {
            scrapeResponse.setXmlResponse(XmlFileReader.readFile(constructFilePath(ApplicationConstants.INVALID_CITY_OF_JOBURG_SCRAPE_FILE)));
            scrapeResponse.setScrapeResult(ScrapeResult.FAILED);
        } else if (scrapeRequest.getBaseUrl().equals("www.edgars.co.za")) {
            scrapeResponse.setXmlResponse(XmlFileReader.readFile(constructFilePath(ApplicationConstants.INVALID_EDGARS_SCRAPE_FILE)));
            scrapeResponse.setScrapeResult(ScrapeResult.FAILED);
        } else if (scrapeRequest.getBaseUrl().equals("www.telkom.co.za")) {
            scrapeResponse.setXmlResponse(XmlFileReader.readFile(constructFilePath(ApplicationConstants.VALID_TELKOM_SCRAPE_FILE)));
            scrapeResponse.setScrapeResult(ScrapeResult.SUCCESSFUL);
        } else if (scrapeRequest.getBaseUrl().equals("www.success-scrape-test.com")) {
            scrapeResponse.setXmlResponse(XmlFileReader.readFile(constructFilePath(ApplicationConstants.SCRAP_SUCCESS_TEST_FILE)));
            scrapeResponse.setScrapeResult(ScrapeResult.SUCCESSFUL);
        } else if (scrapeRequest.getBaseUrl().equals("www.failure-scrape-test.com")) {
            scrapeResponse.setXmlResponse(XmlFileReader.readFile(constructFilePath(ApplicationConstants.SCRAP_FAILURE_TEST_FILE)));
            scrapeResponse.setScrapeResult(ScrapeResult.FAILED);
        }

        return scrapeResponse;
    }

    @Override
    public void editScrapScript() {
    }

    @Override
    public void scheduleScrapeDates(CustomerBillingAccount customerBillingAccount) {
        //Calls the Scraper with details to Schedule scraping
    }

    private String constructFilePath(String fileName){
        String filePath = Paths.get("").toAbsolutePath().toString()
                + File.separator + fileName;
        File userFile = new File(filePath);
        return filePath;
    }
}
