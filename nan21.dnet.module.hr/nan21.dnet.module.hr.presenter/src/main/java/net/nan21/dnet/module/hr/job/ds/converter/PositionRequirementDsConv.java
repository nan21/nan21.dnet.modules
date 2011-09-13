/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.job.business.service.IWorkRequirementService;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.job.ds.model.PositionRequirementDs;
import net.nan21.dnet.module.hr.job.domain.entity.PositionRequirement;

public class PositionRequirementDsConv extends
        AbstractDsConverter<PositionRequirementDs, PositionRequirement>
        implements IDsConverter<PositionRequirementDs, PositionRequirement> {

    protected void modelToEntityAttributes(PositionRequirementDs ds,
            PositionRequirement e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setNotes(ds.getNotes());
    }

    protected void modelToEntityReferences(PositionRequirementDs ds,
            PositionRequirement e) throws Exception {

        if (ds.getPositionId() != null) {
            if (e.getPosition() == null
                    || !e.getPosition().getId().equals(ds.getPositionId())) {
                e.setPosition((Position) this.em.find(Position.class,
                        ds.getPositionId()));
            }
        }
        if (ds.getRequirementId() != null) {
            if (e.getRequirement() == null
                    || !e.getRequirement().getId()
                            .equals(ds.getRequirementId())) {
                e.setRequirement((WorkRequirement) this.em.find(
                        WorkRequirement.class, ds.getRequirementId()));
            }
        } else {
            this.lookup_requirement_WorkRequirement(ds, e);
        }
    }

    protected void lookup_requirement_WorkRequirement(PositionRequirementDs ds,
            PositionRequirement e) throws Exception {
        if (ds.getRequirement() != null && !ds.getRequirement().equals("")) {
            WorkRequirement x = null;
            try {
                x = ((IWorkRequirementService) getService(IWorkRequirementService.class))
                        .findByName(ds.getClientId(), ds.getRequirement());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `WorkRequirement` reference:  `requirement` = "
                                + ds.getRequirement() + "  ");
            }
            e.setRequirement(x);
        } else {
            e.setRequirement(null);
        }
    }

    @Override
    public void entityToModel(PositionRequirement e, PositionRequirementDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setNotes(e.getNotes());
        ds.setPositionId(((e.getPosition() != null)) ? e.getPosition().getId()
                : null);
        ds.setRequirementId(((e.getRequirement() != null)) ? e.getRequirement()
                .getId() : null);
        ds.setRequirement(((e.getRequirement() != null)) ? e.getRequirement()
                .getName() : null);
    }

}
