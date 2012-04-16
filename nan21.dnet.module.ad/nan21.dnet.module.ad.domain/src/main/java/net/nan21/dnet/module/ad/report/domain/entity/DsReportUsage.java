/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** DsReportUsage. */
@Entity
@Table(name = DsReportUsage.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = DsReportUsage.NQ_FIND_BY_ID, query = "SELECT e FROM DsReportUsage e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = DsReportUsage.NQ_FIND_BY_IDS, query = "SELECT e FROM DsReportUsage e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class DsReportUsage extends AbstractAuditable {

    public static final String TABLE_NAME = "AD_DS_REPORT_USAGE";
    public static final String SEQUENCE_NAME = "AD_DS_REPORT_USAGE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "DsReportUsage.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "DsReportUsage.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** FrameName. */
    @Column(name = "FRAMENAME", length = 255)
    private String frameName;

    /** ToolbarKey. */
    @Column(name = "TOOLBARKEY", length = 400)
    private String toolbarKey;

    /** DcKey. */
    @Column(name = "DCKEY", length = 400)
    private String dcKey;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = DsReport.class)
    @JoinColumn(name = "DSREPORT_ID", referencedColumnName = "ID")
    private DsReport dsReport;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrameName() {
        return this.frameName;
    }

    public void setFrameName(String frameName) {
        this.frameName = frameName;
    }

    public String getToolbarKey() {
        return this.toolbarKey;
    }

    public void setToolbarKey(String toolbarKey) {
        this.toolbarKey = toolbarKey;
    }

    public String getDcKey() {
        return this.dcKey;
    }

    public void setDcKey(String dcKey) {
        this.dcKey = dcKey;
    }

    public DsReport getDsReport() {
        return this.dsReport;
    }

    public void setDsReport(DsReport dsReport) {
        this.dsReport = dsReport;
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
