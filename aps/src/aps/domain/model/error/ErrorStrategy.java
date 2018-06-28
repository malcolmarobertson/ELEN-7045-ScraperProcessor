package aps.domain.model.error;

/**
 * Strategy Interface to be implemented by all errors, both from within APS and from the Scraper.
 */
public interface ErrorStrategy {
    public String handleError();

    public void saveError();
}
