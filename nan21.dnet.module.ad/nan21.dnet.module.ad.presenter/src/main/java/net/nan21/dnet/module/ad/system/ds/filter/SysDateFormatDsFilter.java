/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class SysDateFormatDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private String name;

    private Boolean active;

    private String description;

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

    private String extjsDateFormat;

    private String extjsTimeFormat;

    private String extjsDateTimeFormat;

    private String extjsAltFormats;

    private String javaDateFormat;

    private String javaTimeFormat;

    private String javaDateTimeFormat;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getExtjsDateFormat() {
        return this.extjsDateFormat;
    }

    public void setExtjsDateFormat(String extjsDateFormat) {
        this.extjsDateFormat = extjsDateFormat;
    }

    public String getExtjsTimeFormat() {
        return this.extjsTimeFormat;
    }

    public void setExtjsTimeFormat(String extjsTimeFormat) {
        this.extjsTimeFormat = extjsTimeFormat;
    }

    public String getExtjsDateTimeFormat() {
        return this.extjsDateTimeFormat;
    }

    public void setExtjsDateTimeFormat(String extjsDateTimeFormat) {
        this.extjsDateTimeFormat = extjsDateTimeFormat;
    }

    public String getExtjsAltFormats() {
        return this.extjsAltFormats;
    }

    public void setExtjsAltFormats(String extjsAltFormats) {
        this.extjsAltFormats = extjsAltFormats;
    }

    public String getJavaDateFormat() {
        return this.javaDateFormat;
    }

    public void setJavaDateFormat(String javaDateFormat) {
        this.javaDateFormat = javaDateFormat;
    }

    public String getJavaTimeFormat() {
        return this.javaTimeFormat;
    }

    public void setJavaTimeFormat(String javaTimeFormat) {
        this.javaTimeFormat = javaTimeFormat;
    }

    public String getJavaDateTimeFormat() {
        return this.javaDateTimeFormat;
    }

    public void setJavaDateTimeFormat(String javaDateTimeFormat) {
        this.javaDateTimeFormat = javaDateTimeFormat;
    }

}