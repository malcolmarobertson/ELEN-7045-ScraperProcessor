package aps.domain.model.scraperror;

import static aps.domain.shared.ApplicationConstants.SITE_DOWN;

public class SiteDownScrapeError implements ScrapeErrorStrategy {

    @Override
    public String handleScrapeError() {
        return SITE_DOWN;
    }

    @Override
    public void saveScrapeError() {

    }
}
