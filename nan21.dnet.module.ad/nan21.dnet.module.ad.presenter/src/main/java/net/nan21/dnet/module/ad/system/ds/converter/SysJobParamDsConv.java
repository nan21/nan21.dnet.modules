/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.system.business.service.ISysJobService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJob;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.system.ds.model.SysJobParamDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobParam;

public class SysJobParamDsConv extends
        AbstractDsConverter<SysJobParamDs, SysJobParam> implements
        IDsConverter<SysJobParamDs, SysJobParam> {

    @Override
    protected void modelToEntityReferences(SysJobParamDs ds, SysJobParam e,
            boolean isInsert) throws Exception {

        if (ds.getJobId() != null) {
            if (e.getJob() == null || !e.getJob().getId().equals(ds.getJobId())) {
                e.setJob((SysJob) this.em.find(SysJob.class, ds.getJobId()));
            }
        } else {
            this.lookup_job_SysJob(ds, e);
        }

    }

    protected void lookup_job_SysJob(SysJobParamDs ds, SysJobParam e)
            throws Exception {
        if (ds.getJob() != null && !ds.getJob().equals("")) {
            SysJob x = null;
            try {
                x = ((ISysJobService) findEntityService(SysJob.class))
                        .findByName(ds.getJob());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `SysJob` reference:  `job` = "
                                + ds.getJob() + "  ");
            }
            e.setJob(x);

        } else {
            e.setJob(null);
        }
    }

}
