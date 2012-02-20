/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.skill.business.service.ISkillCategoryService;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillCategory;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.skill.ds.model.SkillTypeDs;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillType;

public class SkillTypeDsConv extends
        AbstractDsConverter<SkillTypeDs, SkillType> implements
        IDsConverter<SkillTypeDs, SkillType> {

    @Override
    protected void modelToEntityReferences(SkillTypeDs ds, SkillType e,
            boolean isInsert) throws Exception {

        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((SkillCategory) this.em.find(SkillCategory.class,
                        ds.getCategoryId()));
            }
        } else {
            this.lookup_category_SkillCategory(ds, e);
        }

    }

    protected void lookup_category_SkillCategory(SkillTypeDs ds, SkillType e)
            throws Exception {
        if (ds.getCategory() != null && !ds.getCategory().equals("")) {
            SkillCategory x = null;
            try {
                x = ((ISkillCategoryService) findEntityService(SkillCategory.class))
                        .findByName(ds.getCategory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `SkillCategory` reference:  `category` = "
                                + ds.getCategory() + "  ");
            }
            e.setCategory(x);

        } else {
            e.setCategory(null);
        }
    }

}
