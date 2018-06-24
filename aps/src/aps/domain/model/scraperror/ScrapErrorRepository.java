package aps.domain.model.scraperror;

public interface ScrapErrorRepository {
    
    public ScrapeError findScrapErrorById(int id);

    public boolean addScrapError(ScrapeError ScrapeError);

    public boolean removeScrapError(ScrapeError ScrapeError);

    public void updateScrapError(ScrapeError ScrapeError);

}
