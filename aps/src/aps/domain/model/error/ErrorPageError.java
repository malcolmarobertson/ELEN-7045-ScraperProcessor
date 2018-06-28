package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.ERROR_PAGE;

public class ErrorPageError  extends AbstractError {

    @Override
    public String handleError() {
        return ERROR_PAGE;
    }

}
