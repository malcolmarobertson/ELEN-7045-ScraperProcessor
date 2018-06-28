package aps.domain.model.billingcompany;

import aps.domain.model.statement.StatementType;

import static aps.domain.shared.ApplicationConstants.CREDIT_CARD_PROVIDER_BILLING_COMPANY_TYPE;
import static aps.domain.shared.ApplicationConstants.MUNICIPALITY_BILLING_COMPANY_TYPE;
import static aps.domain.shared.ApplicationConstants.TELECOMS_BILLING_COMPANY_TYPE;

public class BillingCompanyFactoryTest {

    private static void print(BillingCompany billingCompany) {
        System.out.println(billingCompany.getId());
        System.out.println(billingCompany.getName());
        System.out.println(billingCompany.getBaseUrl());
        System.out.println(billingCompany.getBillingCompanyType());
        System.out.println("Scrape Configuration Instance: " + billingCompany.getScrapeConfiguration());

    }

    public static void main(String... args) {
        print(BillingCompanyFactory.createBillingCompany("Metshimaholo Municipality", "www.metsimaholo.gov.za", MUNICIPALITY_BILLING_COMPANY_TYPE));
        print(BillingCompanyFactory.createBillingCompany("FNB", "www.fnb.co.za", CREDIT_CARD_PROVIDER_BILLING_COMPANY_TYPE));
        print(BillingCompanyFactory.createBillingCompany("Telkom", "www.telkom.co.za", TELECOMS_BILLING_COMPANY_TYPE));
    }

}
