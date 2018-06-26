package aps.domain.model.customer;

import aps.domain.model.billingcompany.BillingCompanyFactory;

public class CustomerBillingAccountFactory {
    public static CustomerBillingAccount createCustomerAccountFactory(){
        CustomerBillingAccount customerBillingAccount = new CustomerBillingAccount();
        return customerBillingAccount;
    }
}
