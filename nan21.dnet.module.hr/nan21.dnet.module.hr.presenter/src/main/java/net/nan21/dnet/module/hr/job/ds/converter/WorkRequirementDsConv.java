/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.job.business.service.IWorkRequirementTypeService;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirementType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.job.ds.model.WorkRequirementDs;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

public class WorkRequirementDsConv extends
        AbstractDsConverter<WorkRequirementDs, WorkRequirement> implements
        IDsConverter<WorkRequirementDs, WorkRequirement> {

    @Override
    protected void modelToEntityReferences(WorkRequirementDs ds,
            WorkRequirement e, boolean isInsert) throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((WorkRequirementType) this.em.find(
                        WorkRequirementType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_type_WorkRequirementType(ds, e);
        }

    }

    protected void lookup_type_WorkRequirementType(WorkRequirementDs ds,
            WorkRequirement e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            WorkRequirementType x = null;
            try {
                x = ((IWorkRequirementTypeService) findEntityService(WorkRequirementType.class))
                        .findByName(ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `WorkRequirementType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

}
