package aps.domain.model.scraperror;

import static aps.domain.shared.ApplicationConstants.ERROR_PAGE;

public class ErrorPageScrapeError implements ScrapeErrorStrategy {

    @Override
    public String handleScrapeError() {
        return ERROR_PAGE;
    }

    @Override
    public void saveScrapeError() {

    }
}
