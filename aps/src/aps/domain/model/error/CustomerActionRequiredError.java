package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.CUSTOMER_ACTION_REQUIRED;

public class CustomerActionRequiredError  extends AbstractError {

    @Override
    public String handleError() {
        return CUSTOMER_ACTION_REQUIRED;
    }
}
