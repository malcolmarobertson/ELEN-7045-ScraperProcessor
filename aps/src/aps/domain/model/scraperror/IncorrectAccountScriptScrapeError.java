package aps.domain.model.scraperror;

import static aps.domain.shared.ApplicationConstants.BROKEN_SCRIPT;
import static aps.domain.shared.ApplicationConstants.INCORRECT_ACCOUNT;

public class IncorrectAccountScriptScrapeError implements ScrapeErrorStrategy {

    @Override
    public String handleScrapeError() {
        return INCORRECT_ACCOUNT;
    }

    @Override
    public void saveScrapeError() {

    }
}
