package aps.domain.service;

import aps.domain.shared.ScrapeRequest;
import aps.domain.shared.ScrapeResponse;

public interface ScrapeService {
    public ScrapeResponse scrape(ScrapeRequest scrapeRequest);
}
