package aps.domain.model.billingcompany;

public interface BillingCompanyRepository {

    public BillingCompany findById(int id);

    public void save(BillingCompany BillingCompany);

    public void delete(BillingCompany BillingCompany);

    public void update(BillingCompany BillingCompany);

}
