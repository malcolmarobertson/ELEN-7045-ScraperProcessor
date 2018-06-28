package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.BROKEN_SCRIPT;

public class BrokenScriptError extends AbstractError{

    @Override
    public String handleError() {
        return BROKEN_SCRIPT;
    }
}
