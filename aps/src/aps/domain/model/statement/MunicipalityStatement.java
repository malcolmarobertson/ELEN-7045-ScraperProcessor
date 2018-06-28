package aps.domain.model.statement;

import java.math.BigDecimal;

/**
 * Statement class representing all the statements for Municipalities. Assumption is that all the Municipalities will have the same fields.
 */
public class MunicipalityStatement extends Statement {

    public static final StatementType statementType = StatementType.MUNICIPALITY;
    public int instalmentNotice;
    public int electricityUsed;
    public BigDecimal electricityCharges;
    public int gasUsed;
    public BigDecimal gasCharges;
    public int waterUsed;
    public BigDecimal waterCharges;
    public BigDecimal sewerageCharges;
    public BigDecimal refuseCharges;

    /**
     * Represents a Custom Integrity Check for the MunicipalityStatement
     */
    public boolean checkWaterChargedCorrectly(){
        return Boolean.FALSE;
    }

    public int getInstalmentNotice() {
        return instalmentNotice;
    }

    public void setInstalmentNotice(int instalmentNotice) {
        this.instalmentNotice = instalmentNotice;
    }

    public int getElectricityUsed() {
        return electricityUsed;
    }

    public void setElectricityUsed(int electricityUsed) {
        this.electricityUsed = electricityUsed;
    }

    public BigDecimal getElectricityCharges() {
        return electricityCharges;
    }

    public void setElectricityCharges(BigDecimal electricityCharges) {
        this.electricityCharges = electricityCharges;
    }

    public int getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(int gasUsed) {
        this.gasUsed = gasUsed;
    }

    public BigDecimal getGasCharges() {
        return gasCharges;
    }

    public void setGasCharges(BigDecimal gasCharges) {
        this.gasCharges = gasCharges;
    }

    public int getWaterUsed() {
        return waterUsed;
    }

    public void setWaterUsed(int waterUsed) {
        this.waterUsed = waterUsed;
    }

    public BigDecimal getWaterCharges() {
        return waterCharges;
    }

    public void setWaterCharges(BigDecimal waterCharges) {
        this.waterCharges = waterCharges;
    }

    public BigDecimal getSewerageCharges() {
        return sewerageCharges;
    }

    public void setSewerageCharges(BigDecimal sewerageCharges) {
        this.sewerageCharges = sewerageCharges;
    }

    public BigDecimal getRefuseCharges() {
        return refuseCharges;
    }

    public void setRefuseCharges(BigDecimal refuseCharges) {
        this.refuseCharges = refuseCharges;
    }
}
