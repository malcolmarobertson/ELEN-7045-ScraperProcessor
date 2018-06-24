package aps.domain.model.statement;

import java.math.BigDecimal;

/**
 * Statement class representing all the statements for Telco Service Providers. Assumption is that all the Telco Service Providers will have the same fields.
 */
public class TelcoServiceStatement {

    private String telephoneNumber;
    private BigDecimal serviceCharges;
    private BigDecimal callCharges;
    private int totalNumberOfCalls;
    private double callDuration;

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public BigDecimal getServiceCharges() {
        return serviceCharges;
    }

    public void setServiceCharges(BigDecimal serviceCharges) {
        this.serviceCharges = serviceCharges;
    }

    public BigDecimal getCallCharges() {
        return callCharges;
    }

    public void setCallCharges(BigDecimal callCharges) {
        this.callCharges = callCharges;
    }

    public int getTotalNumberOfCalls() {
        return totalNumberOfCalls;
    }

    public void setTotalNumberOfCalls(int totalNumberOfCalls) {
        this.totalNumberOfCalls = totalNumberOfCalls;
    }

    public double getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(double callDuration) {
        this.callDuration = callDuration;
    }
}
