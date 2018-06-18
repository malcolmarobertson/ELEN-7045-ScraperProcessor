package aps.application;

import aps.domain.shared.ScrapRequest;
import aps.domain.shared.ScrapResponse;

public interface IScrapService {
    public ScrapResponse scrapWebsite(ScrapRequest scrapRequest);

    public void editScrapScript();
}
