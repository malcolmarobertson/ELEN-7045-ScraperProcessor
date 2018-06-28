package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.INCORRECT_ACCOUNT;

public class IncorrectAccountScriptError implements ErrorStrategy {

    @Override
    public String handleError() {
        return INCORRECT_ACCOUNT;
    }

    @Override
    public void saveError() {

    }
}
