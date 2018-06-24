package aps.domain.model.customer;

import aps.domain.model.billingcompany.BillingCompany;

import java.util.List;

public class CustomerBillingAccount {
    private BillingCompany billingCompany;
    private AccountStatus accountStatus;
    private List<AccountCredential> accountCredentials;

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

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
