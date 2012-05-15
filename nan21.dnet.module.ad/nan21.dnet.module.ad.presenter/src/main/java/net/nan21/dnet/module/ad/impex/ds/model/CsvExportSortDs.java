/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportSort;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CsvExportSort.class, sort = { @SortField(field = CsvExportSortDs.fSEQUENCENO) })
public class CsvExportSortDs extends AbstractAuditableDs<CsvExportSort> {

    public static final String fCSVEXPORTID = "csvExportId";
    public static final String fCSVEXPORT = "csvExport";
    public static final String fDATASOURCE = "dataSource";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fDSFIELD = "dsField";
    public static final String fDESCEND = "descend";

    @DsField(join = "left", path = "csvExport.id")
    private Long csvExportId;

    @DsField(join = "left", path = "csvExport.name")
    private String csvExport;

    @DsField(join = "left", path = "csvExport.dataSource")
    private String dataSource;

    @DsField()
    private Integer sequenceNo;

    @DsField()
    private String dsField;

    @DsField()
    private Boolean descend;

    public CsvExportSortDs() {
        super();
    }

    public CsvExportSortDs(CsvExportSort e) {
        super(e);
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

    public String getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
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

}
