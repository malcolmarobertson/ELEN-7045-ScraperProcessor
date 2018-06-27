package aps.application.impl;

import aps.application.ICustomerService;
import aps.application.IScrapErrorService;
import aps.application.IScrapService;
import aps.application.util.ScrapeResult;
import aps.domain.exception.ApsException;
import aps.domain.model.customer.Customer;
import aps.domain.model.customer.CustomerBillingAccount;
import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.scrape.ScrapeRepository;
import aps.domain.model.statement.Statement;
import aps.domain.service.CustomerService;
import aps.domain.shared.ApplicationConstants;
import aps.domain.shared.GenericXmlParser;
import aps.domain.shared.ScrapeRequest;
import aps.domain.shared.ScrapeResponse;

public class CustomerServiceImpl implements ICustomerService {

    IScrapService scrapService;
    CustomerService customerService;
    IScrapErrorService scrapErrorService;
    ScrapeRepository scrapeRepository;

    @Override
    public void registerNewCustomer(Customer customer) {
        customerService.registerNewCustomer(customer);
    }

    @Override
    public Customer getCustomer(String username) throws ApsException {
        customerService = new CustomerService();
        Customer customer = customerService.getCustomer(username);
        return customer;
    }

    public String initiateScrape(Customer customer, String billingCompany) {
        scrapService = new ScrapServiceImpl();
        String scrapeResult = null;

        for (CustomerBillingAccount customerBillingAccount : customer.getCustomerBillingAccounts()) {
            if (customerBillingAccount.getBillingCompany().getName().equals(billingCompany)) {
                scrapeResult = scrapeWebsite(customerBillingAccount);
                Statement statement = customerBillingAccount.getBillingCompany().getStatement();
                break;
                //TODO: Map and validate the scrapeObject to the statement object.
            }
        }
        return scrapeResult;
    }

    public boolean customerExceededMaxAllowedCredentialsForAccount(CustomerBillingAccount customerBillingAccount) {
        boolean exceededMaxAllowedCredentials = Boolean.FALSE;
        //TODO: Add logic to determine this here.
        return exceededMaxAllowedCredentials;
    }

    private String scrapeWebsite(CustomerBillingAccount customerBillingAccount) {
        ScrapeRequest scrapeRequest = new ScrapeRequest();
        //Scraping for the first credential details.
        scrapeRequest.setUserIdentification(customerBillingAccount.getAccountCredentials().get(0).getUserName());
        scrapeRequest.setPassCode(customerBillingAccount.getAccountCredentials().get(0).getPassword());
        scrapeRequest.setBaseUrl(customerBillingAccount.getBillingCompany().getBaseUrl());
        scrapeRequest.setAccountNumber(customerBillingAccount.getAccountNumber());

        ScrapeResponse scrapeResponse = scrapService.scrapWebsite(scrapeRequest);

        ScrapeObject scrapeObject = null;
        if (scrapeResponse.getScrapeResult().equals(ScrapeResult.SUCCESSFUL)) {
            GenericXmlParser genericXmlParser = new GenericXmlParser(ScrapeObject.class);
            scrapeObject = (ScrapeObject) genericXmlParser.parseScrapXml(scrapeResponse.getXmlResponse());
        } else {
            scrapErrorService = new ScrapErrorServiceImpl();
            return scrapErrorService.handleScrapeError(scrapeResponse, customerBillingAccount);
        }
        return ApplicationConstants.SCRAP_SUCCESSFUL + scrapeObject.getBaseUrl();
    }
}
