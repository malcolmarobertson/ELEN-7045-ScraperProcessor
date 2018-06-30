package aps.domain.model.mapping;

import aps.domain.model.scrape.DataPair;
import aps.domain.model.scrape.DataPairs;
import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.statement.Statement;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CreditCardProviderMapperTest {

    CreditCardProviderMapper ccMapper;
    ScrapeObject sO;

    private ScrapeObject testScrapeObject() {
        ScrapeObject scrapeObject = new ScrapeObject();
        scrapeObject.setBaseUrl("www.telkom.co.za");
        scrapeObject.setDate("01/01/2018");
        scrapeObject.setTime("13:50:00");

        DataPairs dataPairs = new DataPairs();
        List<DataPair> dataPairList = new ArrayList<>();
        DataPair dataPair = new DataPair();
        dataPair.setText("Account number");
        dataPair.setValue("TEST_CC_ACC_NO");
        dataPairList.add(dataPair);
        dataPair.setText("Credit limit");
        dataPair.setValue("999.99");
        dataPairList.add(dataPair);
        scrapeObject.setDataPairs(dataPairList);

        return scrapeObject;
    }

    @Before
    public void init() {
        ccMapper = new CreditCardProviderMapper();
        sO = testScrapeObject();
    }

    @Test
    public void testStatementClassMapping() {
        Statement ccStatement = ccMapper.generateStatement(sO);

        assertEquals(ccStatement.accountNumber, sO.getDataPairs().get(0).getValue());
    }


    @Test
    public void testCreditCardClassMapping() {
        Statement ccStatement = ccMapper.generateStatement(sO);

        //fails cannot access sub-class fields/methods
        //assertEquals(ccStatement.getCreditLimit(), sO.getDataPairs().get(0).getValue());
        throw new UnsupportedOperationException("Test Failing - cannot access sub-class fields/methods");
    }

    @Test
    public void testMapInteger() {
        int testInt = ccMapper.mapIntegerField("0");
        assertEquals(0, testInt);

        testInt = ccMapper.mapIntegerField("2147483647");
        assertEquals(2147483647, testInt);

        testInt = ccMapper.mapIntegerField("-2147483648");
        assertEquals(-2147483648, testInt);

        //what happens in this case? should the error handler catch this?
        testInt = ccMapper.mapIntegerField("S");
    }

    @Test
    public void testMapCurrency() {
        BigDecimal testCurrency = ccMapper.mapCurrencyValue("R0.01", "R");
        assertEquals(new BigDecimal(0.01).stripTrailingZeros(), testCurrency);

        testCurrency = ccMapper.mapCurrencyValue("2147483647", "R");
        assertEquals(2147483647, testCurrency);

        testCurrency = ccMapper.mapCurrencyValue("-2147483648", "R");
        assertEquals(-2147483648, testCurrency);

        //what happens in this case? should the error handler catch this?
        testCurrency = ccMapper.mapCurrencyValue("R", "R");
    }

    @Test
    public void mapDataPair() {
    }
}