package aps.domain.service;

import aps.domain.exception.ApsException;
import aps.domain.model.customer.AccountCredential;
import aps.domain.model.customer.Customer;
import aps.domain.model.customer.CustomerBillingAccount;
import aps.domain.model.customer.CustomerRepository;
import aps.infrastructure.persistence.hibernate.CustomerRepositoryHibernate;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class CustomerService {

    private CustomerRepository customerRepository;

    public void registerNewCustomer(Customer customer) {
        customerRepository = new CustomerRepositoryHibernate();
        customerRepository.save(customer);
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
}
