package aps.domain.model.customer;

import aps.domain.model.billingcompany.BillingCompany;

import java.util.Collection;

public class CustomerBillingAccount {
    private BillingCompany billingCompany;
    private Collection<AccountCredential> accountCredentials;

    public BillingCompany getBillingCompany() {
        return billingCompany;
    }

    public void setBillingCompany(BillingCompany billingCompany) {
        this.billingCompany = billingCompany;
    }

    public Collection<AccountCredential> getAccountCredentials() {
        return accountCredentials;
    }

    public void setAccountCredentials(Collection<AccountCredential> accountCredentials) {
        this.accountCredentials = accountCredentials;
    }
}
