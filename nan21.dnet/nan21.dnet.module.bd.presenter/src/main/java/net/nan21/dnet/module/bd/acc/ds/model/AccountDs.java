/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.acc.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Account.class, sort = { @SortField(field = AccountDs.fNAME) })
public class AccountDs extends AbstractDsModel<Account> implements
        IModelWithId, IModelWithClientId {

    public static final String fNAME = "name";
    public static final String fCODE = "code";
    public static final String fACTIVE = "active";
    public static final String fNOTES = "notes";
    public static final String fID = "id";
    public static final String fUUID = "uuid";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fENTITYFQN = "entityFQN";
    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fACCGROUPID = "accGroupId";
    public static final String fACCGROUP = "accGroup";
    public static final String fSIGN = "sign";
    public static final String fSUMMARY = "summary";

    @DsField()
    private String name;

    @DsField()
    private String code;

    @DsField()
    private Boolean active;

    @DsField()
    private String notes;

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

    @DsField(join = "left", path = "accSchema.id")
    private Long accSchemaId;

    @DsField(join = "left", path = "accSchema.code")
    private String accSchema;

    @DsField(join = "left", path = "accGroup.id")
    private Long accGroupId;

    @DsField(join = "left", path = "accGroup.code")
    private String accGroup;

    @DsField()
    private String sign;

    @DsField()
    private Boolean summary;

    public AccountDs() {
        super();
    }

    public AccountDs(Account e) {
        super(e);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public Long getAccSchemaId() {
        return this.accSchemaId;
    }

    public void setAccSchemaId(Long accSchemaId) {
        this.accSchemaId = accSchemaId;
    }

    public String getAccSchema() {
        return this.accSchema;
    }

    public void setAccSchema(String accSchema) {
        this.accSchema = accSchema;
    }

    public Long getAccGroupId() {
        return this.accGroupId;
    }

    public void setAccGroupId(Long accGroupId) {
        this.accGroupId = accGroupId;
    }

    public String getAccGroup() {
        return this.accGroup;
    }

    public void setAccGroup(String accGroup) {
        this.accGroup = accGroup;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Boolean getSummary() {
        return this.summary;
    }

    public void setSummary(Boolean summary) {
        this.summary = summary;
    }

}
