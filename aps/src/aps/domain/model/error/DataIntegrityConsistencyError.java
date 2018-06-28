package aps.domain.model.error;

import static aps.domain.shared.ApplicationConstants.DATA_INTEGRITY_CONSISTENCY;

public class DataIntegrityConsistencyError implements ErrorStrategy {

    @Override
    public String handleError() {
        return DATA_INTEGRITY_CONSISTENCY;
    }

    @Override
    public void saveError() {

    }
}
