/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportField;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CsvExportField.class, sort = { @SortField(field = CsvExportFieldDs.fSEQUENCENO) })
public class CsvExportFieldDs extends AbstractDsModel<CsvExportField> implements
        IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fUUID = "uuid";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fENTITYFQN = "entityFQN";
    public static final String fCSVEXPORTID = "csvExportId";
    public static final String fCSVEXPORT = "csvExport";
    public static final String fDATASOURCE = "dataSource";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fDSFIELD = "dsField";
    public static final String fALIAS = "alias";
    public static final String fACTIVE = "active";

    @DsField()
    private Long id;

    @DsField()
    private String uuid;

    @DsField()
    private Long clientId;

    @DsField()
    private Date createdAt;

    @DsField()
    private Date modifiedAt;

    @DsField()
    private String createdBy;

    @DsField()
    private String modifiedBy;

    @DsField()
    private Long version;

    @DsField(fetch = false, path = "className")
    private String entityFQN;

    @DsField(join = "left", path = "csvExport.id")
    private Long csvExportId;

    @DsField(join = "left", path = "csvExport.name")
    private String csvExport;

    @DsField(join = "left", path = "csvExport.dataSource")
    private String dataSource;

    @DsField()
    private Integer sequenceNo;

    @DsField()
    private String dsField;

    @DsField()
    private String alias;

    @DsField()
    private Boolean active;

    public CsvExportFieldDs() {
        super();
    }

    public CsvExportFieldDs(CsvExportField e) {
        super(e);
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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
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

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
    }

    public Long getCsvExportId() {
        return this.csvExportId;
    }

    public void setCsvExportId(Long csvExportId) {
        this.csvExportId = csvExportId;
    }

    public String getCsvExport() {
        return this.csvExport;
    }

    public void setCsvExport(String csvExport) {
        this.csvExport = csvExport;
    }

    public String getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getDsField() {
        return this.dsField;
    }

    public void setDsField(String dsField) {
        this.dsField = dsField;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
