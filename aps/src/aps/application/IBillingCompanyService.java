package aps.application;

import aps.domain.exception.ApsException;
import aps.domain.model.billingcompany.BillingCompany;
import aps.domain.model.billingcompany.BillingCompanyRepository;
import aps.infrastructure.persistence.hibernate.BillingCompanyRepositoryHibernate;

public interface IBillingCompanyService {
    public BillingCompanyRepository billingCompanyRepository = new BillingCompanyRepositoryHibernate();
    
    void registerNewBillingCompany(BillingCompany billingCompany);

    BillingCompany getBillingCompany(String username) throws ApsException;

    public BillingCompany findByURL(String baseURL);

    public BillingCompany findByName(String baseURL);

    public boolean add(BillingCompany BillingCompany);

    public boolean delete(BillingCompany BillingCompany);

    public void update(BillingCompany BillingCompany);

}
