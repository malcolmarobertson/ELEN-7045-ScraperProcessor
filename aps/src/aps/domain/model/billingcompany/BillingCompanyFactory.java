package aps.domain.model.billingcompany;

import aps.domain.model.statement.Statement;
import aps.domain.model.statement.StatementFactory;

import java.util.UUID;

import static aps.domain.shared.ApplicationConstants.*;

public class BillingCompanyFactory {

    //Backed up on a permanent storage under customer credentials
    private static UUID generateID() {
        return UUID.randomUUID();
    }

    public static BillingCompany createBillingCompany(String companyName, String baseURL, String billingCompanyType) {
        switch (billingCompanyType) {
            case "TELECOMS_BILLING_COMPANY_TYPE":
                return getBillingCompany(companyName, baseURL, "TELECOMS_BILLING_COMPANY_TYPE",
                        ScrapeConfigurationFactory.createScrapeConfiguration(),
                        StatementFactory.createStatement(TELECOMS_BILLING_COMPANY_TYPE));
            case "MUNICIPALITY_BILLING_COMPANY_TYPE":
                return getBillingCompany(companyName, baseURL, "MUNICIPALITY_BILLING_COMPANY_TYPE",
                        ScrapeConfigurationFactory.createScrapeConfiguration(),
                        StatementFactory.createStatement(MUNICIPALITY_BILLING_COMPANY_TYPE));
            case "CREDIT_CARD_PROVIDER_BILLING_COMPANY_TYPE":
                return getBillingCompany(companyName, baseURL, "CREDIT_CARD_PROVIDER_BILLING_COMPANY_TYPE",
                        ScrapeConfigurationFactory.createScrapeConfiguration(),
                        StatementFactory.createStatement(CREDIT_CARD_PROVIDER_BILLING_COMPANY_TYPE));
            default:
                return null;
        }
    }

    private static BillingCompany getBillingCompany(String companyName, String companyUrl, String statementType,
                                                    ScrapeConfiguration scrapeConfiguration, Statement statement) {
        BillingCompany billingCompany = new BillingCompany(generateID());
        billingCompany.setName(companyName);
        billingCompany.setBaseUrl(companyUrl);
        billingCompany.setBillingCompanyType(statementType);
        billingCompany.setScrapeConfiguration(scrapeConfiguration);
        return billingCompany;
    }
}
