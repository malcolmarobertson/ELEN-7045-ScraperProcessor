package aps.domain.model.scraperror;

public interface ScrapErrorRepository {
    
    public ScrapError findScrapErrorById(int id);

    public boolean addScrapError(ScrapError ScrapError);

    public boolean removeScrapError(ScrapError ScrapError);

    public void updateScrapError(ScrapError ScrapError);

}
