package aps.domain.model.billingcompany;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BillingCompanyRepoTest {

    @Test
    public void billingCompanyRepoMethods(){
        BillingCompany billingCompany = mock(BillingCompany.class);

        BillingCompanyDAO billingCompanyDAO = mock(BillingCompanyDAO.class);
        when(billingCompanyDAO.findByURL("")).thenReturn(billingCompany);
        when(billingCompanyDAO.findByName("")).thenReturn(billingCompany);
        when(billingCompanyDAO.add(billingCompany)).thenReturn(true);
        when(billingCompanyDAO.remove(billingCompany)).thenReturn(true);

        BillingCompanyRepo billingCompanyRepo = new BillingCompanyRepo(billingCompanyDAO);

        assertTrue("BillingCompanyRepo.findByName()",billingCompany == billingCompanyDAO.findByName(""));
        assertTrue("BillingCompanyRepo.findByURL()",billingCompany == billingCompanyDAO.findByURL(""));
        assertTrue("BillingCompanyRepo.add()",billingCompanyRepo.add(billingCompany));
        assertTrue("BillingCompanyRepo.delete()",billingCompanyRepo.delete(billingCompany));
    }

}
