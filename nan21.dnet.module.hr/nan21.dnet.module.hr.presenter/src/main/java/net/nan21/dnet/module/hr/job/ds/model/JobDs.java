/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Job.class, sort = { @SortField(field = JobDs.fNAME) })
public class JobDs extends AbstractTypeWithCodeDs<Job> {

    public static final String fVALIDFROM = "validFrom";
    public static final String fVALIDTO = "validTo";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";

    @DsField()
    private Date validFrom;

    @DsField()
    private Date validTo;

    @DsField(join = "left", path = "jobType.id")
    private Long typeId;

    @DsField(join = "left", path = "jobType.name")
    private String type;

    public JobDs() {
        super();
    }

    public JobDs(Job e) {
        super(e);
    }

    public Date getValidFrom() {
        return this.validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
