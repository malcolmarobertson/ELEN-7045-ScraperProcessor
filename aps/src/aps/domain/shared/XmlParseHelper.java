package aps.domain.shared;

import aps.domain.model.scrape.ScrapeObject;

import javax.xml.bind.Element;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;

public class XmlParseHelper {
    public ScrapeObject parseScrapXml(String xmlResponse, Class clazz) {
        ScrapeObject scrapeObject = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ScrapeObject.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(xmlResponse);
            scrapeObject = (ScrapeObject) unmarshaller.unmarshal(reader);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return scrapeObject;
    }
}
