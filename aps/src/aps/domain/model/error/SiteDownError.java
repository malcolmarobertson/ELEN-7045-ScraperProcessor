package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.SITE_DOWN;

public class SiteDownError implements ErrorStrategy {

    @Override
    public String handleError() {
        return SITE_DOWN;
    }

    @Override
    public void saveError() {

    }
}
