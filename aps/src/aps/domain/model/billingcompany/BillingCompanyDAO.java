package aps.domain.model.billingcompany;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BillingCompanyDAO {

    private BillingCompanyDataStore read(){

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BillingCompanyDataStore.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            File file = new File("BillingCompanyDataStore.xml");
            if(!file.exists()){
                return null;
            }

            return (BillingCompanyDataStore) unmarshaller.unmarshal(file);
        }catch (JAXBException e){
            e.printStackTrace();
        }

        return null;
    }

    private void write(BillingCompanyDataStore billingCompanyDataStore){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BillingCompanyDataStore.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(billingCompanyDataStore,new FileOutputStream(new File("BillingCompanyDataStore.xml")));
        }catch (JAXBException | FileNotFoundException e){
            e.printStackTrace();
        }
    }


    public boolean add(BillingCompany billingCompany){
        boolean status = false;
        BillingCompanyDataStore billingCompanyDataStore = new BillingCompanyDataStore();
        File file = new File("BillingCompanyDataStore.xml");
        if(file.exists()){
            billingCompanyDataStore = read();
        }
        if(!billingCompanyDataStore.contains(billingCompany)) {
            billingCompanyDataStore.addBillingCompany(billingCompany);
            write(billingCompanyDataStore);
            status = true;
        }

        return status;
    }

    public boolean remove(BillingCompany billingCompany){
        boolean status = false;
        BillingCompanyDataStore billingCompanyDataStore = read();
        if(billingCompanyDataStore != null) {
            billingCompanyDataStore.removeBillingCompany(billingCompany);
            write(billingCompanyDataStore);
            status = true;
        }
        return status;
    }

    public BillingCompany findByURL(String baseURL){
        BillingCompanyDataStore billingCompanyDataStore;
        if((billingCompanyDataStore = read()) !=null){
            return billingCompanyDataStore.getBillingCompanyByURL(baseURL);
        }
        return null;
    }

    public void update(BillingCompany billingCompany){
        BillingCompanyDataStore billingCompanyDataStore = read();
        if(billingCompanyDataStore != null){
            billingCompanyDataStore.update(billingCompany);
        }
        add(billingCompany);
    }

    public BillingCompany findByName(String name){
        BillingCompanyDataStore billingCompanyDataStore;
        if((billingCompanyDataStore = read()) !=null){
            return billingCompanyDataStore.getBillingCompanyByName(name);
        }
        return null;
    }

}
