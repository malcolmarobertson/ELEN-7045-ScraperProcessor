package aps.domain.model.billingcompany;

import java.util.List;

/**
 * Class represents all the settings pertaining to Scraper Scheduling that can be configured per BillingCompany.
 */
public class ScrapeConfiguration {

    private List<Integer> scrapeDaysOfMonth;
    private List<Integer> nonScrapeDaysOfMonth;
    private int statementDayOfMonth;
    private int cycleDays;
    private int leadTimeInDays;
    private int scraperRetryIntervals;
    private int apsRetryIntervals;
    private int concurrentSessions;
    private int nextScrapeTimestamp;

    public List<Integer> getScrapeDaysOfMonth() {
        return scrapeDaysOfMonth;
    }

    public void setScrapeDaysOfMonth(List<Integer> scrapeDaysOfMonth) {
        this.scrapeDaysOfMonth = scrapeDaysOfMonth;
    }

    public List<Integer> getNonScrapeDaysOfMonth() {
        return nonScrapeDaysOfMonth;
    }

    public void setNonScrapeDaysOfMonth(List<Integer> nonScrapeDaysOfMonth) {
        this.nonScrapeDaysOfMonth = nonScrapeDaysOfMonth;
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
