/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementInput;

@Ds(entity = ElementInput.class, sort = {
        @SortField(field = ElementInputDs.fENGINE),
        @SortField(field = ElementInputDs.fSEQUENCENO),
        @SortField(field = ElementInputDs.fREFERENCE) })
public class ElementInputDs extends AbstractAuditableDs<ElementInput> {

    public static final String fELEMENTID = "elementId";
    public static final String fELEMENT = "element";
    public static final String fELEMENTNAME = "elementName";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fENGINEID = "engineId";
    public static final String fENGINE = "engine";
    public static final String fENGINETYPE = "engineType";
    public static final String fREFERENCEID = "referenceId";
    public static final String fREFERENCE = "reference";
    public static final String fREFERENCENAME = "referenceName";
    public static final String fALIAS = "alias";

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

    @DsField(join = "left", path = "crossReference.id")
    private Long referenceId;

    @DsField(join = "left", path = "crossReference.code")
    private String reference;

    @DsField(join = "left", path = "crossReference.name")
    private String referenceName;

    @DsField()
    private String alias;

    public ElementInputDs() {
        super();
    }

    public ElementInputDs(ElementInput e) {
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

    public Long getReferenceId() {
        return this.referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferenceName() {
        return this.referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
