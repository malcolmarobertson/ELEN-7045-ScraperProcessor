package aps.domain.model.billingcompany;

import java.util.Date;

/**
 * Class represents all the settings pertaining to Scraper Scheduling that can be configured per BillingCompany.
 */
public class ScrapeConfiguration {
    private Date dateFrom;
    private Date dateTo;
    private int statementDayOfMonth;
    private int cycleDays;
    private int leadTimeInDays;
    private int scraperRetryIntervals;
    private int apsRetryIntervals;
    private int concurrentSessions;
    private int nextScrapeTimestamp;

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public int getStatementDayOfMonth() {
        return statementDayOfMonth;
    }

    public void setStatementDayOfMonth(int statementDayOfMonth) {
        this.statementDayOfMonth = statementDayOfMonth;
    }

    public int getCycleDays() {
        return cycleDays;
    }

    public void setCycleDays(int cycleDays) {
        this.cycleDays = cycleDays;
    }

    public int getLeadTimeInDays() {
        return leadTimeInDays;
    }

    public void setLeadTimeInDays(int leadTimeInDays) {
        this.leadTimeInDays = leadTimeInDays;
    }

    public int getScraperRetryIntervals() {
        return scraperRetryIntervals;
    }

    public void setScraperRetryIntervals(int scraperRetryIntervals) {
        this.scraperRetryIntervals = scraperRetryIntervals;
    }

    public int getApsRetryIntervals() {
        return apsRetryIntervals;
    }

    public void setApsRetryIntervals(int apsRetryIntervals) {
        this.apsRetryIntervals = apsRetryIntervals;
    }

    public int getConcurrentSessions() {
        return concurrentSessions;
    }

    public void setConcurrentSessions(int concurrentSessions) {
        this.concurrentSessions = concurrentSessions;
    }

    public int getNextScrapeTimestamp() {
        return nextScrapeTimestamp;
    }

    public void setNextScrapeTimestamp(int nextScrapeTimestamp) {
        this.nextScrapeTimestamp = nextScrapeTimestamp;
    }
}
