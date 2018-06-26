package aps.infrastructure.persistence.hibernate;

import aps.domain.model.billingcompany.BillingCompany;
import aps.domain.model.billingcompany.BillingCompanyRepository;

import java.util.UUID;

/**
 * Hibernate implementation of BillingCompanyRepository.
 */
public class BillingCompanyRepositoryHibernate extends HibernateRepository implements BillingCompanyRepository {


    @Override
    public BillingCompany findBillingCompanyByURL(String baseURL) {
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
