package aps.domain.model.scraperror;

import static aps.domain.shared.ApplicationConstants.INVALID_CREDENTIALS;

public class InvalidCredentialsScrapeError implements ScrapeErrorStrategy {

    @Override
    public String handleScrapeError() {
        return INVALID_CREDENTIALS;
    }

    @Override
    public void saveScrapeError() {

    }
}
