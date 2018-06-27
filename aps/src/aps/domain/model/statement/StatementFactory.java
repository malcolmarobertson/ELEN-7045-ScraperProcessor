package aps.domain.model.statement;

public class StatementFactory{

    public static Statement createMunicipalityStatement(){
        return new MunicipalityStatement();
    }

    public static Statement createCredidCardStatement(){
        return new CreditCardStatement();
    }

    public static Statement createTelcommunicationStatemenr(){
        return new TelecommunicationServiceProviderStatement();
    }

}
