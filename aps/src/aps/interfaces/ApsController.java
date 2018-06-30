package aps.interfaces;

import aps.application.IApsService;
import aps.domain.exception.ApsException;
import aps.domain.model.customer.Customer;
import aps.domain.model.customer.CustomerBillingAccount;

/**
 *
 */
public class ApsController {

    public IApsService apsService;

    public ApsController(IApsService apsService) {
        this.apsService = apsService;
    }

    Customer getCustomer(String username) throws ApsException {
        return apsService.getCustomer(username);
    }

    public String scrapeWebsite(Customer customer, String billingCompany) {
        return apsService.scrapeWebsite(customer, billingCompany);
    }

    public boolean addCustomerCredential(Customer customer, CustomerBillingAccount customerBillingAccount,
                                         String userName, String password) {
        return apsService.addCustomerCredential(customer, customerBillingAccount, userName, password);
    }

    public void scheduleScapeDates(CustomerBillingAccount customerBillingAccount) {
        apsService.scheduleScapeDates(customerBillingAccount);
    }
}
