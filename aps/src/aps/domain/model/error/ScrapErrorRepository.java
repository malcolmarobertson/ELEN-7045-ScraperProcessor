package aps.domain.model.error;

public interface ScrapErrorRepository {
    
    public ScrapeError findByBaseUrl(String baseUrl);

    public void save(ScrapeError ScrapeError);

    public void delete(ScrapeError ScrapeError);

    public void update(ScrapeError ScrapeError);

}
