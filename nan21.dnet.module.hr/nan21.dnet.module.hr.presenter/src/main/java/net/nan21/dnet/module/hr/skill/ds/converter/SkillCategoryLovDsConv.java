/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.skill.ds.model.SkillCategoryLovDs;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillCategory;

public class SkillCategoryLovDsConv extends
        AbstractDsConverter<SkillCategoryLovDs, SkillCategory> implements
        IDsConverter<SkillCategoryLovDs, SkillCategory> {

    protected void modelToEntityAttributes(SkillCategoryLovDs ds,
            SkillCategory e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(SkillCategoryLovDs ds,
            SkillCategory e) throws Exception {
    }

    @Override
    public void entityToModel(SkillCategory e, SkillCategoryLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
