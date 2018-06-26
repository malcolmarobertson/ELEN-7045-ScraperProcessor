package aps.infrastructure.persistence.hibernate;

import aps.domain.model.customer.Customer;
import aps.domain.model.customer.CustomerRepository;

import java.util.UUID;

/**
 * Hibernate implementation of CustomerRepository.
 */
public class CustomerRepositoryHibernate extends HibernateRepository implements CustomerRepository {

    @Override
    public Customer findCustomerById(UUID id) {
        return null;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        return false;
    }

    @Override
    public void updateCustomer(Customer customer) {

    }
}
