package aps.domain.shared;

import aps.domain.model.scrape.TelkomScrape;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlParseHelper {
    public TelkomScrape parseScrapXml(String xmlResponse, Class clazz) {
        TelkomScrape telkomScrape = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TelkomScrape.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(xmlResponse);
            telkomScrape = (TelkomScrape) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return telkomScrape;
    }
}
