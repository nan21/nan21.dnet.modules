/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.domain.entity;

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
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** ExportMapItem. */
@Entity
@Table(name = ExportMapItem.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ExportMapItem.NQ_FIND_BY_ID, query = "SELECT e FROM ExportMapItem e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ExportMapItem.NQ_FIND_BY_IDS, query = "SELECT e FROM ExportMapItem e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ExportMapItem extends AbstractAuditable {

    public static final String TABLE_NAME = "AD_EXP_MAP_ITEM";
    public static final String SEQUENCE_NAME = "AD_EXP_MAP_ITEM_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ExportMapItem.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ExportMapItem.findByIds";

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

    /** FileName. */
    @Column(name = "FILENAME", length = 255)
    private String fileName;

    /** Active. */
    @Column(name = "ACTIVE", nullable = false)
    @NotNull
    private Boolean active;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ExportMap.class)
    @JoinColumn(name = "EXPORTMAP_ID", referencedColumnName = "ID")
    private ExportMap exportMap;
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

    public ExportMap getExportMap() {
        return this.exportMap;
    }

    public void setExportMap(ExportMap exportMap) {
        this.exportMap = exportMap;
    }

    public CsvExport getCsvExport() {
        return this.csvExport;
    }

    public void setCsvExport(CsvExport csvExport) {
        this.csvExport = csvExport;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.active == null) {
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
