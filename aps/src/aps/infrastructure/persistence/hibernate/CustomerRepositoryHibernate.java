package aps.infrastructure.persistence.hibernate;

import aps.application.util.XmlFileReader;
import aps.application.util.XmlFileWriter;
import aps.domain.exception.ApsException;
import aps.domain.model.customer.Customer;
import aps.domain.model.customer.CustomerRepository;
import aps.domain.shared.GenericXmlParser;

import java.io.File;
import java.nio.file.Paths;
import java.util.UUID;

import static aps.domain.shared.ApplicationConstants.CUSTOMER_FILE_BASE_PATH;
import static aps.domain.shared.ApplicationConstants.XML_EXTENSION;

/**
 * Mock Hibernate implementation of CustomerRepository.
 * The actual data is stored in xml files in the resources folder in the project file path.
 */
public class CustomerRepositoryHibernate implements CustomerRepository {

    GenericXmlParser genericXmlParser;

    @Override
    public Customer findCustomerById(UUID id) {
        return null;
    }

    @Override
    public Customer findByUserName(String username) throws ApsException {
        genericXmlParser = new GenericXmlParser(Customer.class);

        String filePath = Paths.get("").toAbsolutePath().toString()
                + File.separator + CUSTOMER_FILE_BASE_PATH
                + File.separator + username.toLowerCase() + XML_EXTENSION;
        File userFile = new File(filePath);

        if (!userFile.exists()) {
            throw new ApsException("User " + username + " does not exist!");
        } else {
            String xmlFile = XmlFileReader.readFile(filePath);
            Customer customer = (Customer) genericXmlParser.parseScrapXml(xmlFile);
            return customer;
        }
    }

    @Override
    public void add(Customer customer) {
        genericXmlParser = new GenericXmlParser(Customer.class);
        String xmlScrapeErrorEntry = genericXmlParser.marshallScrapXml(customer);
        String filePath = Paths.get("").toAbsolutePath().toString()
                + File.separator + CUSTOMER_FILE_BASE_PATH
                + File.separator + customer.getApsUserName().toLowerCase() + XML_EXTENSION;
        XmlFileWriter.writeFile(filePath, xmlScrapeErrorEntry);
    }

    @Override
    public void delete(Customer customer) {
    }

    @Override
    public void update(Customer customer) {

    }
}
