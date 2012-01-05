/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.uom.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class UomConversionDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private Long id_From;
    private Long id_To;

    private Long clientId;

    private Long clientId_From;
    private Long clientId_To;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private Long sourceId;

    private Long sourceId_From;
    private Long sourceId_To;

    private String sourceCode;

    private Long targetId;

    private Long targetId_From;
    private Long targetId_To;

    private String targetCode;

    private Float multiplyWith;

    private Float multiplyWith_From;
    private Float multiplyWith_To;

    private Float divideTo;

    private Float divideTo_From;
    private Float divideTo_To;

    private Boolean active;

    public Long getId() {
        return this.id;
    }

    public Long getId_From() {
        return this.id_From;
    }

    public Long getId_To() {
        return this.id_To;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public Long getClientId_From() {
        return this.clientId_From;
    }

    public Long getClientId_To() {
        return this.clientId_To;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setClientId_From(Long clientId_From) {
        this.clientId_From = clientId_From;
    }

    public void setClientId_To(Long clientId_To) {
        this.clientId_To = clientId_To;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getCreatedAt_From() {
        return this.createdAt_From;
    }

    public Date getCreatedAt_To() {
        return this.createdAt_To;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt_From(Date createdAt_From) {
        this.createdAt_From = createdAt_From;
    }

    public void setCreatedAt_To(Date createdAt_To) {
        this.createdAt_To = createdAt_To;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public Date getModifiedAt_From() {
        return this.modifiedAt_From;
    }

    public Date getModifiedAt_To() {
        return this.modifiedAt_To;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setModifiedAt_From(Date modifiedAt_From) {
        this.modifiedAt_From = modifiedAt_From;
    }

    public void setModifiedAt_To(Date modifiedAt_To) {
        this.modifiedAt_To = modifiedAt_To;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getSourceId() {
        return this.sourceId;
    }

    public Long getSourceId_From() {
        return this.sourceId_From;
    }

    public Long getSourceId_To() {
        return this.sourceId_To;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceId_From(Long sourceId_From) {
        this.sourceId_From = sourceId_From;
    }

    public void setSourceId_To(Long sourceId_To) {
        this.sourceId_To = sourceId_To;
    }

    public String getSourceCode() {
        return this.sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Long getTargetId() {
        return this.targetId;
    }

    public Long getTargetId_From() {
        return this.targetId_From;
    }

    public Long getTargetId_To() {
        return this.targetId_To;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public void setTargetId_From(Long targetId_From) {
        this.targetId_From = targetId_From;
    }

    public void setTargetId_To(Long targetId_To) {
        this.targetId_To = targetId_To;
    }

    public String getTargetCode() {
        return this.targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public Float getMultiplyWith() {
        return this.multiplyWith;
    }

    public Float getMultiplyWith_From() {
        return this.multiplyWith_From;
    }

    public Float getMultiplyWith_To() {
        return this.multiplyWith_To;
    }

    public void setMultiplyWith(Float multiplyWith) {
        this.multiplyWith = multiplyWith;
    }

    public void setMultiplyWith_From(Float multiplyWith_From) {
        this.multiplyWith_From = multiplyWith_From;
    }

    public void setMultiplyWith_To(Float multiplyWith_To) {
        this.multiplyWith_To = multiplyWith_To;
    }

    public Float getDivideTo() {
        return this.divideTo;
    }

    public Float getDivideTo_From() {
        return this.divideTo_From;
    }

    public Float getDivideTo_To() {
        return this.divideTo_To;
    }

    public void setDivideTo(Float divideTo) {
        this.divideTo = divideTo;
    }

    public void setDivideTo_From(Float divideTo_From) {
        this.divideTo_From = divideTo_From;
    }

    public void setDivideTo_To(Float divideTo_To) {
        this.divideTo_To = divideTo_To;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
