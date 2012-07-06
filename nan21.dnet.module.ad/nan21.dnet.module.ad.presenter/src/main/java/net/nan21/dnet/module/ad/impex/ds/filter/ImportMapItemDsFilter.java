/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class ImportMapItemDsFilter extends AbstractAuditableDsFilter {

    private Long importMapId;

    private Long importMapId_From;
    private Long importMapId_To;

    private String importMapName;

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

    private String dataSource;

    private String path;

    private String fileName;

    private String ukFieldName;

    private Boolean active;

    public Long getImportMapId() {
        return this.importMapId;
    }

    public Long getImportMapId_From() {
        return this.importMapId_From;
    }

    public Long getImportMapId_To() {
        return this.importMapId_To;
    }

    public void setImportMapId(Long importMapId) {
        this.importMapId = importMapId;
    }

    public void setImportMapId_From(Long importMapId_From) {
        this.importMapId_From = importMapId_From;
    }

    public void setImportMapId_To(Long importMapId_To) {
        this.importMapId_To = importMapId_To;
    }

    public String getImportMapName() {
        return this.importMapName;
    }

    public void setImportMapName(String importMapName) {
        this.importMapName = importMapName;
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

    public String getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUkFieldName() {
        return this.ukFieldName;
    }

    public void setUkFieldName(String ukFieldName) {
        this.ukFieldName = ukFieldName;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
