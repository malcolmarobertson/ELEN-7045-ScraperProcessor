package aps.application;

import aps.domain.model.customer.CustomerBillingAccount;
import aps.domain.shared.ScrapeResponse;

public interface IScrapErrorService {

    String handleScrapeError(ScrapeResponse scrapeResponse, CustomerBillingAccount customerBillingAccount);
}
