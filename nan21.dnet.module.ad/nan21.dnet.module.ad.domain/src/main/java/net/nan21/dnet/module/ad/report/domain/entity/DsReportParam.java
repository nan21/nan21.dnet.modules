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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** DsReportParam. */
@Entity
@Table(name = DsReportParam.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = DsReportParam.NQ_FIND_BY_ID, query = "SELECT e FROM DsReportParam e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = DsReportParam.NQ_FIND_BY_IDS, query = "SELECT e FROM DsReportParam e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class DsReportParam extends AbstractAuditable {

    public static final String TABLE_NAME = "AD_DS_REPORT_PARAM";
    public static final String SEQUENCE_NAME = "AD_DS_REPORT_PARAM_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "DsReportParam.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "DsReportParam.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Reference to the data-source field. 
     */
    @Column(name = "DSFIELD", length = 255)
    private String dsField;

    /** StaticValue. */
    @Column(name = "STATICVALUE", length = 400)
    private String staticValue;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = DsReport.class)
    @JoinColumn(name = "DSREPORT_ID", referencedColumnName = "ID")
    private DsReport dsReport;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ReportParam.class)
    @JoinColumn(name = "REPORTPARAM_ID", referencedColumnName = "ID")
    private ReportParam reportParam;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public DsReport getDsReport() {
        return this.dsReport;
    }

    public void setDsReport(DsReport dsReport) {
        this.dsReport = dsReport;
    }

    public ReportParam getReportParam() {
        return this.reportParam;
    }

    public void setReportParam(ReportParam reportParam) {
        this.reportParam = reportParam;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
