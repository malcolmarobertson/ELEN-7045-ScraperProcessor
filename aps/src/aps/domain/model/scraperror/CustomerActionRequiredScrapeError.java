package aps.domain.model.scraperror;

public class CustomerActionRequiredScrapeError implements ScrapeErrorStrategy {

    @Override
    public String handleScrapeError() {
        return null;
    }

    @Override
    public void saveScrapeError() {

    }
}
