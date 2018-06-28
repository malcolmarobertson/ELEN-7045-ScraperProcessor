package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.INVALID_CREDENTIALS;

public class InvalidCredentialsError extends AbstractError {

    @Override
    public String handleError() {
        return INVALID_CREDENTIALS;
    }

}
