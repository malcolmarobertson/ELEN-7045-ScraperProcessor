package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.BROKEN_SCRIPT;

public class BrokenScriptError implements ErrorStrategy {

    @Override
    public String handleError() {
        //TODO: Handle Site Changed and Encountered Unhandled Data Condition Errors differently.
        return BROKEN_SCRIPT;
    }

    @Override
    public void saveError() {

    }
}
