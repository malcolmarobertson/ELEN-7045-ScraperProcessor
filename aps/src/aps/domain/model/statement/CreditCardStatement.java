package aps.domain.model.statement;

import aps.domain.service.ValidationService;

import java.math.BigDecimal;

/**
 * Statement class representing all the statements for Credit Card Providers. Assumption is that all the Credit Card Providers will have the same fields.
 */
public class CreditCardStatement extends Statement {

    public static final StatementType statementType = StatementType.CREDIT_CARD_PROVIDER;
    private String cardType;
    private double interestRate;
    private BigDecimal creditLimit;
    private BigDecimal creditAvailable;
    private BigDecimal minimumAmountDue;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getCreditAvailable() {
        return creditAvailable;
    }

    public void setCreditAvailable(BigDecimal creditAvailable) {
        this.creditAvailable = creditAvailable;
    }

    public BigDecimal getMinimumAmountDue() {
        return minimumAmountDue;
    }

    public void setMinimumAmountDue(BigDecimal minimumAmountDue) {
        this.minimumAmountDue = minimumAmountDue;
    }

}
