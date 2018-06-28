package aps.domain.model.mapping;

import aps.domain.model.scrape.DataPair;
import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.statement.Statement;
import aps.domain.model.statement.TelecommunicationServiceProviderStatement;

import java.text.ParseException;

/**
 * Class to map Scrape information for a Telecommunication Service Provider to a Statement.
 */
public class TelecomsMapper extends GenericMapper {

    private static final String currencyCharacter = "R";


    @Override
    public Statement generateStatement(ScrapeObject scrapeObject) {
        TelecommunicationServiceProviderStatement telecommunicationServiceProviderStatement = new TelecommunicationServiceProviderStatement();
        return mapScrapObject(telecommunicationServiceProviderStatement, scrapeObject);
    }


    @Override
    protected Statement mapDataPair(Statement statement, DataPair dataPair) throws NumberFormatException, ParseException {
        TelecommunicationServiceProviderStatement telecommunicationStatement = (TelecommunicationServiceProviderStatement) statement;

        if (dataPair.getText().equals("New Charges")) {
            telecommunicationStatement.setNewCharges(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Call charges")) {
            telecommunicationStatement.setCallCharges(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }
        if (dataPair.getText().equals("Opening Balance")) {
            telecommunicationStatement.setOpeningBalance(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Closing Balance")) {
            telecommunicationStatement.setClosingBalance(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Previous Invoice")) {
            telecommunicationStatement.setClosingBalance(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Payment")) {
            telecommunicationStatement.setPaymentReceived(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Total number of calls")) {
            telecommunicationStatement.setTotalNumberOfCalls(mapIntegerField(dataPair.getValue()));
        }

        if (dataPair.getText().equals("Total call duration")) {
            telecommunicationStatement.setTotalNumberOfCalls(mapIntegerField(dataPair.getValue()));
        }
        if (dataPair.getText().equals("Total Owed")) {
            telecommunicationStatement.setTotalDue(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Payment Due Date")) {
            telecommunicationStatement.setDueDate(mapDateField(dataPair.getValue()));
        }

        if (dataPair.getText().equals("Account no")) {
            telecommunicationStatement.setAccountNumber(dataPair.getValue());
        }

        if (dataPair.getText().equals("Service ref")) {
            telecommunicationStatement.setStatementNumber(dataPair.getValue());
        }

        if (dataPair.getText().equals("Service ref")) {
            telecommunicationStatement.setTelephoneNumber(dataPair.getValue());
        }


        if (dataPair.getText().equals("Date")) {
            telecommunicationStatement.setStatementDate(dataPair.getValue());
        }

        if (dataPair.getText().equals("Month")) {
            telecommunicationStatement.setMonth(dataPair.getValue());
        }

        if (dataPair.getText().equals("Account Name")) {
            telecommunicationStatement.setAccountHolderName(dataPair.getValue());
        }
        return telecommunicationStatement;
    }
}
