package aps.infrastructure.persistence.hibernate;

import aps.domain.model.scraperror.ScrapError;
import aps.domain.model.scraperror.ScrapErrorRepository;

/**
 * Hibernate implementation of ScrapErrorRepository.
 */
public class ScrapErrorRepositoryHibernate extends HibernateRepository implements ScrapErrorRepository {

    @Override
    public ScrapError findScrapErrorById(int id) {
        return null;
    }

    @Override
    public boolean addScrapError(ScrapError ScrapError) {
        return false;
    }

    @Override
    public boolean removeScrapError(ScrapError ScrapError) {
        return false;
    }

    @Override
    public void updateScrapError(ScrapError ScrapError) {

    }
}
