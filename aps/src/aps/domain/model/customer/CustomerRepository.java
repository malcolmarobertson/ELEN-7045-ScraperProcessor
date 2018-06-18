package aps.domain.model.customer;

public interface CustomerRepository {

    public Customer findCustomerById(int id);

    public boolean addCustomer(Customer customer);

    public boolean removeCustomer(Customer customer);

    public void updateCustomer(Customer customer);
}
