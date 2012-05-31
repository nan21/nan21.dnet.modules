/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.elem.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class ElementInputDsFilter extends AbstractAuditableDsFilter {

    private Long elementId;

    private Long elementId_From;
    private Long elementId_To;

    private String element;

    private String elementName;

    private Long referenceId;

    private Long referenceId_From;
    private Long referenceId_To;

    private String reference;

    private String referenceName;

    private String alias;

    public Long getElementId() {
        return this.elementId;
    }

    public Long getElementId_From() {
        return this.elementId_From;
    }

    public Long getElementId_To() {
        return this.elementId_To;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public void setElementId_From(Long elementId_From) {
        this.elementId_From = elementId_From;
    }

    public void setElementId_To(Long elementId_To) {
        this.elementId_To = elementId_To;
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

    public Long getReferenceId_From() {
        return this.referenceId_From;
    }

    public Long getReferenceId_To() {
        return this.referenceId_To;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public void setReferenceId_From(Long referenceId_From) {
        this.referenceId_From = referenceId_From;
    }

    public void setReferenceId_To(Long referenceId_To) {
        this.referenceId_To = referenceId_To;
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
