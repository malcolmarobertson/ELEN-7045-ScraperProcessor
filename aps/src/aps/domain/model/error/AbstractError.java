package aps.domain.model.error;

import aps.infrastructure.persistence.hibernate.ErrorRepositoryHibernate;

public abstract class AbstractError implements ErrorStrategy {
    ErrorRepository errorRepository = new ErrorRepositoryHibernate();

    public abstract String handleError();

    public void logError(String xmlErrorString) {
        errorRepository.logError(xmlErrorString);
    }
}
