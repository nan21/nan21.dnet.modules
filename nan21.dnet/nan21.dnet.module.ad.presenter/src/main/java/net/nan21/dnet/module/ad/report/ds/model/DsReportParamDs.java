/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.ad.report.domain.entity.DsReportParam;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = DsReportParam.class)
public class DsReportParamDs extends AbstractDsModel<DsReportParam> implements
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
    public static final String fDSREPORTID = "dsReportId";
    public static final String fREPORTID = "reportId";
    public static final String fREPORTCODE = "reportCode";
    public static final String fPARAMID = "paramId";
    public static final String fPARAMCODE = "paramCode";
    public static final String fPARAMNAME = "paramName";
    public static final String fDATASOURCE = "dataSource";
    public static final String fDSFIELD = "dsField";
    public static final String fSTATICVALUE = "staticValue";

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

    @DsField(join = "left", path = "dsReport.id")
    private Long dsReportId;

    @DsField(join = "left", path = "dsReport.report.id")
    private Long reportId;

    @DsField(join = "left", path = "dsReport.report.code")
    private String reportCode;

    @DsField(join = "left", path = "reportParam.id")
    private Long paramId;

    @DsField(join = "left", path = "reportParam.code")
    private String paramCode;

    @DsField(join = "left", path = "reportParam.name")
    private String paramName;

    @DsField(join = "left", path = "dsReport.dataSource")
    private String dataSource;

    @DsField()
    private String dsField;

    @DsField()
    private String staticValue;

    public DsReportParamDs() {
        super();
    }

    public DsReportParamDs(DsReportParam e) {
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

    public Long getDsReportId() {
        return this.dsReportId;
    }

    public void setDsReportId(Long dsReportId) {
        this.dsReportId = dsReportId;
    }

    public Long getReportId() {
        return this.reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReportCode() {
        return this.reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public Long getParamId() {
        return this.paramId;
    }

    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }

    public String getParamCode() {
        return this.paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getParamName() {
        return this.paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getDsField() {
        return this.dsField;
    }

    public void setDsField(String dsField) {
        this.dsField = dsField;
    }

    public String getStaticValue() {
        return this.staticValue;
    }

    public void setStaticValue(String staticValue) {
        this.staticValue = staticValue;
    }

}
