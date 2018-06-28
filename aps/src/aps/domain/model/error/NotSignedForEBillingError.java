package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.NOT_SIGNED_FOR_EBILLING;

public class NotSignedForEBillingError implements ErrorStrategy {

    @Override
    public String handleError() {
        return NOT_SIGNED_FOR_EBILLING;
    }

    @Override
    public void saveError() {

    }
}
