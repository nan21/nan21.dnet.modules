/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Position.class, sort = { @SortField(field = PositionDs.fNAME) })
public class PositionDs extends AbstractTypeWithCodeDs<Position> {

    public static final String fJOBID = "jobId";
    public static final String fJOBCODE = "jobCode";
    public static final String fORGID = "orgId";
    public static final String fORG = "org";

    @DsField(join = "left", path = "job.id")
    private Long jobId;

    @DsField(join = "left", path = "job.code")
    private String jobCode;

    @DsField(join = "left", path = "org.id")
    private Long orgId;

    @DsField(join = "left", path = "org.code")
    private String org;

    public PositionDs() {
        super();
    }

    public PositionDs(Position e) {
        super(e);
    }

    public Long getJobId() {
        return this.jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobCode() {
        return this.jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public Long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrg() {
        return this.org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

}
