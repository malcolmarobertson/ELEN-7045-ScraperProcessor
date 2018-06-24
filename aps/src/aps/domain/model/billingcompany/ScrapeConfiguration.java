package aps.domain.model.billingcompany;

import java.util.Date;

public class ScrapeConfiguration {
    private Date dateFrom;
    private Date dateTo;
    private int statementDayOfMonth;
    private int cycleDays;
    private int leadTimeInDays;
    private int retryIntervals;
    private int concurrentSessions;

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

    public int getRetryIntervals() {
        return retryIntervals;
    }

    public void setRetryIntervals(int retryIntervals) {
        this.retryIntervals = retryIntervals;
    }

    public int getConcurrentSessions() {
        return concurrentSessions;
    }

    public void setConcurrentSessions(int concurrentSessions) {
        this.concurrentSessions = concurrentSessions;
    }
}
