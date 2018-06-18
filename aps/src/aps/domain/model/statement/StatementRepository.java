package aps.domain.model.statement;

public interface StatementRepository {

    public Statement findStatementById(int id);

    public boolean addStatement(Statement customer);

    public boolean removeStatement(Statement customer);

    public void updateStatement(Statement customer);

}
