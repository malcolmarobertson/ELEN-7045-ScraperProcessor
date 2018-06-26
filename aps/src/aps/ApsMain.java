package aps;

import aps.application.ICustomerService;
import aps.application.impl.CustomerServiceImpl;
import aps.domain.exception.ApsException;
import aps.domain.model.customer.Customer;
import aps.domain.model.customer.CustomerBillingAccount;

import java.util.Scanner;

/**
 * User Mike has valid scrap responses.
 * User Tim has invalid scrap responses.
 * Not catering for authentication.
 */
public class ApsMain {

    public static void main(String[] args) {
        System.out.println("Please enter your APS userName:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Your APS userName is " + username);
        //Not catering for authentication. Just using userName to retrieve customer details.

        ICustomerService customerService = new CustomerServiceImpl();
        Customer currentCustomer = null;

        try {
            currentCustomer = customerService.getCustomer(username);
        } catch (ApsException e) {
            System.out.println("Failed to get user " + username);
            System.out.println(e.getMessage());
        }

        System.out.println("Please select the Billing Account you want to scrape from the list below:");
        for (CustomerBillingAccount customerBillingAccount : currentCustomer.getCustomerBillingAccounts()) {
            System.out.println(customerBillingAccount.getBillingCompany().getName());
        }

        String billingCompany = scanner.nextLine();

        /*for (CustomerBillingAccount customerBillingAccount : currentCustomer.getCustomerBillingAccounts()) {
            System.out.println(customerBillingAccount.getBillingCompany().getName());
            if (!billingCompany.equals(customerBillingAccount.getBillingCompany().getName())){
            }
        }*/

        String scrapeResult = ((CustomerServiceImpl) customerService).initiateScrape(currentCustomer, billingCompany);
        System.out.println(scrapeResult);
    }
}
