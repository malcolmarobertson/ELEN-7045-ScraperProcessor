package aps.domain.service;

import aps.application.ICustomerService;
import aps.domain.model.customer.Customer;
import aps.domain.model.customer.CustomerBillingAccount;

public class CustomerService {
    public static final Integer MAX_NUMBER_OF_CREDENTIALS = 5;

    public boolean customerExceededMaxAllowedCredentialsForAccount(Customer customer, CustomerBillingAccount customerBillingAccount) {
        boolean exceededMaxAllowedCredentials = Boolean.FALSE;
        //TODO: Add logic to determine this here.
        return exceededMaxAllowedCredentials;
    }
}
