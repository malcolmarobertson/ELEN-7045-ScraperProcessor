package aps.domain.model.customer;

import aps.domain.model.billingcompany.BillingCompany;

import java.util.List;

public class CustomerBillingAccount {
    private BillingCompany billingCompany;
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
}
