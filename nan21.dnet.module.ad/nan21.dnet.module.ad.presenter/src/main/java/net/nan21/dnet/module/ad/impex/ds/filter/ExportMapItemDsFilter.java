/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class ExportMapItemDsFilter extends AbstractAuditableDsFilter {

    private Long exportMapId;

    private Long exportMapId_From;
    private Long exportMapId_To;

    private String exportMap;

    private Long csvExportId;

    private Long csvExportId_From;
    private Long csvExportId_To;

    private String csvExport;

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

    private String fileName;

    private String path;

    private Boolean active;

    public Long getExportMapId() {
        return this.exportMapId;
    }

    public Long getExportMapId_From() {
        return this.exportMapId_From;
    }

    public Long getExportMapId_To() {
        return this.exportMapId_To;
    }

    public void setExportMapId(Long exportMapId) {
        this.exportMapId = exportMapId;
    }

    public void setExportMapId_From(Long exportMapId_From) {
        this.exportMapId_From = exportMapId_From;
    }

    public void setExportMapId_To(Long exportMapId_To) {
        this.exportMapId_To = exportMapId_To;
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

    public Long getCsvExportId_From() {
        return this.csvExportId_From;
    }

    public Long getCsvExportId_To() {
        return this.csvExportId_To;
    }

    public void setCsvExportId(Long csvExportId) {
        this.csvExportId = csvExportId;
    }

    public void setCsvExportId_From(Long csvExportId_From) {
        this.csvExportId_From = csvExportId_From;
    }

    public void setCsvExportId_To(Long csvExportId_To) {
        this.csvExportId_To = csvExportId_To;
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

    public Integer getSequenceNo_From() {
        return this.sequenceNo_From;
    }

    public Integer getSequenceNo_To() {
        return this.sequenceNo_To;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public void setSequenceNo_From(Integer sequenceNo_From) {
        this.sequenceNo_From = sequenceNo_From;
    }

    public void setSequenceNo_To(Integer sequenceNo_To) {
        this.sequenceNo_To = sequenceNo_To;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
