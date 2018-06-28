package aps.application.impl;

import aps.application.IStatementService;
import aps.domain.model.statement.Statement;
import aps.domain.model.statement.StatementRepository;
import aps.infrastructure.persistence.hibernate.StatementRepositoryHibernate;

public class StatementServiceImpl implements IStatementService {

    StatementRepository statementRepository = new StatementRepositoryHibernate();

    @Override
    public Statement findById(int id) {
        return statementRepository.findById(id);
    }

    @Override
    public void add(Statement statement) {
        statementRepository.add(statement);
    }

    @Override
    public void delete(Statement statement) {
        statementRepository.delete(statement);
    }

    @Override
    public void update(Statement statement) {
        statementRepository.update(statement);
    }
}
