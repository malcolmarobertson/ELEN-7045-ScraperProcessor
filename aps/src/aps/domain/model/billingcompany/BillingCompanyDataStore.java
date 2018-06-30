package aps.domain.model.billingcompany;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="billingCompantDataStore")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillingCompanyDataStore {

    @XmlElement(name="BillingCompany")
    private List<BillingCompany> billingCompanies = null;

    public BillingCompanyDataStore(){
        billingCompanies = new ArrayList<>();
    }
    public void addBillingCompany(BillingCompany billingCompany){
        this.billingCompanies.add(billingCompany);
    }

    public BillingCompany getBillingCompanyByURL(String URL){
        for (BillingCompany billingCompany:billingCompanies){
            if(billingCompany.getBaseUrl().equalsIgnoreCase(URL)){
                return billingCompany;
            }
        }
        return null;
    }

    public BillingCompany getBillingCompanyByName(String name){
        for (BillingCompany billingCompany:billingCompanies){
            if(billingCompany.getName().equalsIgnoreCase(name)){
                return billingCompany;
            }
        }
        return null;
    }

    public boolean removeBillingCompany(BillingCompany billingCompany){
        boolean status = false;
        for(int index = 0; index < billingCompanies.size();index++){
            if(billingCompanies.get(index).getBaseUrl().equals(billingCompany.getBaseUrl())){
                billingCompanies.remove(index);
                status = true;
            }
        }
        return status;
    }

    public boolean update(BillingCompany billingCompany){
        boolean status = false;
        for(int index = 0; index < billingCompanies.size();index++){
            if(billingCompanies.get(index).getBaseUrl().equals(billingCompany.getBaseUrl())){
                billingCompanies.set(index,billingCompany);
                status = true;
            }
        }
        return status;
    }

    public boolean contains(BillingCompany billingCompany){
        for(BillingCompany billingCompany1:billingCompanies){
            if(billingCompany1.getBaseUrl().equals(billingCompany.getBaseUrl())){
                return true;
            }
        }
        return false;
    }
}
