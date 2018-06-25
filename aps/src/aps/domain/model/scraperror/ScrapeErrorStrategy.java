package aps.domain.model.scraperror;

public interface ScrapeErrorStrategy {
    public String handleScrapeError();

    public void saveScrapeError();
}
