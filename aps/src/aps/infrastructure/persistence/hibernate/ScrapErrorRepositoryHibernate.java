package aps.infrastructure.persistence.hibernate;

import aps.domain.model.scraperror.ScrapeError;
import aps.domain.model.scraperror.ScrapErrorRepository;

/**
 * Hibernate implementation of ScrapErrorRepository.
 */
public class ScrapErrorRepositoryHibernate extends HibernateRepository implements ScrapErrorRepository {

    @Override
    public ScrapeError findScrapErrorById(int id) {
        return null;
    }

    @Override
    public boolean addScrapError(ScrapeError ScrapeError) {
        return false;
    }

    @Override
    public boolean removeScrapError(ScrapeError ScrapeError) {
        return false;
    }

    @Override
    public void updateScrapError(ScrapeError ScrapeError) {

    }
}
