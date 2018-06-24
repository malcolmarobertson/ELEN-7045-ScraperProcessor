package aps.domain.model.scrape;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "scrape-session")
@XmlAccessorType(XmlAccessType.FIELD)
public class TelkomScrape {
    @XmlElement(name = "base-url")
    private String baseUrl;
    private String customerName;
    private String customerSurname;

    @XmlElement
    private Date date;

    @XmlElement
    private DataPairs dataPairs;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DataPairs getDataPairs() {
        return dataPairs;
    }

    public void setDataPairs(DataPairs dataPairs) {
        this.dataPairs = dataPairs;
    }
}
