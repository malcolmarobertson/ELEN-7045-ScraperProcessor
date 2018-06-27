package aps.application.impl;

import aps.application.IScrapErrorService;
import aps.domain.model.customer.CustomerBillingAccount;
import aps.domain.model.scraperror.*;
import aps.domain.shared.ApplicationConstants;
import aps.domain.shared.GenericXmlParser;
import aps.domain.shared.ScrapeResponse;

import static aps.domain.model.scraperror.ScrapeErrorCode.*;

public class ScrapErrorServiceImpl implements IScrapErrorService {

    @Override
    public String handleScrapeError(ScrapeResponse scrapeResponse, CustomerBillingAccount customerBillingAccount) {
        GenericXmlParser genericXmlParser = new GenericXmlParser(ScrapeError.class);
        ScrapeError scrapeObject = (ScrapeError) genericXmlParser.parseScrapXml(scrapeResponse.getXmlResponse());
        ScrapeErrorContext scrapeErrorContext = new ScrapeErrorContext();
        setCorrectScrapErrorContext(scrapeObject, scrapeErrorContext);
        System.out.println("Setting customer account to " + ApplicationConstants.INACTIVE + ".");
        customerBillingAccount.setAccountStatus(ApplicationConstants.INACTIVE);
        return scrapeErrorContext.handleScrapeError();
    }

    private void setCorrectScrapErrorContext(ScrapeError scrapeObject, ScrapeErrorContext scrapeErrorContext) {
        if (INVALID_CREDENTIALS.toString().equals(scrapeObject.getScrapeErrorCode())) {
            scrapeErrorContext.setScrapeErrorStrategy(new InvalidCredentialsScrapeError());
        } else if (NOT_SIGNED_FOR_EBILLING.toString().equals(scrapeObject.getScrapeErrorCode())) {
            scrapeErrorContext.setScrapeErrorStrategy(new NotSignedForEBillingScrapeError());
        } else if (CUSTOMER_ACTION_REQUIRED.toString().equals(scrapeObject.getScrapeErrorCode())) {
            scrapeErrorContext.setScrapeErrorStrategy(new CustomerActionRequiredScrapeError());
        } else if (SITE_DOWN.toString().equals(scrapeObject.getScrapeErrorCode())) {
            scrapeErrorContext.setScrapeErrorStrategy(new SiteDownScrapeError());
        } else if (ERROR_PAGE.toString().equals(scrapeObject.getScrapeErrorCode())) {
            scrapeErrorContext.setScrapeErrorStrategy(new ErrorPageScrapeError());
        } else if (BROKEN_SCRIPT.toString().equals(scrapeObject.getScrapeErrorCode())) {
            scrapeErrorContext.setScrapeErrorStrategy(new BrokenScriptScrapeError());
        }
    }
}
