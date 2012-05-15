/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.report.domain.entity;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import net.nan21.dnet.module.ad.report.domain.entity.Report;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** ReportParam. */
@Entity
@Table(name = ReportParam.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = ReportParam.TABLE_NAME + "_UK1", columnNames = {
                "CLIENTID", "REPORT_ID", "CODE" }),
        @UniqueConstraint(name = ReportParam.TABLE_NAME + "_UK2", columnNames = {
                "CLIENTID", "REPORT_ID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ReportParam.NQ_FIND_BY_ID, query = "SELECT e FROM ReportParam e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ReportParam.NQ_FIND_BY_IDS, query = "SELECT e FROM ReportParam e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ReportParam.NQ_FIND_BY_CODE, query = "SELECT e FROM ReportParam e WHERE e.clientId = :pClientId and  e.report = :pReport and e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ReportParam.findByCode_PRIMITIVE", query = "SELECT e FROM ReportParam e WHERE e.clientId = :pClientId and  e.report.id = :pReportId and e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ReportParam.NQ_FIND_BY_NAME, query = "SELECT e FROM ReportParam e WHERE e.clientId = :pClientId and  e.report = :pReport and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ReportParam.findByName_PRIMITIVE", query = "SELECT e FROM ReportParam e WHERE e.clientId = :pClientId and  e.report.id = :pReportId and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ReportParam extends AbstractTypeWithCode {

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

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** SequenceNo. */
    @Column(name = "SEQUENCENO", nullable = false)
    @NotNull
    private Integer sequenceNo;

    /** Mandatory. */
    @Column(name = "MANDATORY", nullable = false)
    @NotNull
    private Boolean mandatory;

    /** NoEdit. */
    @Column(name = "NOEDIT", nullable = false)
    @NotNull
    private Boolean noEdit;

    /** DataType. */
    @Column(name = "DATATYPE", nullable = false, length = 32)
    @NotBlank
    private String dataType;

    /** DefaultValue. */
    @Column(name = "DEFAULTVALUE", length = 400)
    private String defaultValue;

    /** ListOfValues. */
    @Column(name = "LISTOFVALUES", length = 400)
    private String listOfValues;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Report.class)
    @JoinColumn(name = "REPORT_ID", referencedColumnName = "ID")
    private Report report;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Boolean getMandatory() {
        return this.mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Boolean getNoEdit() {
        return this.noEdit;
    }

    public void setNoEdit(Boolean noEdit) {
        this.noEdit = noEdit;
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

    public String getListOfValues() {
        return this.listOfValues;
    }

    public void setListOfValues(String listOfValues) {
        this.listOfValues = listOfValues;
    }

    public Report getReport() {
        return this.report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getMandatory() == null) {
            event.updateAttributeWithObject("mandatory", false);
        }
        if (this.getNoEdit() == null) {
            event.updateAttributeWithObject("noEdit", false);
        }
        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
