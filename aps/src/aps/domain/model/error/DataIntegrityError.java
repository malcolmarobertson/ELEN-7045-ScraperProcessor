package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.DATA_INTEGRITY;

public class DataIntegrityError implements ErrorStrategy {

    @Override
    public String handleError() {
        return DATA_INTEGRITY;
    }

    @Override
    public void saveError() {

    }
}
