/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillCategory;

@Ds(entity = SkillCategory.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = SkillCategoryLovDs.fNAME) })
public class SkillCategoryLovDs extends AbstractTypeLov<SkillCategory> {

    public SkillCategoryLovDs() {
        super();
    }

    public SkillCategoryLovDs(SkillCategory e) {
        super(e);
    }

}
