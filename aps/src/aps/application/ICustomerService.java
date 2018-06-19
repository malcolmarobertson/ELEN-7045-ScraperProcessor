package aps.application;

import aps.domain.model.customer.Customer;

public interface ICustomerService {
    void registerNewCustomer(Customer customer);

    Customer getCustomer(String username);
}
