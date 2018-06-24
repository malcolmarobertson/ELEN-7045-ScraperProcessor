package aps.domain.shared;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

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
}
