package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.INVALID_CREDENTIALS;

public class InvalidCredentialsError implements ErrorStrategy {

    @Override
    public String handleError() {
        return INVALID_CREDENTIALS;
    }

    @Override
    public void saveError() {

    }
}
