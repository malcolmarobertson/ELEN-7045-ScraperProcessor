package aps.domain.service;

import java.math.BigDecimal;

public interface ValidationService {

    BigDecimal calculateVatAmount(BigDecimal amount);

    BigDecimal calculateOpeningBalance();

    boolean validateInteger();

    boolean validateDate();

    boolean validateTotalAmount(BigDecimal expectedAmount, BigDecimal actualAmount);
}
