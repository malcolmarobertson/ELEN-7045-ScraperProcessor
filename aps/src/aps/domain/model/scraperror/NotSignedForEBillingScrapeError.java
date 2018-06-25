package aps.domain.model.scraperror;

public class NotSignedForEBillingScrapeError implements ScrapeErrorStrategy {

    @Override
    public String handleScrapeError() {
        return null;
    }

    @Override
    public void saveScrapeError() {

    }
}
