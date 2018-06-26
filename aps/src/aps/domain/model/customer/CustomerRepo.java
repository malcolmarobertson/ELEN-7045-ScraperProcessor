package aps.domain.model.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerRepo implements CustomerRepository{

    private List<Customer> customers = new ArrayList<>();

    @Override
    public Customer findCustomerById(UUID id) {
        for (Customer customer: customers){
            if(customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if(customers.contains(customer)){
            return false;
        }
        customers.add(customer);
        return true;
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        if(customers.contains(customer)){
            customers.remove(customer);
            return true;
        }
        return false;
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (customers.contains(customer)){
            customers.set(customers.indexOf(customer),customer);
        }
    }
}
