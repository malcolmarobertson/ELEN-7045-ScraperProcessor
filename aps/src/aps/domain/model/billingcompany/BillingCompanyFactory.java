package aps.domain.model.billingcompany;

import aps.domain.model.statement.Statement;
import aps.domain.model.statement.StatementFactory;

import java.util.HashMap;
import java.util.Map;

public class BillingCompanyFactory {


    //Backed up on a permanent storage under customer credentials
    private static int ID = 0;
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

    private static BillingCompany getBillingCompany(String companyName, String companyUrl, BillingCompanyType billingCompanyType, ScrapeConfiguration scrapeConfiguration, Statement statement){
        if (billingCompanyURLExist(companyUrl)){
            return getBillingCompany(companyUrl);
        }
        BillingCompany billingCompany = new BillingCompany();
        billingCompany.setId(++ID+"");
        billingCompany.setName(companyName);
        billingCompany.setBaseUrl(companyUrl);
        billingCompany.setBillingCompanyType(billingCompanyType);
        billingCompany.setScrapeConfiguration(scrapeConfiguration);
        billingCompany.setStatement(statement);
        billingCompanyMap.put(companyUrl,billingCompany);
        return billingCompany;
    }

    public static BillingCompany createBillingCompanyForMunicipality(String companyName, String baseUrl){
        return getBillingCompany(companyName,baseUrl,BillingCompanyType.MUNICIPALITY,ScrapeConfigurationFactory.createScrapeConfiguration(),StatementFactory.createMunicipalityStatement());
    }

    public static BillingCompany createBillingCompanyForCreditCard(String companyName, String baseUrl){
        return getBillingCompany(companyName,baseUrl,BillingCompanyType.CREDIT_CARD_PROVIDER,ScrapeConfigurationFactory.createScrapeConfiguration(),StatementFactory.createCredidCardStatement());

    }

    public static BillingCompany createBillingCompanyForTelecommunicationServiceProvider(String companyName, String baseUrl){
        return getBillingCompany(companyName,baseUrl,BillingCompanyType.TELECOMS,ScrapeConfigurationFactory.createScrapeConfiguration(),StatementFactory.createTelcommunicationStatemenr());
    }


}
