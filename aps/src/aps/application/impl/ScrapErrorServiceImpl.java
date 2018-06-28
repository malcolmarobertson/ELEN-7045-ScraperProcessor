package aps.application.impl;

import aps.application.IScrapErrorService;
import aps.domain.model.customer.CustomerBillingAccount;
import aps.domain.model.error.*;
import aps.domain.shared.ApplicationConstants;
import aps.domain.shared.GenericXmlParser;
import aps.domain.shared.ScrapeResponse;

import static aps.domain.model.error.ScrapeErrorCode.*;

public class ScrapErrorServiceImpl implements IScrapErrorService {

    @Override
    public String handleScrapeError(ScrapeResponse scrapeResponse, CustomerBillingAccount customerBillingAccount) {
        GenericXmlParser genericXmlParser = new GenericXmlParser(ScrapeError.class);
        ScrapeError scrapeObject = (ScrapeError) genericXmlParser.parseScrapXml(scrapeResponse.getXmlResponse());
        ErrorContext errorContext = new ErrorContext();
        setCorrectScrapErrorContext(scrapeObject, errorContext);
        System.out.println("Setting customer account to " + ApplicationConstants.INACTIVE + ".");
        customerBillingAccount.setAccountStatus(ApplicationConstants.INACTIVE);
        return errorContext.handleError();
    }

    private void setCorrectScrapErrorContext(ScrapeError scrapeObject, ErrorContext errorContext) {
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
