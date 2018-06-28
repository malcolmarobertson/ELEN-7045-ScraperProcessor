package aps.infrastructure.persistence.hibernate;

import aps.application.util.XmlFileWriter;
import aps.domain.model.error.Error;
import aps.domain.model.error.ErrorRepository;
import aps.domain.shared.GenericXmlParser;

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
    public void delete(Error error) {
    }

    @Override
    public void update(Error error) {
    }
}
