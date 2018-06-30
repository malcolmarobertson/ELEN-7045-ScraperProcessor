package aps.domain.model.billingcompany;

import aps.domain.model.statement.Statement;
import aps.domain.model.statement.StatementFactory;
import aps.domain.model.statement.StatementType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static aps.domain.shared.ApplicationConstants.CREDIT_CARD_PROVIDER_BILLING_COMPANY_TYPE;
import static aps.domain.shared.ApplicationConstants.MUNICIPALITY_BILLING_COMPANY_TYPE;
import static aps.domain.shared.ApplicationConstants.TELECOMS_BILLING_COMPANY_TYPE;

public class BillingCompanyFactory {

    //Backed up on a permanent storage under customer credentials
    private static UUID generateID() {
        return UUID.randomUUID();
    }

    private static Map<String, BillingCompany> billingCompanyMap = new HashMap<String, BillingCompany>();

    /**
     * Must search database/file for existing billingCompany instances with same url
     */
    public static boolean billingCompanyURLExist(String baseUrl) {
        return billingCompanyMap.containsKey(baseUrl);
    }

    public static BillingCompany getBillingCompany(String baseUrl) {
        return billingCompanyMap.get(baseUrl);
    }

    private static BillingCompany getBillingCompany(String companyName, String companyUrl,
                                                    String statementType, ScrapeConfiguration scrapeConfiguration, Statement statement) {
        if (billingCompanyURLExist(companyUrl)) {
            return getBillingCompany(companyUrl);
        }
        BillingCompany billingCompany = new BillingCompany(generateID());
        billingCompany.setName(companyName);
        billingCompany.setBaseUrl(companyUrl);
        billingCompany.setBillingCompanyType(statementType);
        billingCompany.setScrapeConfiguration(scrapeConfiguration);
        billingCompanyMap.put(companyUrl, billingCompany);
        return billingCompany;
    }

    public static BillingCompany createBillingCompany(String companyName, String baseURL, String billingCompanyType) {
        switch (billingCompanyType) {
            case TELECOMS_BILLING_COMPANY_TYPE:
                return getBillingCompany(companyName, baseURL, TELECOMS_BILLING_COMPANY_TYPE,
                        ScrapeConfigurationFactory.createScrapeConfiguration(), StatementFactory.createStatement(TELECOMS_BILLING_COMPANY_TYPE));
            case MUNICIPALITY_BILLING_COMPANY_TYPE:
                return getBillingCompany(companyName, baseURL, MUNICIPALITY_BILLING_COMPANY_TYPE,
                        ScrapeConfigurationFactory.createScrapeConfiguration(), StatementFactory.createStatement(MUNICIPALITY_BILLING_COMPANY_TYPE));
            case CREDIT_CARD_PROVIDER_BILLING_COMPANY_TYPE:
                return getBillingCompany(companyName, baseURL, CREDIT_CARD_PROVIDER_BILLING_COMPANY_TYPE,
                        ScrapeConfigurationFactory.createScrapeConfiguration(), StatementFactory.createStatement(CREDIT_CARD_PROVIDER_BILLING_COMPANY_TYPE));
            default:
                return null;
        }
    }


}
