package aps.domain.model.billingcompany;

import aps.domain.model.statement.Statement;
import aps.domain.model.statement.StatementFactory;
import aps.domain.model.statement.StatementType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BillingCompanyFactory {


    //Backed up on a permanent storage under customer credentials
    private static UUID generateID(){
        return UUID.randomUUID();
    }
    private static Map<String, BillingCompany> billingCompanyMap = new HashMap<String, BillingCompany>();

    /**
     * Must search database/file for existing billingCompany instances with same url
     */
    public static boolean billingCompanyURLExist(String baseUrl){
        return billingCompanyMap.containsKey(baseUrl);
    }

    public static BillingCompany getBillingCompany(String baseUrl){
        return billingCompanyMap.get(baseUrl);
    }

    private static BillingCompany getBillingCompany(String companyName, String companyUrl, StatementType statementType, ScrapeConfiguration scrapeConfiguration, Statement statement){
        if (billingCompanyURLExist(companyUrl)){
            return getBillingCompany(companyUrl);
        }
        BillingCompany billingCompany = new BillingCompany(generateID());
        billingCompany.setName(companyName);
        billingCompany.setBaseUrl(companyUrl);
        billingCompany.setBillingCompanyType(statementType);
        billingCompany.setScrapeConfiguration(scrapeConfiguration);
        billingCompany.setStatement(statement);
        billingCompanyMap.put(companyUrl,billingCompany);
        return billingCompany;
    }

    public static BillingCompany createBillingCompany(String companyName, String baseURL, StatementType billingCompanyType){
        switch (billingCompanyType){
            case TELECOMS:
                return getBillingCompany(companyName,baseURL,StatementType.TELECOMS,ScrapeConfigurationFactory.createScrapeConfiguration(),StatementFactory.createStatement(StatementType.TELECOMS));
            case MUNICIPALITY:
                return getBillingCompany(companyName,baseURL,StatementType.MUNICIPALITY,ScrapeConfigurationFactory.createScrapeConfiguration(),StatementFactory.createStatement(StatementType.MUNICIPALITY));
            case CREDIT_CARD_PROVIDER:
                return getBillingCompany(companyName,baseURL,StatementType.CREDIT_CARD_PROVIDER,ScrapeConfigurationFactory.createScrapeConfiguration(),StatementFactory.createStatement(StatementType.CREDIT_CARD_PROVIDER));
            default:
                return null;
        }
    }


}
