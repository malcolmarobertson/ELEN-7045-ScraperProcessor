package aps.domain.model.error;

/**
 * ErrorContext to be used for all errors, both from within APS and from the Scraper.
 */
public class ErrorContext {
    private ErrorStrategy strategy;

    public void setScrapeStrategy(ErrorStrategy strategy) {
        this.strategy = strategy;
    }

    //use the strategy
    public String handleError() {
        return strategy.handleError();
    }
}
