/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.job.ds.model.WorkRequirementTypeLovDs;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirementType;

public class WorkRequirementTypeLovDsConv extends
        AbstractDsConverter<WorkRequirementTypeLovDs, WorkRequirementType>
        implements IDsConverter<WorkRequirementTypeLovDs, WorkRequirementType> {

    protected void modelToEntityAttributes(WorkRequirementTypeLovDs ds,
            WorkRequirementType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(WorkRequirementTypeLovDs ds,
            WorkRequirementType e) throws Exception {
    }

    @Override
    public void entityToModel(WorkRequirementType e, WorkRequirementTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
