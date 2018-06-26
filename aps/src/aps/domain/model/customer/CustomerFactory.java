package aps.domain.model.customer;

import java.util.UUID;

public class CustomerFactory {
    private static UUID generateID(){
        return UUID.randomUUID();
    }
    public static Customer createCustomer(String name, String surname) {
        //TODO: Create customer, add appropriate BillingCompany, with appropriate Statement and CompanyType.
        Customer customer = new Customer(generateID());
        customer.setFirstName(name);
        customer.setSurname(surname);
        return customer;
    }
}
