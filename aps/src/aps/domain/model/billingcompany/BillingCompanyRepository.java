package aps.domain.model.billingcompany;

public interface BillingCompanyRepository {

    public BillingCompany findBillingCompanyById(int id);

    public boolean addBillingCompany(BillingCompany BillingCompany);

    public boolean removeBillingCompany(BillingCompany BillingCompany);

    public void updateBillingCompany(BillingCompany BillingCompany);

}
