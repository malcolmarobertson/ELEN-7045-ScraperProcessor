package aps.infrastructure.persistence.hibernate;

import aps.domain.model.statement.Statement;
import aps.domain.model.statement.StatementRepository;

/**
 * Hibernate implementation of StatementRepository.
 */
public class StatementRepositoryHibernate extends HibernateRepository implements StatementRepository {

    @Override
    public Statement findStatementById(int id) {
        return null;
    }

    @Override
    public boolean addStatement(Statement statement) {
        return false;
    }

    @Override
    public boolean removeStatement(Statement statement) {
        return false;
    }

    @Override
    public void updateStatement(Statement statement) {

    }
}
