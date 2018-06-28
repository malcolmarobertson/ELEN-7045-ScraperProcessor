package aps.domain.model.statement;

import aps.domain.service.ValidationService;
import aps.domain.shared.Month;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Abstract StatementService class which contains all the common fields directly present or derived.
 * Potentially use the Builder pattern to cater for Requirement 3.2.2 which says:
 * It is expected that additional statement types will identified in future.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Statement implements ValidationService {

    //VAT Rate assumed to be fixed at 14%
    public static final double vatRate = 0.14;
    private int id;
    public StatementType statementType;
    public String accountNumber;
    public String accountHolderName;
    public String statementDate;
    public String statementNumber;
    public String month;
    public BigDecimal totalDue;
    public Date dueDate;
    public BigDecimal openingBalance;
    public BigDecimal closingBalance;
    public BigDecimal paymentReceived;
    public BigDecimal newCharges;
    public BigDecimal deductions;
    public BigDecimal discount;
    public BigDecimal vatAmount;

    /**
     * Below are examples of Standard Integrity checks that can be run for all Statement Types, should they be required.
     */
    public BigDecimal calculateVatAmount(BigDecimal amount) {
        return BigDecimal.valueOf(vatRate).multiply(amount);
    }

    public BigDecimal calculateOpeningBalance() {
        return openingBalance.subtract(paymentReceived).add(newCharges).subtract(discount).subtract(deductions);
    }

    @Override
    public boolean validateInteger() {
        return false;
    }

    @Override
    public boolean validateDate() {
        return false;
    }

    @Override
    public boolean validateTotalAmount(BigDecimal expectedAmount, BigDecimal actualAmount) {
        return false;
    }

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

    public String getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(String statementDate) {
        this.statementDate = statementDate;
    }

    public String getStatementNumber() {
        return statementNumber;
    }

    public void setStatementNumber(String statementNumber) {
        this.statementNumber = statementNumber;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
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

    public BigDecimal getPaymentReceived() {
        return paymentReceived;
    }

    public void setPaymentReceived(BigDecimal paymentReceived) {
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
