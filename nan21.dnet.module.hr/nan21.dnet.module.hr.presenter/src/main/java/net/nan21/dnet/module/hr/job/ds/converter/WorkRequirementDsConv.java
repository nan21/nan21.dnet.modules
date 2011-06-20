/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirementType;
import net.nan21.dnet.module.hr.job.domain.service.IWorkRequirementTypeService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.job.ds.model.WorkRequirementDs;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

public class WorkRequirementDsConv extends
        AbstractDsConverter<WorkRequirementDs, WorkRequirement> implements
        IDsConverter<WorkRequirementDs, WorkRequirement> {

    protected void modelToEntityAttributes(WorkRequirementDs ds,
            WorkRequirement e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(WorkRequirementDs ds,
            WorkRequirement e) throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((WorkRequirementType) this.em.getReference(
                        WorkRequirementType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_type_WorkRequirementType(ds, e);
        }
    }

    protected void lookup_type_WorkRequirementType(WorkRequirementDs ds,
            WorkRequirement e) throws Exception {
        WorkRequirementType x = null;
        try {
            x = ((IWorkRequirementTypeService) getService(IWorkRequirementTypeService.class))
                    .findByName(ds.getClientId(), ds.getType());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setType(x);
    }

    @Override
    public void entityToModel(WorkRequirement e, WorkRequirementDs ds)
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
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
    }

}
