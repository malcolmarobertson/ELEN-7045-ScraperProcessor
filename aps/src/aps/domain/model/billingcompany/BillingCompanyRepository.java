package aps.domain.model.billingcompany;

import java.util.HashMap;
import java.util.Map;

public interface BillingCompanyRepository {

    public BillingCompany findBillingCompanyByURL(String baseURL);

    public boolean addBillingCompany(BillingCompany BillingCompany);

    public boolean removeBillingCompany(BillingCompany BillingCompany);

    public void updateBillingCompany(BillingCompany BillingCompany);

}
