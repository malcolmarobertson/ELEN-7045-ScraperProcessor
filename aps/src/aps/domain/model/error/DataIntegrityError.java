package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.DATA_INTEGRITY;

public class DataIntegrityError  extends AbstractError{

    @Override
    public String handleError() {
        return DATA_INTEGRITY;
    }

}
