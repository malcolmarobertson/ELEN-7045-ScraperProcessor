package aps.domain.model.customer;

public class CustomerFactory {
    public Customer createCustomer(String name, String surname) {
        //TODO: Create customer, add appropriate BillingCompany, with appropriate Statement and CompanyType.
        Customer customer = new Customer();
        customer.setFirstName(name);
        customer.setSurname(surname);
        return customer;
    }
}
