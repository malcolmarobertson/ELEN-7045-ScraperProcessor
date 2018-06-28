package aps.application.impl;

import aps.application.IBillingCompanyService;
import aps.domain.exception.ApsException;
import aps.domain.model.billingcompany.BillingCompany;
import aps.domain.model.billingcompany.BillingCompanyRepository;
import aps.infrastructure.persistence.hibernate.BillingCompanyRepositoryHibernate;

public class BillingCompanyServiceImpl implements IBillingCompanyService {

    BillingCompanyRepository billingCompanyRepository = new BillingCompanyRepositoryHibernate();

    public BillingCompany findByURL(String baseURL) {
        return billingCompanyRepository.findByURL(baseURL);
    }

    @Override
    public BillingCompany findByName(String baseURL) {
        return null;
    }

    @Override
    public boolean add(BillingCompany BillingCompany) {
        return false;
    }

    public boolean delete(BillingCompany billingCompany) {
        return billingCompanyRepository.delete(billingCompany);
    }

    public void update(BillingCompany billingCompany) {
        billingCompanyRepository.add(billingCompany);
    }

    @Override
    public void registerNewBillingCompany(BillingCompany billingCompany) {
        billingCompanyRepository.add(billingCompany);
    }

    @Override
    public BillingCompany getBillingCompany(String billingCompanyName) throws ApsException {
        return billingCompanyRepository.findByName(billingCompanyName);
    }
}
