package aps.domain.shared;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class GenericXmlParser<T> {
    private Class<T> type;

    public GenericXmlParser(Class<T> type) {
        this.type = type;
    }

    public T parseScrapXml(String xmlResponse) {
        T t = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(xmlResponse);
            t = (T) unmarshaller.unmarshal(reader);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return t;
    }

    public String marshallScrapXml(T t) {
        String xmlString = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(type);
            Marshaller marshaller = jaxbContext.createMarshaller();

            StringWriter writer = new StringWriter();
            marshaller.marshal(t, writer);
            xmlString = writer.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlString;
    }
}
