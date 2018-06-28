package aps.domain.model.mapping;

import aps.domain.model.scrape.DataPair;
import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.statement.CreditCardStatement;
import aps.domain.model.statement.Statement;

import java.text.ParseException;

/**
 * Class to map Scrape information for a Municipality to a Statement.
 */
public class CreditCardProviderMapper extends GenericMapper {

    private static final String currencyCharacter = "R";

    @Override
    public Statement generateStatement(ScrapeObject scrapeObject) {
        CreditCardStatement creditCardStatement = new CreditCardStatement();
        return mapScrapObject(creditCardStatement, scrapeObject);
    }

    @Override
    protected Statement mapDataPair(Statement statement, DataPair dataPair) throws NumberFormatException, ParseException {
        CreditCardStatement creditCardStatement = (CreditCardStatement) statement;

        if (dataPair.getText().equals("Account Number")) {
            creditCardStatement.setAccountNumber(dataPair.getValue());
        }

        if (dataPair.getText().equals("Reference")) {
            creditCardStatement.setStatementNumber(dataPair.getValue());
        }

        if (dataPair.getText().equals("Opening Balance")) {
            creditCardStatement.setOpeningBalance(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Closing Balance")) {
            creditCardStatement.setClosingBalance(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Previous Invoice")) {
            creditCardStatement.setClosingBalance(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Payment Received")) {
            creditCardStatement.setPaymentReceived(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Statement Date")) {
            creditCardStatement.setStatementDate(dataPair.getValue());
        }

        if (dataPair.getText().equals("Statement Month")) {
            creditCardStatement.setMonth(dataPair.getValue());
        }

        if (dataPair.getText().equals("Total")) {
            creditCardStatement.setTotalDue(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Account Name")) {
            creditCardStatement.setAccountHolderName(dataPair.getValue());
        }

        if (dataPair.getText().equals("Due Date")) {
            creditCardStatement.setDueDate(mapDateField(dataPair.getValue()));
        }

        if (dataPair.getText().equals("New Charges")) {
            creditCardStatement.setNewCharges(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Card type")) {
            creditCardStatement.setCardType(dataPair.getValue());
        }

        if (dataPair.getText().equals("Credit limit")) {
            creditCardStatement.setCreditLimit(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Credit available")) {
            creditCardStatement.setCreditAvailable(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }
        return creditCardStatement;
    }
}
