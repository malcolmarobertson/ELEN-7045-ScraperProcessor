package aps.domain.model.billingcompany;

public class BillingCompanyMain {

    public static void main(String... args){
        BillingCompanyRepository billingCompanyRepo = new BillingCompanyRepo();
        BillingCompany telkom = billingCompanyRepo.createBillingCompany("Telkom","www.telkom.co.za","TELECOMS_BILLING_COMPANY_TYPE");
        BillingCompany mtn = billingCompanyRepo.createBillingCompany("MTN","www.mtn.co.zaa","TELECOMS_BILLING_COMPANY_TYPE");
        BillingCompany rain = billingCompanyRepo.createBillingCompany("RAIN","www.rain.co.z","TELECOMS_BILLING_COMPANY_TYPE");
        billingCompanyRepo.add(telkom);
        billingCompanyRepo.add(rain);
        billingCompanyRepo.add(mtn);
        billingCompanyRepo.delete(rain);
        System.out.println(billingCompanyRepo.findByURL("www.telkom.co.za").getBaseUrl());

    }

}
