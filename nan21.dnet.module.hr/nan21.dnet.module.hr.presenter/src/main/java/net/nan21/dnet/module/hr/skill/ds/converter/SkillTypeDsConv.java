/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillCategory;
import net.nan21.dnet.module.hr.skill.domain.service.ISkillCategoryService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.skill.ds.model.SkillTypeDs;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillType;

public class SkillTypeDsConv extends
        AbstractDsConverter<SkillTypeDs, SkillType> implements
        IDsConverter<SkillTypeDs, SkillType> {

    protected void modelToEntityAttributes(SkillTypeDs ds, SkillType e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(SkillTypeDs ds, SkillType e)
            throws Exception {

        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((SkillCategory) this.em.getReference(
                        SkillCategory.class, ds.getCategoryId()));
            }
        } else {
            this.lookup_category_SkillCategory(ds, e);
        }
    }

    protected void lookup_category_SkillCategory(SkillTypeDs ds, SkillType e)
            throws Exception {
        SkillCategory x = null;
        try {
            x = ((ISkillCategoryService) getService(ISkillCategoryService.class))
                    .findByName(ds.getClientId(), ds.getCategory());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setCategory(x);
    }

    @Override
    public void entityToModel(SkillType e, SkillTypeDs ds) throws Exception {
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
        ds.setCategoryId(((e.getCategory() != null)) ? e.getCategory().getId()
                : null);
        ds.setCategory(((e.getCategory() != null)) ? e.getCategory().getName()
                : null);
    }

}
