package aps.domain.model.billingcompany;

import aps.domain.model.statement.Statement;
import aps.domain.model.statement.StatementType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement(name = "billingCompany")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillingCompany {
    private String name;
    private String baseUrl;
    private UUID id;
    private String billingCompanyType;
    private ScrapeConfiguration scrapeConfiguration;

    public BillingCompany(UUID id) {
        this.id = id;
    }

    public BillingCompany() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public UUID getId() {
        return id;
    }

    public ScrapeConfiguration getScrapeConfiguration() {
        return scrapeConfiguration;
    }

    public String getBillingCompanyType() {
        return billingCompanyType;
    }

    public void setBillingCompanyType(String billingCompanyType) {
        this.billingCompanyType = billingCompanyType;
    }

    public void setScrapeConfiguration(ScrapeConfiguration scrapeConfiguration) {
        this.scrapeConfiguration = scrapeConfiguration;
    }

}
