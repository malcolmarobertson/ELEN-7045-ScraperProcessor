package aps.application;

import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.statement.Statement;

/**
 * Strategy to map to the correct statement.
 */
public interface IStatementService {

    public Statement findById(int id);

    public void add(Statement customer);

    public void delete(Statement customer);

    public void update(Statement customer);
}
