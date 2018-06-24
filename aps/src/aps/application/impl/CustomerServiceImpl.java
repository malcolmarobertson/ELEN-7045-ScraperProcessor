package aps.application.impl;

import aps.application.ICustomerService;
import aps.application.IScrapService;
import aps.application.IStatement;
import aps.domain.model.customer.Customer;
import aps.domain.model.customer.CustomerBillingAccount;
import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.statement.Statement;
import aps.domain.shared.ScrapeRequest;

public class CustomerServiceImpl implements ICustomerService {

    IScrapService scrapService;

    @Override
    public void registerNewCustomer(Customer customer) {

    }

    @Override
    public Customer getCustomer(String username) {
        return null;
    }

    public void initiateScrape(Customer customer) {
        scrapService = new ScrapServiceImpl();

        for (CustomerBillingAccount customerBillingAccount : customer.getCustomerBillingAccounts()) {
            ScrapeObject scrapeObject = scrapeWebsite(customerBillingAccount);
            Statement statement = customerBillingAccount.getBillingCompany().getStatement();
            //TODO: Map and validate the scrapeObject to the statement object.
        }
    }

    private ScrapeObject scrapeWebsite(CustomerBillingAccount customerBillingAccount) {
        ScrapeRequest scrapeRequest = new ScrapeRequest();
        //Scraping for the first credential details.
        scrapeRequest.setUserIdentification(customerBillingAccount.getAccountCredentials().get(0).getUserName());
        scrapeRequest.setPassCode(customerBillingAccount.getAccountCredentials().get(0).getPassword());
        scrapeRequest.setWebsiteUrl(customerBillingAccount.getBillingCompany().getBaseUrl());
        ScrapeObject scrapeObject = scrapService.scrapWebsite(scrapeRequest);
        return scrapeObject;
    }
}
