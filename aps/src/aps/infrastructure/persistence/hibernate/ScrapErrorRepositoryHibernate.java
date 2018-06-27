package aps.infrastructure.persistence.hibernate;

import aps.application.util.XmlFileWriter;
import aps.domain.model.scraperror.ScrapErrorRepository;
import aps.domain.model.scraperror.ScrapeError;
import aps.domain.shared.GenericXmlParser;

import static aps.domain.shared.ApplicationConstants.SCRAPE_ERROR_FILE_BASE_PATH;
import static aps.domain.shared.ApplicationConstants.XML_EXTENSION;

/**
 * Mock Hibernate implementation of ScrapErrorRepository.
 * The actual data is stored in xml files in the resources folder in the project file path.
 */
public class ScrapErrorRepositoryHibernate implements ScrapErrorRepository {

    GenericXmlParser genericXmlParser;

    @Override
    public ScrapeError findByBaseUrl(String baseUrl) {
        return null;
    }

    @Override
    public void save(ScrapeError scrapeError) {
        genericXmlParser = new GenericXmlParser(ScrapeError.class);
        String xmlScrapeErrorEntry = genericXmlParser.marshallScrapXml(scrapeError);
        String filePath = SCRAPE_ERROR_FILE_BASE_PATH + scrapeError.getBillingCompanyName() + "scrape-error-entry"
                + scrapeError.getDate() + scrapeError.getTime() + XML_EXTENSION;
        XmlFileWriter.writeFile(filePath, xmlScrapeErrorEntry);
    }

    @Override
    public void delete(ScrapeError scrapeError) {
    }

    @Override
    public void update(ScrapeError scrapeError) {
    }
}
