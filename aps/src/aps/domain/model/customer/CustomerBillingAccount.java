package aps.domain.model.customer;

import aps.domain.model.billingcompany.BillingCompany;

import java.util.List;

public class CustomerBillingAccount {
    private String accountNumber;
    private BillingCompany billingCompany;
    private String accountStatus;
    private List<AccountCredential> accountCredentials;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BillingCompany getBillingCompany() {
        return billingCompany;
    }

    public void setBillingCompany(BillingCompany billingCompany) {
        this.billingCompany = billingCompany;
    }

    public List<AccountCredential> getAccountCredentials() {
        return accountCredentials;
    }

    public void setAccountCredentials(List<AccountCredential> accountCredentials) {
        this.accountCredentials = accountCredentials;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
