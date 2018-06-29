package aps.domain.model.billingcompany;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BillingCompanyFactoryTest {

    @Test
    public void createFactoryMethodTest(){
        assertTrue("createBillingCompany Telecoms",BillingCompanyFactory.createBillingCompany("","","TELECOMS_BILLING_COMPANY_TYPE") instanceof BillingCompany);
        assertTrue("createBillingCompany Municipality",BillingCompanyFactory.createBillingCompany("","","MUNICIPALITY_BILLING_COMPANY_TYPE") instanceof BillingCompany);
        assertTrue("createBillingCopmany Credit Card Provider",BillingCompanyFactory.createBillingCompany("","","CREDIT_CARD_PROVIDER_BILLING_COMPANY_TYPE") instanceof BillingCompany);
    }

    @Test
    public void validBillingCompany(){
        BillingCompany billingCompany = BillingCompanyFactory.createBillingCompany("Telkom","www.Telkom.co.za","TELECOMS_BILLING_COMPANY_TYPE");
        assertEquals("BillingCompanyURL","www.Telkom.co.za",billingCompany.getBaseUrl());
        assertEquals("BillingCompanyName","Telkom",billingCompany.getName());
        assertEquals("BillingCompanyType","TELECOMS_BILLING_COMPANY_TYPE",billingCompany.getBillingCompanyType());
    }

}
