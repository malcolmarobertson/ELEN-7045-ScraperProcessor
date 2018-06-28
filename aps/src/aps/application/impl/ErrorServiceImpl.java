package aps.application.impl;

import aps.application.IErrorService;
import aps.domain.model.customer.CustomerBillingAccount;
import aps.domain.model.error.*;
import aps.domain.model.error.Error;
import aps.domain.shared.ApplicationConstants;
import aps.domain.shared.GenericXmlParser;
import aps.domain.shared.ScrapeResponse;
import aps.infrastructure.persistence.hibernate.ErrorRepositoryHibernate;

import static aps.domain.model.error.ErrorCode.*;

public class ErrorServiceImpl implements IErrorService {
    ErrorRepository errorRepository = new ErrorRepositoryHibernate();

    @Override
    public String handleError(ScrapeResponse scrapeResponse, CustomerBillingAccount customerBillingAccount) {
        GenericXmlParser genericXmlParser = new GenericXmlParser(Error.class);
        Error scrapeObject = (Error) genericXmlParser.parseScrapXml(scrapeResponse.getXmlResponse());
        ErrorContext errorContext = new ErrorContext();
        setCorrectScrapErrorContext(scrapeObject, errorContext);
        System.out.println("Setting customer account to " + ApplicationConstants.INACTIVE + ".");
        customerBillingAccount.setAccountStatus(ApplicationConstants.INACTIVE);
        errorContext.logError(scrapeResponse.getXmlResponse());
        return errorContext.handleError();
    }

    @Override
    public Error findByBaseUrl(String baseUrl) {
        return errorRepository.findByBaseUrl(baseUrl);
    }

    @Override
    public void add(Error error) {
        errorRepository.add(error);
    }

    @Override
    public void delete(Error error) {
        errorRepository.delete(error);
    }

    @Override
    public void update(Error error) {
        errorRepository.update(error);
    }

    private void setCorrectScrapErrorContext(Error scrapeObject, ErrorContext errorContext) {
        if (INVALID_CREDENTIALS.toString().equals(scrapeObject.getScrapeErrorCode())) {
            errorContext.setScrapeStrategy(new InvalidCredentialsError());
        } else if (NOT_SIGNED_FOR_EBILLING.toString().equals(scrapeObject.getScrapeErrorCode())) {
            errorContext.setScrapeStrategy(new NotSignedForEBillingError());
        } else if (CUSTOMER_ACTION_REQUIRED.toString().equals(scrapeObject.getScrapeErrorCode())) {
            errorContext.setScrapeStrategy(new CustomerActionRequiredError());
        } else if (SITE_DOWN.toString().equals(scrapeObject.getScrapeErrorCode())) {
            errorContext.setScrapeStrategy(new SiteDownError());
        } else if (ERROR_PAGE.toString().equals(scrapeObject.getScrapeErrorCode())) {
            errorContext.setScrapeStrategy(new ErrorPageError());
        } else if (BROKEN_SCRIPT.toString().equals(scrapeObject.getScrapeErrorCode())) {
            errorContext.setScrapeStrategy(new BrokenScriptError());
        }
    }
}
