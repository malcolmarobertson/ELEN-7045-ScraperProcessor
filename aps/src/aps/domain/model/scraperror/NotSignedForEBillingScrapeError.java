package aps.domain.model.scraperror;

import static aps.domain.shared.ApplicationConstants.NOT_SIGNED_FOR_EBILLING;

public class NotSignedForEBillingScrapeError implements ScrapeErrorStrategy {

    @Override
    public String handleScrapeError() {
        return NOT_SIGNED_FOR_EBILLING;
    }

    @Override
    public void saveScrapeError() {

    }
}
