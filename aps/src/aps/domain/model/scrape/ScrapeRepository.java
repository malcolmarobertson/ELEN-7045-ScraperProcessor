package aps.domain.model.scrape;

public interface ScrapeRepository {

    public ScrapeObject findByBaseUrl(String baseUrl);

    public void save(ScrapeObject scrapeObject);

    public void delete(ScrapeObject scrapeObject);

    public void update(ScrapeObject scrapeObject);
}
