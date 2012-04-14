/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.ad.impex.domain.entity.ExportMapItem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ExportMapItem.class)
public class ExportMapItemDs extends AbstractAuditableDs<ExportMapItem> {

    public static final String fEXPORTMAPID = "exportMapId";
    public static final String fEXPORTMAP = "exportMap";
    public static final String fCSVEXPORTID = "csvExportId";
    public static final String fCSVEXPORT = "csvExport";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fFILENAME = "fileName";
    public static final String fACTIVE = "active";

    @DsField(join = "left", path = "exportMap.id")
    private Long exportMapId;

    @DsField(join = "left", path = "exportMap.name")
    private String exportMap;

    @DsField(join = "left", path = "csvExport.id")
    private Long csvExportId;

    @DsField(join = "left", path = "csvExport.name")
    private String csvExport;

    @DsField()
    private Integer sequenceNo;

    @DsField()
    private String fileName;

    @DsField()
    private Boolean active;

    public ExportMapItemDs() {
        super();
    }

    public ExportMapItemDs(ExportMapItem e) {
        super(e);
    }

    public Long getExportMapId() {
        return this.exportMapId;
    }

    public void setExportMapId(Long exportMapId) {
        this.exportMapId = exportMapId;
    }

    public String getExportMap() {
        return this.exportMap;
    }

    public void setExportMap(String exportMap) {
        this.exportMap = exportMap;
    }

    public Long getCsvExportId() {
        return this.csvExportId;
    }

    public void setCsvExportId(Long csvExportId) {
        this.csvExportId = csvExportId;
    }

    public String getCsvExport() {
        return this.csvExport;
    }

    public void setCsvExport(String csvExport) {
        this.csvExport = csvExport;
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

}
