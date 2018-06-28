package aps.application.impl;

import aps.application.ICustomerService;
import aps.domain.exception.ApsException;
import aps.domain.model.customer.AccountCredential;
import aps.domain.model.customer.Customer;
import aps.domain.model.customer.CustomerBillingAccount;
import aps.domain.model.customer.CustomerRepository;
import aps.infrastructure.persistence.hibernate.CustomerRepositoryHibernate;

import java.util.UUID;

public class CustomerServiceImpl implements ICustomerService {

    private CustomerRepository customerRepository = new CustomerRepositoryHibernate();

    public void registerNewCustomer(Customer customer) {
        customerRepository = new CustomerRepositoryHibernate();
        customerRepository.add(customer);
    }

    public boolean addCustomerCredential(Customer customer, CustomerBillingAccount customerBillingAccount, String userName, String password) {
        if (!customer.customerReachedMaxAllowedCredentialsForAccount(customerBillingAccount)) {
            AccountCredential accountCredential = new AccountCredential();
            accountCredential.setPassword(password);
            accountCredential.setUserName(userName);
            customerBillingAccount.getAccountCredentials().add(accountCredential);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Customer getCustomer(String username) throws ApsException {
        CustomerRepository customerRepository = new CustomerRepositoryHibernate();
        Customer customer = null;
        customer = customerRepository.findByUserName(username);

        return customer;
    }

    @Override
    public Customer findCustomerById(UUID id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public Customer findByUserName(String username) throws ApsException {
        return customerRepository.findByUserName(username);
    }

    @Override
    public void add(Customer customer) {
        customerRepository.add(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);
    }
}
