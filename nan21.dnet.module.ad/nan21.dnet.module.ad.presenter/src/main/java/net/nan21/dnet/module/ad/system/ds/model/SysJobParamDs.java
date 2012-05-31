/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.system.domain.entity.SysJobParam;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysJobParam.class, sort = { @SortField(field = SysJobParamDs.fNAME) })
public class SysJobParamDs extends AbstractTypeDs<SysJobParam> {

    public static final String fJOBID = "jobId";
    public static final String fJOB = "job";
    public static final String fDATATYPE = "dataType";

    @DsField(join = "left", path = "job.id")
    private Long jobId;

    @DsField(join = "left", path = "job.name")
    private String job;

    @DsField()
    private String dataType;

    public SysJobParamDs() {
        super();
    }

    public SysJobParamDs(SysJobParam e) {
        super(e);
    }

    public Long getJobId() {
        return this.jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

}
