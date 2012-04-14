/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.hr.skill.domain.entity.SkillType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SkillType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = SkillTypeLovDs.fNAME) })
public class SkillTypeLovDs extends AbstractTypeLov<SkillType> {

    public SkillTypeLovDs() {
        super();
    }

    public SkillTypeLovDs(SkillType e) {
        super(e);
    }

}
