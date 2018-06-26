package aps.infrastructure.persistence.hibernate;

import aps.application.util.XmlFileWriter;
import aps.domain.model.billingcompany.BillingCompany;
import aps.domain.model.billingcompany.BillingCompanyRepository;
import aps.domain.shared.GenericXmlParser;

import static aps.domain.shared.ApplicationConstants.BILLING_COMPANY_FILE_BASE_PATH;
import static aps.domain.shared.ApplicationConstants.XML_EXTENSION;

/**
 * Mock Hibernate implementation of BillingCompanyRepository.
 * The actual data is stored in xml files in the resources folder in the project file path.
 */
public class BillingCompanyRepositoryHibernate implements BillingCompanyRepository {

    GenericXmlParser genericXmlParser;

    @Override
    public BillingCompany findById(int id) {
        return null;
    }

    @Override
    public void save(BillingCompany billingCompany) {
        genericXmlParser = new GenericXmlParser(BillingCompany.class);
        String xmlScrapeErrorEntry = genericXmlParser.marshallScrapXml(billingCompany);
        String filePath = BILLING_COMPANY_FILE_BASE_PATH + billingCompany.getName() + XML_EXTENSION;
        XmlFileWriter.writeFile(filePath, xmlScrapeErrorEntry);
    }

    @Override
    public void delete(BillingCompany billingCompany) {

    }

    @Override
    public void update(BillingCompany billingCompany) {

    }
}
