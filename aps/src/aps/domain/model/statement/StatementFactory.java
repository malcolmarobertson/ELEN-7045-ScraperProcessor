package aps.domain.model.statement;

public class StatementFactory{

    public static Statement createStatement(StatementType statementType){
        switch (statementType){
            case TELECOMS:
                return new TelecommunicationServiceProviderStatement();
            case MUNICIPALITY:
                return new MunicipalityStatement();
            case CREDIT_CARD_PROVIDER:
                return new CreditCardStatement();
            default:
                return null;

        }
    }

}
