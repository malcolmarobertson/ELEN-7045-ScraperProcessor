package aps.application;

import aps.domain.model.customer.CustomerBillingAccount;
import aps.domain.shared.ScrapeRequest;
import aps.domain.shared.ScrapeResponse;

public interface IScrapService {
    public ScrapeResponse scrapWebsite(ScrapeRequest scrapeRequest);

    public void editScrapScript();

    void scheduleScrapeDates(CustomerBillingAccount customerBillingAccount);
}
