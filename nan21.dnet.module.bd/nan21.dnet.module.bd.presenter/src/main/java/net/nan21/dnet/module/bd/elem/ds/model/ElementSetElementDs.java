/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSetElement;

@Ds(entity = ElementSetElement.class)
public class ElementSetElementDs extends AbstractAuditableDs<ElementSetElement> {

    public static final String fELEMENTSETID = "elementSetId";
    public static final String fELEMENTSET = "elementSet";
    public static final String fENGINEID = "engineId";
    public static final String fENGINE = "engine";
    public static final String fENGINETYPE = "engineType";
    public static final String fELEMENTID = "elementId";
    public static final String fELEMENT = "element";
    public static final String fELEMENTNAME = "elementName";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fPRINTLABEL = "printLabel";

    @DsField(join = "left", path = "elementSet.id")
    private Long elementSetId;

    @DsField(join = "left", path = "elementSet.name")
    private String elementSet;

    @DsField(join = "left", path = "elementSet.engine.id")
    private Long engineId;

    @DsField(join = "left", path = "elementSet.engine.name")
    private String engine;

    @DsField(join = "left", path = "elementSet.engine.type")
    private String engineType;

    @DsField(join = "left", path = "element.id")
    private Long elementId;

    @DsField(join = "left", path = "element.code")
    private String element;

    @DsField(join = "left", path = "element.name")
    private String elementName;

    @DsField()
    private Integer sequenceNo;

    @DsField()
    private String printLabel;

    public ElementSetElementDs() {
        super();
    }

    public ElementSetElementDs(ElementSetElement e) {
        super(e);
    }

    public Long getElementSetId() {
        return this.elementSetId;
    }

    public void setElementSetId(Long elementSetId) {
        this.elementSetId = elementSetId;
    }

    public String getElementSet() {
        return this.elementSet;
    }

    public void setElementSet(String elementSet) {
        this.elementSet = elementSet;
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

    public String getPrintLabel() {
        return this.printLabel;
    }

    public void setPrintLabel(String printLabel) {
        this.printLabel = printLabel;
    }

}
