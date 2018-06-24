package aps.domain.model.billingcompany;

import aps.domain.model.statement.Statement;

public class BillingCompany {
    private String name;
    private String baseUrl;
    private String id;
    private BillingCompanyType billingCompanyType;
    private ScrapeConfiguration scrapeConfiguration;
    private Statement statement;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BillingCompanyType getBillingCompanyType() {
        return billingCompanyType;
    }

    public void setBillingCompanyType(BillingCompanyType billingCompanyType) {
        this.billingCompanyType = billingCompanyType;
    }

    public ScrapeConfiguration getScrapeConfiguration() {
        return scrapeConfiguration;
    }

    public void setScrapeConfiguration(ScrapeConfiguration scrapeConfiguration) {
        this.scrapeConfiguration = scrapeConfiguration;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
