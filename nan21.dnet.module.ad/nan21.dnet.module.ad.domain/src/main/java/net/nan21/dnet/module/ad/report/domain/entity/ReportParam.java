/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.ad.report.domain.entity.Report;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** ReportParam. */
@Entity
@Table(name = ReportParam.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = "AD_REPORT_PARAM_UK1", columnNames = {
                "CLIENTID", "REPORT_ID", "CODE" }),
        @UniqueConstraint(name = "AD_REPORT_PARAM_UK2", columnNames = {
                "CLIENTID", "REPORT_ID", "NAME" }) })
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = "ReportParam.findById", query = "SELECT e FROM ReportParam e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ReportParam.findByIds", query = "SELECT e FROM ReportParam e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ReportParam.findByCode", query = "SELECT e FROM ReportParam e WHERE e.clientId = :pClientId and  e.report = :pReport and e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ReportParam.findByCode_PRIMITIVE", query = "SELECT e FROM ReportParam e WHERE e.clientId = :pClientId and  e.report.id = :pReportId and e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ReportParam.findByName", query = "SELECT e FROM ReportParam e WHERE e.clientId = :pClientId and  e.report = :pReport and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ReportParam.findByName_PRIMITIVE", query = "SELECT e FROM ReportParam e WHERE e.clientId = :pClientId and  e.report.id = :pReportId and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ReportParam implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "AD_REPORT_PARAM";
    public static final String SEQUENCE_NAME = "AD_REPORT_PARAM_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ReportParam.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ReportParam.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "ReportParam.findByCode";

    /**
     * Named query find by unique key: Code using the ID field for references.
     */
    public static final String NQ_FIND_BY_CODE_PRIMITIVE = "ReportParam.findByCode_PRIMITIVE";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "ReportParam.findByName";

    /**
     * Named query find by unique key: Name using the ID field for references.
     */
    public static final String NQ_FIND_BY_NAME_PRIMITIVE = "ReportParam.findByName_PRIMITIVE";

    /** Mandatory. */
    @Column(name = "MANDATORY", nullable = false)
    @NotNull
    private Boolean mandatory;

    /** DataType. */
    @Column(name = "DATATYPE", nullable = false, length = 32)
    @NotBlank
    private String dataType;

    /** DefaultValue. */
    @Column(name = "DEFAULTVALUE", length = 400)
    private String defaultValue;

    /** Name. */
    @Column(name = "NAME", nullable = false, length = 255)
    @NotBlank
    private String name;

    /** Code. */
    @Column(name = "CODE", nullable = false, length = 32)
    @NotBlank
    private String code;

    /** Flag which indicates if this record is used.*/
    @Column(name = "ACTIVE", nullable = false)
    @NotNull
    private Boolean active;

    /** Notes about this record. */
    @Column(name = "NOTES", length = 4000)
    private String notes;

    /** Owner client */
    @Column(name = "CLIENTID", nullable = false)
    @NotNull
    private Long clientId;

    /** Timestamp when this record was created.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDAT", nullable = false)
    @NotNull
    private Date createdAt;

    /** Timestamp when this record was last modified.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIEDAT", nullable = false)
    @NotNull
    private Date modifiedAt;

    /** User who created this record.*/
    @Column(name = "CREATEDBY", nullable = false, length = 32)
    @NotBlank
    private String createdBy;

    /** User who last modified this record.*/
    @Column(name = "MODIFIEDBY", nullable = false, length = 32)
    @NotBlank
    private String modifiedBy;

    @Version
    /** Record version number used by the persistence framework. */
    @Column(name = "VERSION", nullable = false)
    @NotNull
    private Long version;

    /** System generated unique identifier */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Report.class)
    @JoinColumn(name = "REPORT_ID", referencedColumnName = "ID")
    private Report report;

    /* ============== getters - setters ================== */

    public Boolean getMandatory() {
        return this.mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    public String getClassName() {
        return this.getClass().getCanonicalName();
    }

    public void setClassName(String className) {

    }

    public Report getReport() {
        return this.report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public void aboutToInsert(DescriptorEvent event) {
        event.updateAttributeWithObject("createdAt", new Date());
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("createdBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("clientId", Session.user.get()
                .getClientId());
        if (this.mandatory == null) {
            event.updateAttributeWithObject("mandatory", false);
        }
        if (this.active == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        ReportParam e = (ReportParam) event.getSource();
        e.setModifiedAt(new Date());
        e.setModifiedBy(Session.user.get().getUsername());

    }

}
