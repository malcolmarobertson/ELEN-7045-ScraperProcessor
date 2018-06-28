package aps.application;

import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.statement.Statement;
import aps.domain.model.statement.StatementType;

public interface IMappingService {

    Statement createCustomerStatement(ScrapeObject scrapeObject, String billingCompanyType);

}
