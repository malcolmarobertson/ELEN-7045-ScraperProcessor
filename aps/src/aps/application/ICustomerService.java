package aps.application;

import aps.domain.exception.ApsException;
import aps.domain.model.customer.Customer;
import aps.domain.model.customer.CustomerBillingAccount;

import java.util.UUID;

public interface ICustomerService {
    void registerNewCustomer(Customer customer);

    Customer getCustomer(String username) throws ApsException;

    public Customer findCustomerById(UUID id);

    public Customer findByUserName(String username) throws ApsException;

    public void add(Customer customer);

    public void delete(Customer customer);

    public void update(Customer customer);

    public boolean addCustomerCredential(Customer customer, CustomerBillingAccount customerBillingAccount, String userName, String password);

}
