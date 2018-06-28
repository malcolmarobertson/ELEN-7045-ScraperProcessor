package aps.domain.model.billingcompany;

import aps.domain.model.statement.StatementType;

public class BillingCompanyFactoryTest {

    private static void print(BillingCompany billingCompany){
        System.out.println(billingCompany.getId());
        System.out.println(billingCompany.getName());
        System.out.println(billingCompany.getBaseUrl());
        System.out.println(billingCompany.getBillingCompanyType());
        System.out.println("Scrape Configuration Instance: "+ billingCompany.getScrapeConfiguration());

    }

    public static void main(String... args){
        print(BillingCompanyFactory.createBillingCompany("Metshimaholo Municipality","www.metsimaholo.gov.za",StatementType.MUNICIPALITY));
        print(BillingCompanyFactory.createBillingCompany("FNB","www.fnb.co.za",StatementType.CREDIT_CARD_PROVIDER));
        print(BillingCompanyFactory.createBillingCompany("Telkom","www.telkom.co.za",StatementType.TELECOMS));
    }

}
