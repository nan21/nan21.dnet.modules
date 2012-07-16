/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementFormula;

@Ds(entity = ElementFormula.class, sort = {
        @SortField(field = ElementFormulaDs.fENGINE),
        @SortField(field = ElementFormulaDs.fSEQUENCENO),
        @SortField(field = ElementFormulaDs.fVALIDFROM, desc = true) })
public class ElementFormulaDs extends AbstractAuditableDs<ElementFormula> {

    public static final String fELEMENTID = "elementId";
    public static final String fELEMENT = "element";
    public static final String fELEMENTNAME = "elementName";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fENGINEID = "engineId";
    public static final String fENGINE = "engine";
    public static final String fENGINETYPE = "engineType";
    public static final String fVALIDFROM = "validFrom";
    public static final String fVALIDTO = "validTo";
    public static final String fSTATICVALUE = "staticValue";
    public static final String fEXPRESSION = "expression";

    @DsField(join = "left", path = "element.id")
    private Long elementId;

    @DsField(join = "left", path = "element.code")
    private String element;

    @DsField(join = "left", path = "element.name")
    private String elementName;

    @DsField(join = "left", path = "element.sequenceNo")
    private Integer sequenceNo;

    @DsField(join = "left", path = "element.engine.id")
    private Long engineId;

    @DsField(join = "left", path = "element.engine.name")
    private String engine;

    @DsField(join = "left", path = "element.engine.type")
    private String engineType;

    @DsField()
    private Date validFrom;

    @DsField()
    private Date validTo;

    @DsField()
    private Boolean staticValue;

    @DsField()
    private String expression;

    public ElementFormulaDs() {
        super();
    }

    public ElementFormulaDs(ElementFormula e) {
        super(e);
    }

    public Long getElementId() {
        return this.elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public String getElement() {
        return this.element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getElementName() {
        return this.elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
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

    public Date getValidFrom() {
        return this.validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Boolean getStaticValue() {
        return this.staticValue;
    }

    public void setStaticValue(Boolean staticValue) {
        this.staticValue = staticValue;
    }

    public String getExpression() {
        return this.expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

}
