package aps.application;

import aps.domain.exception.ApsException;
import aps.domain.model.billingcompany.BillingCompany;
import aps.domain.model.customer.Customer;
import aps.domain.model.customer.CustomerBillingAccount;

/**
 * Class acts as a facade for all the APS processes or activities that can be performed from and interface.
 */
public interface IApsService {
    Customer getCustomer(String username) throws ApsException;
    public String scrapeWebsite(Customer customer, String billingCompany);
    public boolean addCustomerCredential(Customer customer, CustomerBillingAccount customerBillingAccount,
                                         String userName, String password);
    public void scheduleScapeDates(CustomerBillingAccount customerBillingAccount);
}
