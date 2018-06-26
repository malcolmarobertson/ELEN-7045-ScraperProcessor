package aps.domain.model.scraperror;

import static aps.domain.shared.ApplicationConstants.BROKEN_SCRIPT;

public class BrokenScriptScrapeError implements ScrapeErrorStrategy {

    @Override
    public String handleScrapeError() {
        //TODO: Handle Site Changed and Encountered Unhandled Data Condition Errors differently.
        return BROKEN_SCRIPT;
    }

    @Override
    public void saveScrapeError() {

    }
}
