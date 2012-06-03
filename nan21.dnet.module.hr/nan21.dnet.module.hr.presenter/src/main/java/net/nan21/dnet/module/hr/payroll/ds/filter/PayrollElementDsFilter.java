/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class PayrollElementDsFilter extends AbstractTypeWithCodeDsFilter {

    private Long engineId;

    private Long engineId_From;
    private Long engineId_To;

    private String engine;

    private String engineType;

    private Long typeId;

    private Long typeId_From;
    private Long typeId_To;

    private String type;

    private String dataType;

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

    private String calculation;

    private Boolean balance;

    private String balanceFunction;

    private Long sourceElementId;

    private Long sourceElementId_From;
    private Long sourceElementId_To;

    private String sourceElement;

    private Long accItemId;

    private Long accItemId_From;
    private Long accItemId_To;

    private String accItem;

    public Long getEngineId() {
        return this.engineId;
    }

    public Long getEngineId_From() {
        return this.engineId_From;
    }

    public Long getEngineId_To() {
        return this.engineId_To;
    }

    public void setEngineId(Long engineId) {
        this.engineId = engineId;
    }

    public void setEngineId_From(Long engineId_From) {
        this.engineId_From = engineId_From;
    }

    public void setEngineId_To(Long engineId_To) {
        this.engineId_To = engineId_To;
    }

    public String getEngine() {
        return this.engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getEngineType() {
        return this.engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public Long getTypeId_From() {
        return this.typeId_From;
    }

    public Long getTypeId_To() {
        return this.typeId_To;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setTypeId_From(Long typeId_From) {
        this.typeId_From = typeId_From;
    }

    public void setTypeId_To(Long typeId_To) {
        this.typeId_To = typeId_To;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public Integer getSequenceNo_From() {
        return this.sequenceNo_From;
    }

    public Integer getSequenceNo_To() {
        return this.sequenceNo_To;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public void setSequenceNo_From(Integer sequenceNo_From) {
        this.sequenceNo_From = sequenceNo_From;
    }

    public void setSequenceNo_To(Integer sequenceNo_To) {
        this.sequenceNo_To = sequenceNo_To;
    }

    public String getCalculation() {
        return this.calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    public Boolean getBalance() {
        return this.balance;
    }

    public void setBalance(Boolean balance) {
        this.balance = balance;
    }

    public String getBalanceFunction() {
        return this.balanceFunction;
    }

    public void setBalanceFunction(String balanceFunction) {
        this.balanceFunction = balanceFunction;
    }

    public Long getSourceElementId() {
        return this.sourceElementId;
    }

    public Long getSourceElementId_From() {
        return this.sourceElementId_From;
    }

    public Long getSourceElementId_To() {
        return this.sourceElementId_To;
    }

    public void setSourceElementId(Long sourceElementId) {
        this.sourceElementId = sourceElementId;
    }

    public void setSourceElementId_From(Long sourceElementId_From) {
        this.sourceElementId_From = sourceElementId_From;
    }

    public void setSourceElementId_To(Long sourceElementId_To) {
        this.sourceElementId_To = sourceElementId_To;
    }

    public String getSourceElement() {
        return this.sourceElement;
    }

    public void setSourceElement(String sourceElement) {
        this.sourceElement = sourceElement;
    }

    public Long getAccItemId() {
        return this.accItemId;
    }

    public Long getAccItemId_From() {
        return this.accItemId_From;
    }

    public Long getAccItemId_To() {
        return this.accItemId_To;
    }

    public void setAccItemId(Long accItemId) {
        this.accItemId = accItemId;
    }

    public void setAccItemId_From(Long accItemId_From) {
        this.accItemId_From = accItemId_From;
    }

    public void setAccItemId_To(Long accItemId_To) {
        this.accItemId_To = accItemId_To;
    }

    public String getAccItem() {
        return this.accItem;
    }

    public void setAccItem(String accItem) {
        this.accItem = accItem;
    }

}
