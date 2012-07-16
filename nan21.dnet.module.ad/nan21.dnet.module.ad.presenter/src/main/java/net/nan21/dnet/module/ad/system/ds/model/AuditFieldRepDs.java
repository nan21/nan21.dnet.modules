/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractSimpleDs;
import net.nan21.dnet.module.ad.system.domain.entity.AuditField;

@Ds(entity = AuditField.class)
public class AuditFieldRepDs extends AbstractSimpleDs<AuditField> {

    public static final String fOPERATION = "operation";
    public static final String fSOURCEFQN = "sourceFQN";
    public static final String fSOURCEID = "sourceId";
    public static final String fFIELDNAME = "fieldName";
    public static final String fOLDVALUE = "oldValue";
    public static final String fNEWVALUE = "newValue";
    public static final String fCREATEDAT = "createdAt";
    public static final String fCREATEDBY = "createdBy";

    @DsField(join = "left", path = "auditEntry.operation")
    private String operation;

    @DsField(join = "left", path = "auditEntry.sourceFQN")
    private String sourceFQN;

    @DsField(join = "left", path = "auditEntry.sourceId")
    private String sourceId;

    @DsField()
    private String fieldName;

    @DsField()
    private String oldValue;

    @DsField()
    private String newValue;

    @DsField()
    private Date createdAt;

    @DsField()
    private String createdBy;

    public AuditFieldRepDs() {
        super();
    }

    public AuditFieldRepDs(AuditField e) {
        super(e);
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getSourceFQN() {
        return this.sourceFQN;
    }

    public void setSourceFQN(String sourceFQN) {
        this.sourceFQN = sourceFQN;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getOldValue() {
        return this.oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return this.newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}
