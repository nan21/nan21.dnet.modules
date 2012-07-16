/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;

@Ds(entity = PayrollElement.class, sort = { @SortField(field = PayrollElementDs.fNAME) })
public class PayrollElementDs extends AbstractTypeWithCodeDs<PayrollElement> {

    public static final String fENGINEID = "engineId";
    public static final String fENGINE = "engine";
    public static final String fENGINETYPE = "engineType";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fDATATYPE = "dataType";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fCALCULATION = "calculation";
    public static final String fBALANCE = "balance";
    public static final String fBALANCEFUNCTION = "balanceFunction";
    public static final String fSOURCEELEMENTID = "sourceElementId";
    public static final String fSOURCEELEMENT = "sourceElement";
    public static final String fACCITEMID = "accItemId";
    public static final String fACCITEM = "accItem";

    @DsField(join = "left", path = "engine.id")
    private Long engineId;

    @DsField(join = "left", path = "engine.name")
    private String engine;

    @DsField(join = "left", path = "engine.type")
    private String engineType;

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    @DsField()
    private String dataType;

    @DsField()
    private Integer sequenceNo;

    @DsField()
    private String calculation;

    @DsField()
    private Boolean balance;

    @DsField()
    private String balanceFunction;

    @DsField(join = "left", path = "sourceElement.id")
    private Long sourceElementId;

    @DsField(join = "left", path = "sourceElement.code")
    private String sourceElement;

    @DsField(join = "left", path = "accItem.id")
    private Long accItemId;

    @DsField(join = "left", path = "accItem.name")
    private String accItem;

    public PayrollElementDs() {
        super();
    }

    public PayrollElementDs(PayrollElement e) {
        super(e);
    }

    public Long getEngineId() {
        return this.engineId;
    }

    public void setEngineId(Long engineId) {
        this.engineId = engineId;
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

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
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

    public void setSourceElementId(Long sourceElementId) {
        this.sourceElementId = sourceElementId;
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

    public void setAccItemId(Long accItemId) {
        this.accItemId = accItemId;
    }

    public String getAccItem() {
        return this.accItem;
    }

    public void setAccItem(String accItem) {
        this.accItem = accItem;
    }

}
