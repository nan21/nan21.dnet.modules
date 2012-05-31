/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.job.business.service.IJobService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.job.ds.model.PositionDs;
import net.nan21.dnet.module.hr.job.domain.entity.Position;

public class PositionDsConv extends AbstractDsConverter<PositionDs, Position>
        implements IDsConverter<PositionDs, Position> {

    @Override
    protected void modelToEntityReferences(PositionDs ds, Position e,
            boolean isInsert) throws Exception {

        if (ds.getOrgId() != null) {
            if (e.getOrg() == null || !e.getOrg().getId().equals(ds.getOrgId())) {
                e.setOrg((Organization) this.em.find(Organization.class,
                        ds.getOrgId()));
            }
        } else {
            this.lookup_org_Organization(ds, e);
        }

        if (ds.getJobId() != null) {
            if (e.getJob() == null || !e.getJob().getId().equals(ds.getJobId())) {
                e.setJob((Job) this.em.find(Job.class, ds.getJobId()));
            }
        } else {
            this.lookup_job_Job(ds, e);
        }

    }

    protected void lookup_org_Organization(PositionDs ds, Position e)
            throws Exception {
        if (ds.getOrg() != null && !ds.getOrg().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByCode(ds.getOrg());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `org` = "
                                + ds.getOrg() + "  ");
            }
            e.setOrg(x);

        } else {
            e.setOrg(null);
        }
    }

    protected void lookup_job_Job(PositionDs ds, Position e) throws Exception {
        if (ds.getJobCode() != null && !ds.getJobCode().equals("")) {
            Job x = null;
            try {
                x = ((IJobService) findEntityService(Job.class)).findByCode(ds
                        .getJobCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Job` reference:  `jobCode` = "
                                + ds.getJobCode() + "  ");
            }
            e.setJob(x);

        } else {
            e.setJob(null);
        }
    }

}
