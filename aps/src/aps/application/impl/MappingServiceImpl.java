package aps.application.impl;

import aps.application.IMappingService;
import aps.application.util.XmlFileReader;
import aps.domain.model.scrape.DataPair;
import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.statement.MunicipalityStatement;
import aps.domain.shared.ApsMaps;
import aps.domain.shared.GenericXmlParser;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.reflect.Field;


public class MappingServiceImpl implements IMappingService {

    public ApsMaps getMaps () {


        String xmlApsMaps = XmlFileReader.readFile("src/resources/domain/aps-maps.xml");

        GenericXmlParser genericXmlParser = new GenericXmlParser(ApsMaps.class);

        ApsMaps apsMaps = (ApsMaps) genericXmlParser.parseScrapXml(xmlApsMaps);

        return apsMaps;

    }

    public ScrapeObject createMappedObject (ScrapeObject inObject) {

        ApsMaps apsMaps = getMaps();
        ScrapeObject mappedObject = new ScrapeObject();
        mappedObject.setBaseUrl(inObject.getBaseUrl());
        mappedObject.setCustomerSurname(inObject.getCustomerSurname());
        mappedObject.setCustomerName(inObject.getCustomerName());
        mappedObject.setDate(inObject.getDate());

        List<DataPair> dps = new ArrayList<DataPair>();

        inObject.getDataPairs().forEach(dp -> {
            apsMaps.getStandardMaps().forEach(sp -> {
                if (dp.getText().contains(sp.getLabel()))
                    dp.setText(sp.getInternalLabel());
            });
            apsMaps.getMunicipMaps().forEach(mp -> {
                if (dp.getText().contains(mp.getLabel()))
                    dp.setText(mp.getInternalLabel());
            });
            dps.add(dp);
        });

        mappedObject.setDataPairs(dps);

        return mappedObject;
    }


    //https://stackoverflow.com/questions/37654782/how-to-understand-that-field-is-number

    private final static Set<Class<?>> NUMBER_REFLECTED_PRIMITIVES;
    static {
        Set<Class<?>> s = new HashSet<>();
        s.add(int.class);
        s.add(BigDecimal.class);
        NUMBER_REFLECTED_PRIMITIVES = s;
    }

    public static boolean isReflectedAsNumber(Class<?> type) {
        return Number.class.isAssignableFrom(type) || NUMBER_REFLECTED_PRIMITIVES.contains(type);
    }


    public int createStatementFromScrapeObject(ScrapeObject inObject) {

        //TODO: need to decide how billingCompanyType gets here

        MunicipalityStatement mStatement = new MunicipalityStatement();

        //Field[] fs = MunicipalityStatement.class.getSuperclass().getDeclaredFields();

        inObject.getDataPairs().forEach(dp -> {
            System.out.println(dp.getText() + " " + dp.getValue());

            Field declaredField =  null;

            try {
                declaredField = MunicipalityStatement.class.getField(dp.getText());
                declaredField.setAccessible(true);
                if (isReflectedAsNumber(declaredField.getType())) {
                    try {
                        if (declaredField.getType().equals(int.class))
                            declaredField.set(mStatement, Integer.parseInt(dp.getValue()));
                        else
                            declaredField.set(mStatement, BigDecimal.class.cast(dp.getValue()));
                    } catch (ClassCastException e) {
                        System.out.println("Error Parsing Number: " + inObject.getBaseUrl()
                                + " " + inObject.getCustomerSurname()
                                + " " + inObject.getDate()
                                + " " + inObject.getTime()
                                + " " + dp.getText()
                                + " " + dp.getValue());
                    }
                } else
                    declaredField.set(mStatement, dp.getValue());
            } catch (NoSuchFieldException
                    | SecurityException
                    | IllegalAccessException
                    e) {
                System.out.println("Field not found: " + inObject.getBaseUrl()
                        + " " + inObject.getCustomerSurname()
                        +  " " + inObject.getDate()
                        +  " " + inObject.getTime()
                        +  " " + dp.getText());
            }
        });



        System.out.println("Writing Statement to Storage: "
                + mStatement.getStatementNumber() + " "
                + mStatement.getAccountNumber() + " "
                + mStatement.getElectricityUsed());

        return 0;
    }



}
