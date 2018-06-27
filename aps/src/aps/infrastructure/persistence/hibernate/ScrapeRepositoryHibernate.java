package aps.infrastructure.persistence.hibernate;

import aps.application.util.XmlFileWriter;
import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.scrape.ScrapeRepository;
import aps.domain.model.scraperror.ScrapeError;
import aps.domain.shared.GenericXmlParser;

import static aps.domain.shared.ApplicationConstants.SCRAPE_FILE_BASE_PATH;
import static aps.domain.shared.ApplicationConstants.XML_EXTENSION;

/**
 * Mock Hibernate implementation of ScrapeRepository.
 * The actual data is stored in xml files in the resources folder in the project file path.
 */
public class ScrapeRepositoryHibernate implements ScrapeRepository {

    GenericXmlParser genericXmlParser;

    @Override
    public ScrapeObject findByBaseUrl(String baseUrl) {
        return null;
    }

    @Override
    public void save(ScrapeObject scrapeObject) {
        genericXmlParser = new GenericXmlParser(ScrapeError.class);
        String xmlScrapeErrorEntry = genericXmlParser.marshallScrapXml(scrapeObject);
        String filePath = SCRAPE_FILE_BASE_PATH + scrapeObject.getBillingCompanyName() + "-scrape-entry-"
                + scrapeObject.getDate() + scrapeObject.getTime() + XML_EXTENSION;
        XmlFileWriter.writeFile(filePath, xmlScrapeErrorEntry);
    }

    @Override
    public void delete(ScrapeObject scrapeObject) {
    }

    @Override
    public void update(ScrapeObject scrapeObject) {
    }
}
