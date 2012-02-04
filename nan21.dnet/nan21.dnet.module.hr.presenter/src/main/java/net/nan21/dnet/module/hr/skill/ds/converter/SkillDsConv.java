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

    protected void modelToEntityReferences(SkillDs ds, Skill e)
            throws Exception {
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((SkillType) this.em.find(SkillType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_SkillType(ds, e);
        }
        if (ds.getRatingScaleId() != null) {
            if (e.getRatingScale() == null
                    || !e.getRatingScale().getId()
                            .equals(ds.getRatingScaleId())) {
                e.setRatingScale((RatingScale) this.em.find(RatingScale.class,
                        ds.getRatingScaleId()));
            }
        } else {
            this.lookup_ratingScale_RatingScale(ds, e);
        }
    }

    protected void lookup_type_SkillType(SkillDs ds, Skill e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            SkillType x = null;
            try {
                x = ((ISkillTypeService) findEntityService(SkillType.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `SkillType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

    protected void lookup_ratingScale_RatingScale(SkillDs ds, Skill e)
            throws Exception {
        if (ds.getRatingScale() != null && !ds.getRatingScale().equals("")) {
            RatingScale x = null;
            try {
                x = ((IRatingScaleService) findEntityService(RatingScale.class))
                        .findByName(ds.getClientId(), ds.getRatingScale());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `RatingScale` reference:  `ratingScale` = "
                                + ds.getRatingScale() + "  ");
            }
            e.setRatingScale(x);

        } else {
            e.setRatingScale(null);
        }
    }

}
