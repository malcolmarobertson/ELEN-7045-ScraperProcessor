package aps.domain.model.scrape;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "scrape-session")
@XmlAccessorType(XmlAccessType.FIELD)
public class ScrapeObject {
    @XmlElement(name = "base-url")
    private String baseUrl;
    private String customerName;
    private String customerSurname;

    @XmlElement
    private Date date;

    @XmlElementWrapper(name = "datapairs")
    @XmlElement(name = "datapair")
    private List<DataPair> dataPairs;

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

    public List<DataPair> getDataPairs() {
        return dataPairs;
    }

    public void setDataPairs(List<DataPair> dataPairs) {
        this.dataPairs = dataPairs;
    }
}
