package aps.application.impl;

import aps.application.IScrapService;
import aps.domain.shared.ScrapRequest;
import aps.domain.shared.ScrapResponse;

/**
 * This is the class that mimics the module that performs the actual scrapping. It is linked to the Scrapping Component of the
 * system.
 */
public class ScrapServiceImpl implements IScrapService {
    @Override
    public ScrapResponse scrapWebsite(ScrapRequest scrapRequest) {
        //TODO: To stub the implementation for Demo purposes.
        return null;
    }

    @Override
    public void editScrapScript() {
    }
}
