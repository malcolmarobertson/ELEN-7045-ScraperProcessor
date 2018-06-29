package aps.infrastructure.persistence.hibernate;

import aps.domain.model.billingcompany.BillingCompany;
import aps.domain.model.billingcompany.BillingCompanyRepo;
import aps.domain.model.billingcompany.BillingCompanyRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Mock Hibernate implementation of BillingCompanyRepository.
 * The actual data is stored in a map.
 */
public class BillingCompanyRepositoryHibernate implements BillingCompanyRepository {

    BillingCompanyRepository billingCompanyRepository = new BillingCompanyRepo();


    @Override
    public BillingCompany findByURL(String baseURL) {
        return billingCompanyRepository.findByURL(baseURL);
    }

    @Override
    public BillingCompany findByName(String name) {
        return billingCompanyRepository.findByName(name);
    }

    @Override
    public boolean add(BillingCompany billingCompany) {

        return billingCompanyRepository.add(billingCompany);
    }

    @Override
    public boolean delete(BillingCompany billingCompany) {

        return billingCompanyRepository.delete(billingCompany);
    }

    @Override
    public void update(BillingCompany billingCompany) {
        billingCompanyRepository.update(billingCompany);
    }

    @Override
    public BillingCompany createBillingCompany(String companyName, String baseURL, String billingCompanyType) {
        return billingCompanyRepository.createBillingCompany(companyName,baseURL,billingCompanyType);
    }
}
