package aps.infrastructure.persistence.hibernate;

import aps.application.util.XmlFileWriter;
import aps.domain.model.statement.Statement;
import aps.domain.model.statement.StatementRepository;
import aps.domain.shared.GenericXmlParser;

import static aps.domain.shared.ApplicationConstants.STATEMENT_FILE_BASE_PATH;
import static aps.domain.shared.ApplicationConstants.XML_EXTENSION;

/**
 * Mock Hibernate implementation of StatementRepository.
 * The actual data is stored in xml files in the resources folder in the project file path.
 */
public class StatementRepositoryHibernate implements StatementRepository {

    GenericXmlParser genericXmlParser;

    @Override
    public Statement findById(int id) {
        return null;
    }

    @Override
    public void save(Statement statement) {
        genericXmlParser = new GenericXmlParser(Statement.class);
        String xmlScrapeErrorEntry = genericXmlParser.marshallScrapXml(statement);
        String filePath = STATEMENT_FILE_BASE_PATH + statement.getStatementNumber() + "-statement" + XML_EXTENSION;
        XmlFileWriter.writeFile(filePath, xmlScrapeErrorEntry);
    }

    @Override
    public void delete(Statement statement) {
    }

    @Override
    public void update(Statement statement) {

    }
}
