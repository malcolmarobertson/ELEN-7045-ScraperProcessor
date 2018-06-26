package aps.domain.model.scraperror;

import static aps.domain.shared.ApplicationConstants.BROKEN_SCRIPT;
import static aps.domain.shared.ApplicationConstants.DATA_INTEGRITY_CONSISTENCY;

public class DataIntegrityConsistencyScrapeError implements ScrapeErrorStrategy {

    @Override
    public String handleScrapeError() {
        return DATA_INTEGRITY_CONSISTENCY;
    }

    @Override
    public void saveScrapeError() {

    }
}
