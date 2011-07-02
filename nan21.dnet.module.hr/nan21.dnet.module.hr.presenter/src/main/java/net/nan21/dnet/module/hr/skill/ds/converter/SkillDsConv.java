/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.skill.business.service.IRatingScaleService;
import net.nan21.dnet.module.hr.skill.business.service.ISkillTypeService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.skill.ds.model.SkillDs;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

public class SkillDsConv extends AbstractDsConverter<SkillDs, Skill> implements
        IDsConverter<SkillDs, Skill> {

    protected void modelToEntityAttributes(SkillDs ds, Skill e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(SkillDs ds, Skill e)
            throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((SkillType) this.em.getReference(SkillType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_SkillType(ds, e);
        }
        if (ds.getRatingScaleId() != null) {
            if (e.getRatingScale() == null
                    || !e.getRatingScale().getId()
                            .equals(ds.getRatingScaleId())) {
                e.setRatingScale((RatingScale) this.em.getReference(
                        RatingScale.class, ds.getRatingScaleId()));
            }
        } else {
            this.lookup_ratingScale_RatingScale(ds, e);
        }
    }

    protected void lookup_type_SkillType(SkillDs ds, Skill e) throws Exception {
        SkillType x = null;
        try {
            x = ((ISkillTypeService) getService(ISkillTypeService.class))
                    .findByName(ds.getClientId(), ds.getType());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setType(x);
    }

    protected void lookup_ratingScale_RatingScale(SkillDs ds, Skill e)
            throws Exception {
        RatingScale x = null;
        try {
            x = ((IRatingScaleService) getService(IRatingScaleService.class))
                    .findByName(ds.getClientId(), ds.getRatingScale());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setRatingScale(x);
    }

    @Override
    public void entityToModel(Skill e, SkillDs ds) throws Exception {
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
        ds.setRatingScaleId(((e.getRatingScale() != null)) ? e.getRatingScale()
                .getId() : null);
        ds.setRatingScale(((e.getRatingScale() != null)) ? e.getRatingScale()
                .getName() : null);
    }

}
