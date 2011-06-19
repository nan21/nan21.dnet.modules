/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.skill.ds.model.SkillLovDs;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

public class SkillLovDsConv extends AbstractDsConverter<SkillLovDs, Skill>
        implements IDsConverter<SkillLovDs, Skill> {

    protected void modelToEntityAttributes(SkillLovDs ds, Skill e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(SkillLovDs ds, Skill e)
            throws Exception {
    }

    @Override
    public void entityToModel(Skill e, SkillLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setRatingScaleId(((e.getRatingScale() != null)) ? e.getRatingScale()
                .getId() : null);
    }

}
