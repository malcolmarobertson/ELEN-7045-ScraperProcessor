package aps.application;

import aps.domain.model.customer.CustomerBillingAccount;
import aps.domain.model.error.Error;
import aps.domain.shared.ScrapeResponse;

public interface IErrorService {

    String handleError(ScrapeResponse scrapeResponse, CustomerBillingAccount customerBillingAccount);

    public Error findByBaseUrl(String baseUrl);

    public void add(Error Error);

    public void delete(Error Error);

    public void update(Error Error);

}
