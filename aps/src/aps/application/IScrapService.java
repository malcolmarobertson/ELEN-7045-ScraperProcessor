package aps.application;

import aps.domain.model.scrape.ScrapeObject;
import aps.domain.shared.ScrapeRequest;

public interface IScrapService {
    public ScrapeObject scrapWebsite(ScrapeRequest scrapeRequest);

    public void editScrapScript();
}
