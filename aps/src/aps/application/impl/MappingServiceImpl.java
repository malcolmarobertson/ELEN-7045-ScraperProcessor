package aps.application.impl;

import aps.application.IMappingService;
import aps.application.util.XmlFileReader;
import aps.domain.model.scrape.DataPair;
import aps.domain.model.scrape.ScrapeObject;
import aps.domain.model.statement.MunicipalityStatement;
import aps.domain.model.statement.Statement;
import aps.domain.shared.ApsMaps;
import aps.domain.shared.GenericXmlParser;

import java.util.ArrayList;
import java.util.List;

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
            dps.add(dp);
        });

        mappedObject.setDataPairs(dps);

        return mappedObject;
    }

    public int createStatementFromScrapeObject(ScrapeObject inObject) {

        //TODO: need to decide how billingCompanyType gets here

        MunicipalityStatement mStatement = new MunicipalityStatement();

        inObject.getDataPairs().forEach(dp -> {
            dp.getText();
        });

        return 0;
    }



}
