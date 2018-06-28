package aps.domain.model.statement;

import static aps.domain.shared.ApplicationConstants.CREDIT_CARD_PROVIDER_BILLING_COMPANY_TYPE;
import static aps.domain.shared.ApplicationConstants.MUNICIPALITY_BILLING_COMPANY_TYPE;
import static aps.domain.shared.ApplicationConstants.TELECOMS_BILLING_COMPANY_TYPE;

public class StatementFactory {

    public static Statement createStatement(String statementType) {
        switch (statementType) {
            case TELECOMS_BILLING_COMPANY_TYPE:
                return new TelecommunicationServiceProviderStatement();
            case MUNICIPALITY_BILLING_COMPANY_TYPE:
                return new MunicipalityStatement();
            case CREDIT_CARD_PROVIDER_BILLING_COMPANY_TYPE:
                return new CreditCardStatement();
            default:
                return null;

        }
    }

}
