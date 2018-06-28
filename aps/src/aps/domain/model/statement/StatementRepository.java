package aps.domain.model.statement;

public interface StatementRepository {

    public Statement findById(int id);

    public void add(Statement customer);

    public void delete(Statement customer);

    public void update(Statement customer);

}
