package aps.domain.model.billingcompany;

public interface BillingCompanyRepository {

    public BillingCompany findByURL(String baseURL);

    public BillingCompany findByName(String baseURL);

    public boolean add(BillingCompany BillingCompany);

    public boolean delete(BillingCompany BillingCompany);

    public void update(BillingCompany BillingCompany);

}
