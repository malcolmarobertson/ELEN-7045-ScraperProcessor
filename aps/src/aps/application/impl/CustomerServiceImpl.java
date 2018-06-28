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

    CustomerService customerService;


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
}
