package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.SITE_DOWN;

public class SiteDownError extends AbstractError {

    @Override
    public String handleError() {
        return SITE_DOWN;
    }

}
