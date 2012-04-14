/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.ad.impex.domain.entity.ExportJobItem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ExportJobItem.class, sort = { @SortField(field = ExportJobItemDs.fSEQUENCENO) })
public class ExportJobItemDs extends AbstractAuditableDs<ExportJobItem> {

    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fACTIVE = "active";
    public static final String fJOBID = "jobId";
    public static final String fJOBNAME = "jobName";
    public static final String fMAPID = "mapId";
    public static final String fMAPNAME = "mapName";

    @DsField()
    private Integer sequenceNo;

    @DsField()
    private Boolean active;

    @DsField(join = "left", path = "job.id")
    private Long jobId;

    @DsField(join = "left", path = "job.name")
    private String jobName;

    @DsField(join = "left", path = "map.id")
    private Long mapId;

    @DsField(join = "left", path = "map.name")
    private String mapName;

    public ExportJobItemDs() {
        super();
    }

    public ExportJobItemDs(ExportJobItem e) {
        super(e);
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getJobId() {
        return this.jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Long getMapId() {
        return this.mapId;
    }

    public void setMapId(Long mapId) {
        this.mapId = mapId;
    }

    public String getMapName() {
        return this.mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

}
