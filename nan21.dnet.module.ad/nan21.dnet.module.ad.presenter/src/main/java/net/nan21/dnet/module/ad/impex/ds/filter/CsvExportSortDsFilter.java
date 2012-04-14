/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class CsvExportSortDsFilter extends AbstractAuditableDsFilter {

    private Long csvExportId;

    private Long csvExportId_From;
    private Long csvExportId_To;

    private String csvExport;

    private String dataSource;

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

    private String dsField;

    private Boolean descend;

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

    public String getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
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

}
