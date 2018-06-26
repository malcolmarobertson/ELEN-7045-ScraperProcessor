package aps.domain.model.billingcompany;

import java.util.HashMap;
import java.util.Map;

public class BillingCompanyRepo implements BillingCompanyRepository {

    //Backed up on a database/file
    private Map<String,BillingCompany> billingCompanyRepo = new HashMap<>();

    @Override
    public BillingCompany findBillingCompanyByURL(String baseURL) {
        return billingCompanyRepo.get(baseURL);
    }

    @Override
    public boolean addBillingCompany(BillingCompany billingCompany) {
        if(billingCompanyRepo.containsKey(billingCompany.getBaseUrl())){
            return false;
        }
        billingCompanyRepo.put(billingCompany.getBaseUrl(),billingCompany);
        return true;
    }

    @Override
    public boolean removeBillingCompany(BillingCompany billingCompany) {
        if(billingCompanyRepo.containsKey(billingCompany.getBaseUrl())){
            billingCompanyRepo.remove(billingCompany.getBaseUrl());
            return true;
        }
        return false;
    }

    @Override
    public void updateBillingCompany(BillingCompany billingCompany) {
        billingCompanyRepo.replace(billingCompany.getBaseUrl(),billingCompany);
    }
}
