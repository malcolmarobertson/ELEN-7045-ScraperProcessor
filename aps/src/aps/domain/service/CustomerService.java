package aps.domain.service;

import aps.application.ICustomerService;
import aps.domain.exception.ApsException;
import aps.domain.model.customer.Customer;
import aps.domain.model.customer.CustomerBillingAccount;
import aps.domain.model.customer.CustomerRepository;
import aps.infrastructure.persistence.hibernate.CustomerRepositoryHibernate;

public class CustomerService {

    public static final Integer MAX_NUMBER_OF_CREDENTIALS = 5;
    private CustomerRepository customerRepository;

    public void registerNewCustomer(Customer customer) {
        customerRepository = new CustomerRepositoryHibernate();
        customerRepository.save(customer);
    }

    public boolean customerExceededMaxAllowedCredentialsForAccount(Customer customer, CustomerBillingAccount customerBillingAccount) {
        boolean exceededMaxAllowedCredentials = Boolean.FALSE;
        //TODO: Add logic to determine this here.
        return exceededMaxAllowedCredentials;
    }

    public Customer getCustomer(String username) throws ApsException {
        CustomerRepository customerRepository = new CustomerRepositoryHibernate();
        Customer customer = null;
        customer = customerRepository.findByUserName(username);

        return customer;
    }
}
