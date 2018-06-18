package aps.infrastructure.persistence.hibernate;

import aps.domain.model.billingcompany.BillingCompany;
import aps.domain.model.billingcompany.BillingCompanyRepository;

/**
 * Hibernate implementation of BillingCompanyRepository.
 */
public class BillingCompanyRepositoryHibernate extends HibernateRepository implements BillingCompanyRepository {


    @Override
    public BillingCompany findBillingCompanyById(int id) {
        return null;
    }

    @Override
    public boolean addBillingCompany(BillingCompany BillingCompany) {
        return false;
    }

    @Override
    public boolean removeBillingCompany(BillingCompany BillingCompany) {
        return false;
    }

    @Override
    public void updateBillingCompany(BillingCompany BillingCompany) {

    }
}
