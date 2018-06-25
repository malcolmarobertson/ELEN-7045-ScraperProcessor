package aps.domain.model.scraperror;

public class ScrapeErrorContext {
    private ScrapeErrorStrategy strategy;

    public void setScrapeErrorStrategy(ScrapeErrorStrategy strategy) {
        this.strategy = strategy;
    }

    //use the strategy
    public String handleScrapeError() {
        return strategy.handleScrapeError();
    }
}
