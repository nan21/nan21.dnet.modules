/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class ExportMapItemDsFilter extends AbstractDsFilter implements
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

    private Long exportMapId;

    private Long exportMapId_From;
    private Long exportMapId_To;

    private String exportMap;

    private Long csvExportId;

    private Long csvExportId_From;
    private Long csvExportId_To;

    private String csvExport;

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

    private String fileName;

    private Boolean active;

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

    public Long getExportMapId() {
        return this.exportMapId;
    }

    public Long getExportMapId_From() {
        return this.exportMapId_From;
    }

    public Long getExportMapId_To() {
        return this.exportMapId_To;
    }

    public void setExportMapId(Long exportMapId) {
        this.exportMapId = exportMapId;
    }

    public void setExportMapId_From(Long exportMapId_From) {
        this.exportMapId_From = exportMapId_From;
    }

    public void setExportMapId_To(Long exportMapId_To) {
        this.exportMapId_To = exportMapId_To;
    }

    public String getExportMap() {
        return this.exportMap;
    }

    public void setExportMap(String exportMap) {
        this.exportMap = exportMap;
    }

    public Long getCsvExportId() {
        return this.csvExportId;
    }

    public Long getCsvExportId_From() {
        return this.csvExportId_From;
    }

    public Long getCsvExportId_To() {
        return this.csvExportId_To;
    }

    public void setCsvExportId(Long csvExportId) {
        this.csvExportId = csvExportId;
    }

    public void setCsvExportId_From(Long csvExportId_From) {
        this.csvExportId_From = csvExportId_From;
    }

    public void setCsvExportId_To(Long csvExportId_To) {
        this.csvExportId_To = csvExportId_To;
    }

    public String getCsvExport() {
        return this.csvExport;
    }

    public void setCsvExport(String csvExport) {
        this.csvExport = csvExport;
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

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
