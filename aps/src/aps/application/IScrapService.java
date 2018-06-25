package aps.application;

import aps.domain.model.scrape.ScrapeObject;
import aps.domain.shared.ScrapeRequest;

public interface IScrapService {
    public String scrapWebsite(ScrapeRequest scrapeRequest);

    public void editScrapScript();
}
