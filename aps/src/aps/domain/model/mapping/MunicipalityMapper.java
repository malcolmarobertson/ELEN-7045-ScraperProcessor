package aps.domain.model.mapping;

import aps.domain.model.scrape.DataPair;
import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.error.ErrorContext;
import aps.domain.model.statement.MunicipalityStatement;
import aps.domain.model.statement.Statement;

import java.text.ParseException;

/**
 * Class to map Scrape information for a Municipality to a Statement.
 */
public class MunicipalityMapper extends GenericMapper {

    private static final String currencyCharacter = "R";

    @Override
    public Statement generateStatement(ScrapeObject scrapeObject) {
        MunicipalityStatement municipalityStatement = new MunicipalityStatement();
        return mapScrapObject(municipalityStatement, scrapeObject);
    }

    @Override
    protected Statement mapDataPair(Statement statement, DataPair dataPair) throws NumberFormatException, ParseException {
        MunicipalityStatement municipalityStatement = (MunicipalityStatement) statement;

        if (dataPair.getText().equals("Opening Balance")) {
            municipalityStatement.setOpeningBalance(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Closing Balance")) {
            municipalityStatement.setClosingBalance(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Previous Invoice")) {
            municipalityStatement.setClosingBalance(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Payment")) {
            municipalityStatement.setPaymentReceived(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Total Owed")) {
            municipalityStatement.setTotalDue(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("New Charges")) {
            municipalityStatement.setNewCharges(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Electricity charges")) {
            municipalityStatement.setElectricityCharges(mapCurrencyValue(dataPair.getValue(), currencyCharacter));
        }

        if (dataPair.getText().equals("Electricity used")) {
            municipalityStatement.setElectricityUsed(mapIntegerField(dataPair.getValue()));
        }

        if (dataPair.getText().equals("Instalment notice")) {
            municipalityStatement.setInstalmentNotice(mapIntegerField(dataPair.getValue()));
        }

        if (dataPair.getText().equals("Date")) {
            municipalityStatement.setStatementDate(dataPair.getValue());
        }

        if (dataPair.getText().equals("Due Date")) {
            municipalityStatement.setDueDate(mapDateField(dataPair.getValue()));
        }

        if (dataPair.getText().equals("Account no")) {
            municipalityStatement.setAccountNumber(dataPair.getValue());
        }

        if (dataPair.getText().equals("Service ref")) {
            municipalityStatement.setStatementNumber(dataPair.getValue());
        }

        if (dataPair.getText().equals("Month")) {
            municipalityStatement.setMonth(dataPair.getValue());
        }

        if (dataPair.getText().equals("Account Name")) {
            municipalityStatement.setAccountHolderName(dataPair.getValue());
        }
        return municipalityStatement;
    }
}
