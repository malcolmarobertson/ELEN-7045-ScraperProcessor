package aps.infrastructure.persistence.hibernate;

import aps.domain.model.billingcompany.BillingCompany;
import aps.domain.model.billingcompany.BillingCompanyRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Mock Hibernate implementation of BillingCompanyRepository.
 * The actual data is stored in a map.
 */
public class BillingCompanyRepositoryHibernate implements BillingCompanyRepository {

    //Backed up on a database/file
    private Map<String, BillingCompany> billingCompanyRepo = new HashMap<>();

    @Override
    public BillingCompany findByURL(String baseURL) {
        return billingCompanyRepo.get(baseURL);
    }

    @Override
    public BillingCompany findByName(String baseURL) {
        return null;
    }

    @Override
    public boolean add(BillingCompany billingCompany) {
        if (billingCompanyRepo.containsKey(billingCompany.getBaseUrl())) {
            return false;
        }
        billingCompanyRepo.put(billingCompany.getBaseUrl(), billingCompany);
        return true;
    }

    @Override
    public boolean delete(BillingCompany billingCompany) {
        if (billingCompanyRepo.containsKey(billingCompany.getBaseUrl())) {
            billingCompanyRepo.remove(billingCompany.getBaseUrl());
            return true;
        }
        return false;
    }

    @Override
    public void update(BillingCompany billingCompany) {
        billingCompanyRepo.replace(billingCompany.getBaseUrl(), billingCompany);
    }
}
