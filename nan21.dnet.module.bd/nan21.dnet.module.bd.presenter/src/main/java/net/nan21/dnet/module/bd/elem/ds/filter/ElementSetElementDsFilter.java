/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class ElementSetElementDsFilter extends AbstractAuditableDsFilter {

    private Long elementSetId;

    private Long elementSetId_From;
    private Long elementSetId_To;

    private String elementSet;

    private Long engineId;

    private Long engineId_From;
    private Long engineId_To;

    private String engine;

    private String engineType;

    private Long elementId;

    private Long elementId_From;
    private Long elementId_To;

    private String element;

    private String elementName;

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

    private String printLabel;

    public Long getElementSetId() {
        return this.elementSetId;
    }

    public Long getElementSetId_From() {
        return this.elementSetId_From;
    }

    public Long getElementSetId_To() {
        return this.elementSetId_To;
    }

    public void setElementSetId(Long elementSetId) {
        this.elementSetId = elementSetId;
    }

    public void setElementSetId_From(Long elementSetId_From) {
        this.elementSetId_From = elementSetId_From;
    }

    public void setElementSetId_To(Long elementSetId_To) {
        this.elementSetId_To = elementSetId_To;
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

    public String getPrintLabel() {
        return this.printLabel;
    }

    public void setPrintLabel(String printLabel) {
        this.printLabel = printLabel;
    }

}
