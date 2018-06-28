package aps.infrastructure.persistence.hibernate;

import aps.application.util.XmlFileWriter;
import aps.domain.model.error.Error;
import aps.domain.model.error.ErrorRepository;
import aps.domain.shared.GenericXmlParser;

import java.util.Date;

import static aps.domain.shared.ApplicationConstants.SCRAPE_ERROR_FILE_BASE_PATH;
import static aps.domain.shared.ApplicationConstants.XML_EXTENSION;

/**
 * Mock Hibernate implementation of ErrorRepository.
 * The actual data is stored in xml files in the resources folder in the project file path.
 */
public class ErrorRepositoryHibernate implements ErrorRepository {

    GenericXmlParser genericXmlParser;

    @Override
    public Error findByBaseUrl(String baseUrl) {
        return null;
    }

    @Override
    public void add(Error error) {
        genericXmlParser = new GenericXmlParser(Error.class);
        String xmlScrapeErrorEntry = genericXmlParser.marshallScrapXml(error);
        String filePath = SCRAPE_ERROR_FILE_BASE_PATH + error.getBillingCompanyName() + "scrape-error-entry"
                + error.getDate() + error.getTime() + XML_EXTENSION;
        XmlFileWriter.writeFile(filePath, xmlScrapeErrorEntry);
    }

    @Override
    public void logError(String errorString) {
        long timestamp = new Date().getTime();
        String filePath = SCRAPE_ERROR_FILE_BASE_PATH + String.valueOf(timestamp) + "scrape-error-entry"
                + XML_EXTENSION;
        XmlFileWriter.writeFile(filePath, errorString);
        System.out.println("Scrape Error logging simulated by writing to file: " + filePath + ".");
        System.out.println("");
    }

    @Override
    public void delete(Error error) {
    }

    @Override
    public void update(Error error) {
    }
}
