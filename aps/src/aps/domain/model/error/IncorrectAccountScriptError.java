package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.INCORRECT_ACCOUNT;

public class IncorrectAccountScriptError  extends AbstractError {

    @Override
    public String handleError() {
        return INCORRECT_ACCOUNT;
    }

}
