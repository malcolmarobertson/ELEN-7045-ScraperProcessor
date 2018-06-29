package aps.domain.model.billingcompany;

public class BillingCompanyRepo implements BillingCompanyRepository {

    BillingCompanyDAO billingCompanyDAO;
    public BillingCompanyRepo(){
        billingCompanyDAO = new BillingCompanyDAO();
    }

    public BillingCompanyRepo(BillingCompanyDAO billingCompanyDAO){
        this.billingCompanyDAO = billingCompanyDAO;
    }

    @Override
    public BillingCompany findByURL(String baseURL) {
        BillingCompany billingCompany = billingCompanyDAO.findByURL(baseURL);
        return billingCompany;
    }

    @Override
    public BillingCompany findByName(String name) {
        BillingCompany billingCompany = billingCompanyDAO.findByName(name);
        return billingCompany;
    }

    @Override
    public boolean add(BillingCompany billingCompany) {
        return billingCompanyDAO.add(billingCompany);
    }

    @Override
    public boolean delete(BillingCompany billingCompany) {
        return billingCompanyDAO.remove(billingCompany);
    }

    @Override
    public void update(BillingCompany billingCompany) {
        billingCompanyDAO.update(billingCompany);
    }

    @Override
    public BillingCompany createBillingCompany(String companyName, String baseURL, String billingCompanyType) {
        return BillingCompanyFactory.createBillingCompany(companyName,baseURL,billingCompanyType);
    }


}
