/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class ProdClassificationDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private String uuid;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private String entityFQN;

    private Long productId;

    private Long productId_From;
    private Long productId_To;

    private String productCode;

    private Long classificationSystemId;

    private Long classificationSystemId_From;
    private Long classificationSystemId_To;

    private String classificationSystem;

    private Long classificationId;

    private Long classificationId_From;
    private Long classificationId_To;

    private String classificationCode;

    private String classificationName;

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
    }

    public Long getProductId() {
        return this.productId;
    }

    public Long getProductId_From() {
        return this.productId_From;
    }

    public Long getProductId_To() {
        return this.productId_To;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductId_From(Long productId_From) {
        this.productId_From = productId_From;
    }

    public void setProductId_To(Long productId_To) {
        this.productId_To = productId_To;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Long getClassificationSystemId() {
        return this.classificationSystemId;
    }

    public Long getClassificationSystemId_From() {
        return this.classificationSystemId_From;
    }

    public Long getClassificationSystemId_To() {
        return this.classificationSystemId_To;
    }

    public void setClassificationSystemId(Long classificationSystemId) {
        this.classificationSystemId = classificationSystemId;
    }

    public void setClassificationSystemId_From(Long classificationSystemId_From) {
        this.classificationSystemId_From = classificationSystemId_From;
    }

    public void setClassificationSystemId_To(Long classificationSystemId_To) {
        this.classificationSystemId_To = classificationSystemId_To;
    }

    public String getClassificationSystem() {
        return this.classificationSystem;
    }

    public void setClassificationSystem(String classificationSystem) {
        this.classificationSystem = classificationSystem;
    }

    public Long getClassificationId() {
        return this.classificationId;
    }

    public Long getClassificationId_From() {
        return this.classificationId_From;
    }

    public Long getClassificationId_To() {
        return this.classificationId_To;
    }

    public void setClassificationId(Long classificationId) {
        this.classificationId = classificationId;
    }

    public void setClassificationId_From(Long classificationId_From) {
        this.classificationId_From = classificationId_From;
    }

    public void setClassificationId_To(Long classificationId_To) {
        this.classificationId_To = classificationId_To;
    }

    public String getClassificationCode() {
        return this.classificationCode;
    }

    public void setClassificationCode(String classificationCode) {
        this.classificationCode = classificationCode;
    }

    public String getClassificationName() {
        return this.classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

}
