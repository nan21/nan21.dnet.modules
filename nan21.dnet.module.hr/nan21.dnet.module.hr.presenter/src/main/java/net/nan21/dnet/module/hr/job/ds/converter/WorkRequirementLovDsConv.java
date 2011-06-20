/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.job.ds.model.WorkRequirementLovDs;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

public class WorkRequirementLovDsConv extends
        AbstractDsConverter<WorkRequirementLovDs, WorkRequirement> implements
        IDsConverter<WorkRequirementLovDs, WorkRequirement> {

    protected void modelToEntityAttributes(WorkRequirementLovDs ds,
            WorkRequirement e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(WorkRequirementLovDs ds,
            WorkRequirement e) throws Exception {
    }

    @Override
    public void entityToModel(WorkRequirement e, WorkRequirementLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
