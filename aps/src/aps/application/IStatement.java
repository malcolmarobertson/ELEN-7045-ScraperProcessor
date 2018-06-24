package aps.application;

import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.statement.Statement;

/**
 * Strategy to map to the correct statement.
 */
public interface IStatement {
    public Statement generateStatement(ScrapeObject scrapeObject);
}
