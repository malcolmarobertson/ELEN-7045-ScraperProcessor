package aps.domain.model.customer;

import aps.application.ICustomerService;
import aps.application.util.EncryptionUtility;
import aps.domain.exception.ApsException;

import java.util.UUID;

import static aps.domain.shared.ApplicationConstants.KEY;

public class CustomerFactory {

    ICustomerService customerService;

    private static UUID generateID() {
        return UUID.randomUUID();
    }

    public static Customer createCustomer(String name, String surname, String apsPassword) {
        //TODO: Create customer, add appropriate BillingCompany, with appropriate Statement and CompanyType.

        Customer customer = new Customer(generateID());
        customer.setFirstName(name);
        customer.setSurname(surname);

        //TODO: Add functionality to check for 5 encrypted fields under CustomerBillingAcount
        /*customerService = new CustomerServiceImpl();
        customerService.customerExceededMaxAllowedCredentialsForAccount();*/

        try {
            customer.setApsPassword(EncryptionUtility.encrypt(apsPassword, KEY));
        } catch (ApsException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
