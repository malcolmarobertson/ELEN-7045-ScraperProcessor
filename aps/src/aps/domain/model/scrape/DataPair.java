package aps.domain.model.scrape;

import javax.xml.bind.annotation.XmlElement;

public class DataPair {
    private String text;
    private String value;

    @XmlElement
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    @XmlElement
    public void setValue(String value) {
        this.value = value;
    }
}
