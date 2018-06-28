package aps;

import aps.application.IApsService;
import aps.application.impl.ApsServiceImpl;
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

        boolean inCorrectSelection = Boolean.TRUE;
        String username = null;
        String billingCompany = null;
        boolean scrapAllAccounts = Boolean.FALSE;

        //Simulate entering user details by providing option to select existing sample users
        while (inCorrectSelection) {

            System.out.println("Please enter number against APS userName from below:");
            System.out.println("1. Mike");
            System.out.println("2. Tim");
            System.out.println("3. Non-Existent");

            Scanner scanner = new Scanner(System.in);
            int usernameSelected = scanner.nextInt();

            if (usernameSelected == 1) {
                username = "Mike";
                inCorrectSelection = Boolean.FALSE;
            } else if (usernameSelected == 2) {
                username = "Tim";
                inCorrectSelection = Boolean.FALSE;
            } else if (usernameSelected == 3) {
                username = "Non-Existent";
                inCorrectSelection = Boolean.FALSE;
            }
        }

        //Not catering for authentication. Just using userName to retrieve customer details.
        System.out.println("Your APS userName is " + username);

        IApsService apsService = new ApsServiceImpl();
        Customer currentCustomer = null;

        try {
            currentCustomer = apsService.getCustomer(username);
        } catch (ApsException e) {
            System.out.println("Failed to find user " + username);
            System.out.println(e.getMessage());
        }

        int numberOfCustomerBillingCompanies = currentCustomer.getCustomerBillingAccounts().size();
        inCorrectSelection = Boolean.TRUE;

        System.out.println("");

        //Select the BillingCompany whose Statement you want to scrape.
        while (inCorrectSelection) {
            System.out.println("Please number against the Billing Account you want to scrape from the list below:");

            for (int count = 0; count < numberOfCustomerBillingCompanies; count++) {
                System.out.println(count + ". " + currentCustomer.getCustomerBillingAccounts().get(count).getBillingCompany().getName());
            }
            System.out.println(numberOfCustomerBillingCompanies + ". " + "All Billing Companies");

            Scanner scanner = new Scanner(System.in);
            int billingCompanySelected = scanner.nextInt();

            if (billingCompanySelected >= 0 && billingCompanySelected < numberOfCustomerBillingCompanies) {
                billingCompany = currentCustomer.getCustomerBillingAccounts().get(billingCompanySelected).getBillingCompany().getName();
                inCorrectSelection = Boolean.FALSE;
            } else if (billingCompanySelected == numberOfCustomerBillingCompanies) {
                scrapAllAccounts = Boolean.TRUE;
                inCorrectSelection = Boolean.FALSE;
            }
        }

        System.out.println("");

        if (scrapAllAccounts) {
            for (CustomerBillingAccount customerBillingAccount : currentCustomer.getCustomerBillingAccounts()) {
                apsService.scrapeWebsite(currentCustomer, customerBillingAccount.getBillingCompany().getName());
            }
        } else {
            String scrapeResult = apsService.scrapeWebsite(currentCustomer, billingCompany);
            System.out.println(scrapeResult);
        }

    }
}
