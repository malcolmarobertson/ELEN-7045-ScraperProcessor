package aps.application;

import aps.domain.model.customer.Customer;

public interface ICustomerService {
    void registerCustomer();

    Customer getCustomer(String username);
}
