package aps.application.impl;

import aps.application.IMappingService;
import aps.application.IScrapErrorService;
import aps.domain.model.mapping.CreditCardProviderMapper;
import aps.domain.model.mapping.GenericMapper;
import aps.domain.model.mapping.MunicipalityMapper;
import aps.domain.model.mapping.TelecomsMapper;
import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.statement.Statement;
import aps.domain.model.statement.StatementType;

import static aps.domain.shared.ApplicationConstants.CREDIT_CARD_PROVIDER_BILLING_COMPANY_TYPE;
import static aps.domain.shared.ApplicationConstants.MUNICIPALITY_BILLING_COMPANY_TYPE;
import static aps.domain.shared.ApplicationConstants.TELECOMS_BILLING_COMPANY_TYPE;


public class MappingServiceImpl implements IMappingService {

    IScrapErrorService scrapErrorService;

    @Override
    public Statement createCustomerStatement(ScrapeObject scrapeObject, String billingCompanyType) {
        scrapErrorService = new ScrapErrorServiceImpl();
        GenericMapper genericMapper;
        Statement statement = null;

        if (billingCompanyType.equals(TELECOMS_BILLING_COMPANY_TYPE)) {
            genericMapper = new TelecomsMapper();
            return genericMapper.generateStatement(scrapeObject);
        } else if (billingCompanyType.equals(MUNICIPALITY_BILLING_COMPANY_TYPE)) {
            genericMapper = new MunicipalityMapper();
            return genericMapper.generateStatement(scrapeObject);
        } else if (billingCompanyType.equals(CREDIT_CARD_PROVIDER_BILLING_COMPANY_TYPE)) {
            genericMapper = new CreditCardProviderMapper();
            return genericMapper.generateStatement(scrapeObject);
        }
        return statement;
    }
}
