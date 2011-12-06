/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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

    protected void modelToEntityReferences(PositionDs ds, Position e)
            throws Exception {
        if (ds.getOrganizationId() != null) {
            if (e.getOrganization() == null
                    || !e.getOrganization().getId()
                            .equals(ds.getOrganizationId())) {
                e.setOrganization((Organization) this.em.find(
                        Organization.class, ds.getOrganizationId()));
            }
        } else {
            this.lookup_organization_Organization(ds, e);
        }
        if (ds.getJobId() != null) {
            if (e.getJob() == null || !e.getJob().getId().equals(ds.getJobId())) {
                e.setJob((Job) this.em.find(Job.class, ds.getJobId()));
            }
        } else {
            this.lookup_job_Job(ds, e);
        }
    }

    protected void lookup_organization_Organization(PositionDs ds, Position e)
            throws Exception {
        if (ds.getOrganizationCode() != null
                && !ds.getOrganizationCode().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) getService(IOrganizationService.class))
                        .findByCode(ds.getClientId(), ds.getOrganizationCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `organizationCode` = "
                                + ds.getOrganizationCode() + "  ");
            }
            e.setOrganization(x);

        } else {
            e.setOrganization(null);
        }
    }

    protected void lookup_job_Job(PositionDs ds, Position e) throws Exception {
        if (ds.getJobCode() != null && !ds.getJobCode().equals("")) {
            Job x = null;
            try {
                x = ((IJobService) getService(IJobService.class)).findByCode(
                        ds.getClientId(), ds.getJobCode());
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
