package aps.domain.model.mapping;

import aps.domain.model.error.DataIntegrityConsistencyError;
import aps.domain.model.error.ErrorContext;
import aps.domain.model.scrape.DataPair;
import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.statement.Statement;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class GenericMapper {

    public abstract Statement generateStatement(ScrapeObject scrapeObject);

    protected Statement mapScrapObject(Statement statement, ScrapeObject scrapeObject) {

        for (DataPair dataPair : scrapeObject.getDataPairs()) {
            try {
                mapDataPair(statement, dataPair);
            } catch (NumberFormatException | ParseException e) {
                ErrorContext errorContext = new ErrorContext();
                errorContext.setScrapeStrategy(new DataIntegrityConsistencyError());
                errorContext.handleError();
            }
        }
        return statement;
    }

    protected abstract Statement mapDataPair(Statement statement, DataPair dataPair) throws NumberFormatException, ParseException;

    /**
     * Provides a generic method to map Currency values, but a specific currency can be mapped in the respective mapper e.g. CreditCardProviderMapper.
     */
    BigDecimal mapCurrencyValue(String currencyString, String currencyCharacter) {
        String strippedCurrencyValue = currencyString.replace(currencyCharacter, "");
        return new BigDecimal(strippedCurrencyValue);
    }

    int mapIntegerField(String integerString) throws NumberFormatException {
        return Integer.parseInt(integerString);
    }

    Date mapDateField(String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.parse(dateString);
    }

}
