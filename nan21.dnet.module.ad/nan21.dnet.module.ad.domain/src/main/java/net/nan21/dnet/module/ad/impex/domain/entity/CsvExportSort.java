/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.domain.entity;

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
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** CsvExportSort. */
@Entity
@Table(name = CsvExportSort.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = CsvExportSort.NQ_FIND_BY_ID, query = "SELECT e FROM CsvExportSort e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = CsvExportSort.NQ_FIND_BY_IDS, query = "SELECT e FROM CsvExportSort e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class CsvExportSort extends AbstractAuditable {

    public static final String TABLE_NAME = "AD_CSV_EXP_SORT";
    public static final String SEQUENCE_NAME = "AD_CSV_EXP_SORT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "CsvExportSort.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "CsvExportSort.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** SequenceNo. */
    @Column(name = "SEQUENCENO")
    private Integer sequenceNo;

    /** DsField. */
    @Column(name = "DSFIELD", length = 255)
    private String dsField;

    /** Descend. */
    @Column(name = "DESCEND", nullable = false)
    @NotNull
    private Boolean descend;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CsvExport.class)
    @JoinColumn(name = "CSVEXPORT_ID", referencedColumnName = "ID")
    private CsvExport csvExport;

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

    public String getDsField() {
        return this.dsField;
    }

    public void setDsField(String dsField) {
        this.dsField = dsField;
    }

    public Boolean getDescend() {
        return this.descend;
    }

    public void setDescend(Boolean descend) {
        this.descend = descend;
    }

    public CsvExport getCsvExport() {
        return this.csvExport;
    }

    public void setCsvExport(CsvExport csvExport) {
        if (csvExport != null) {
            this.__validate_client_context__(csvExport.getClientId());
        }
        this.csvExport = csvExport;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getDescend() == null) {
            event.updateAttributeWithObject("descend", false);
        }
    }

}
