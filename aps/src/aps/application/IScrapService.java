package aps.application;

import aps.domain.shared.ScrapeRequest;
import aps.domain.shared.ScrapeResponse;

public interface IScrapService {
    public ScrapeResponse scrapWebsite(ScrapeRequest scrapeRequest);

    public void editScrapScript();
}
