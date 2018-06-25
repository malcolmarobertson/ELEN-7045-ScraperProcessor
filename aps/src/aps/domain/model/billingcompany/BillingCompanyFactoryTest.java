package aps.domain.model.billingcompany;

public class BillingCompanyFactoryTest {

    private static void print(BillingCompany billingCompany){
        System.out.println(billingCompany.getId());
        System.out.println(billingCompany.getName());
        System.out.println(billingCompany.getBaseUrl());
        System.out.println(billingCompany.getBillingCompanyType());
        System.out.println("Statement instance: "+ billingCompany.getStatement());
        System.out.println("Scrape Configuration Instance: "+ billingCompany.getScrapeConfiguration());

    }

    public static void main(String... args){
        print(BillingCompanyFactory.createBillingCompanyForMunicipality("Metshimaholo Municipality","www.metsimaholo.gov.za"));
        print(BillingCompanyFactory.createBillingCompanyForCreditCard("FNB","www.fnb.co.za"));
        print(BillingCompanyFactory.createBillingCompanyForTelecommunicationServiceProvider("Telkom","www.telkom.co.za"));
    }

}
