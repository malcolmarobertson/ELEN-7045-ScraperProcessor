package aps.domain.model.customer;

import aps.domain.exception.ApsException;

import java.util.UUID;

public interface CustomerRepository {

    public Customer findCustomerById(UUID id);

    public Customer findByUserName(String username) throws ApsException;

    public void save(Customer customer);

    public void delete(Customer customer);

    public void update(Customer customer);
}
