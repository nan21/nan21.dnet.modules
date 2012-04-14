/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.hr.payroll.domain.entity.ElementInput;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ElementInput.class)
public class ElementInputDs extends AbstractAuditableDs<ElementInput> {

    public static final String fELEMENTID = "elementId";
    public static final String fELEMENT = "element";
    public static final String fELEMENTNAME = "elementName";
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
