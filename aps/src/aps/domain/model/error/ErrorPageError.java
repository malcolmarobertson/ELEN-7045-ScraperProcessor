package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.ERROR_PAGE;

public class ErrorPageError implements ErrorStrategy {

    @Override
    public String handleError() {
        return ERROR_PAGE;
    }

    @Override
    public void saveError() {

    }
}
