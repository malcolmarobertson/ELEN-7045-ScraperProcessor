package aps.domain.model.customer;

import aps.domain.exception.ApsException;

public interface CustomerRepository {

    public Customer findById(int id);

    public Customer findByUserName(String username) throws ApsException;

    public void save(Customer customer);

    public void delete(Customer customer);

    public void update(Customer customer);
}
