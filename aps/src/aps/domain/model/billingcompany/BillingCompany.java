package aps.domain.model.billingcompany;

import aps.domain.model.statement.Statement;
import aps.domain.model.statement.StatementType;

import java.util.UUID;

public class BillingCompany {
    private String name;
    private String baseUrl;
    private UUID id;
    private StatementType statementType;
    private ScrapeConfiguration scrapeConfiguration;
    private Statement statement;

    public BillingCompany(UUID id){
        this.id = id;
    }

    public BillingCompany(){}

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

    public StatementType getBillingCompanyType() {
        return statementType;
    }

    public void setBillingCompanyType(StatementType statementType) {
        this.statementType = statementType;
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
