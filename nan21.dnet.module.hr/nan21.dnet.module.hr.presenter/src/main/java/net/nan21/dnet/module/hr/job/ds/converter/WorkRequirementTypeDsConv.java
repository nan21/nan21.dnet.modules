/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.job.ds.model.WorkRequirementTypeDs;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirementType;

public class WorkRequirementTypeDsConv extends
        AbstractDsConverter<WorkRequirementTypeDs, WorkRequirementType>
        implements IDsConverter<WorkRequirementTypeDs, WorkRequirementType> {

    protected void modelToEntityAttributes(WorkRequirementTypeDs ds,
            WorkRequirementType e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(WorkRequirementTypeDs ds,
            WorkRequirementType e) throws Exception {
    }

    @Override
    public void entityToModel(WorkRequirementType e, WorkRequirementTypeDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
    }

}
