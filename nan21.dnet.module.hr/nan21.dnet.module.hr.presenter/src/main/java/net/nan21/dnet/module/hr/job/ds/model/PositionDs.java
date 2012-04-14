/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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
    public static final String fORGANIZATIONID = "organizationId";
    public static final String fORGANIZATIONCODE = "organizationCode";

    @DsField(join = "left", path = "job.id")
    private Long jobId;

    @DsField(join = "left", path = "job.code")
    private String jobCode;

    @DsField(join = "left", path = "organization.id")
    private Long organizationId;

    @DsField(join = "left", path = "organization.code")
    private String organizationCode;

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

    public Long getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationCode() {
        return this.organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

}
