package aps.domain.model.customer;

import java.util.UUID;

public interface CustomerRepository {

    public Customer findCustomerById(UUID id);

    public boolean addCustomer(Customer customer);

    public boolean removeCustomer(Customer customer);

    public void updateCustomer(Customer customer);
}
