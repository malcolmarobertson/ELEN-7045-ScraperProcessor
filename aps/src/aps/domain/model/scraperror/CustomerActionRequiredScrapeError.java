package aps.domain.model.scraperror;

import static aps.domain.shared.ApplicationConstants.CUSTOMER_ACTION_REQUIRED;

public class CustomerActionRequiredScrapeError implements ScrapeErrorStrategy {

    @Override
    public String handleScrapeError() {
        return CUSTOMER_ACTION_REQUIRED;
    }

    @Override
    public void saveScrapeError() {
    }
}
