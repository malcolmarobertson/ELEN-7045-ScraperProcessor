package aps.domain.model.scraperror;

import static aps.domain.shared.ApplicationConstants.BROKEN_SCRIPT;
import static aps.domain.shared.ApplicationConstants.DATA_INTEGRITY;

public class DataIntegrityScrapeError implements ScrapeErrorStrategy {

    @Override
    public String handleScrapeError() {
        return DATA_INTEGRITY;
    }

    @Override
    public void saveScrapeError() {

    }
}
