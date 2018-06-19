package aps.domain.model.statement;

import aps.domain.shared.Month;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Abstract Statement class which contains all the common fields directly present or derived.
 * Potentially use the Builder pattern to cater for Requirement 3.2.2 which says:
 * It is expected that additional statement types will identified in future.
 */
public abstract class Statement {

    private int id;
    private String accountNumber;
    private String accountHolderName;
    private Date statementDate;
    private String statementNumber;
    private Month month;
    private BigDecimal totalDue;
    private Date dueDate;
    private BigDecimal openingBalance;
    private BigDecimal closingBalance;
    private boolean paymentReceived;
    private BigDecimal newCharges;
    private BigDecimal deductions;
    private BigDecimal discount;
    private BigDecimal vatAmount;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Date getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(Date statementDate) {
        this.statementDate = statementDate;
    }

    public String getStatementNumber() {
        return statementNumber;
    }

    public void setStatementNumber(String statementNumber) {
        this.statementNumber = statementNumber;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public BigDecimal getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(BigDecimal totalDue) {
        this.totalDue = totalDue;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(BigDecimal openingBalance) {
        this.openingBalance = openingBalance;
    }

    public BigDecimal getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(BigDecimal closingBalance) {
        this.closingBalance = closingBalance;
    }

    public boolean isPaymentReceived() {
        return paymentReceived;
    }

    public void setPaymentReceived(boolean paymentReceived) {
        this.paymentReceived = paymentReceived;
    }

    public BigDecimal getNewCharges() {
        return newCharges;
    }

    public void setNewCharges(BigDecimal newCharges) {
        this.newCharges = newCharges;
    }

    public BigDecimal getDeductions() {
        return deductions;
    }

    public void setDeductions(BigDecimal deductions) {
        this.deductions = deductions;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(BigDecimal vatAmount) {
        this.vatAmount = vatAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return id == statement.id &&
                Objects.equals(accountNumber, statement.accountNumber) &&
                Objects.equals(accountHolderName, statement.accountHolderName) &&
                Objects.equals(statementDate, statement.statementDate) &&
                Objects.equals(statementNumber, statement.statementNumber) &&
                month == statement.month;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, accountNumber, accountHolderName, statementDate, statementNumber, month);
    }
}
