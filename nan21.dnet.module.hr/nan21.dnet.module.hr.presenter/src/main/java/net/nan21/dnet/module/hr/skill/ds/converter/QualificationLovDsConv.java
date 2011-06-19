/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.skill.ds.model.QualificationLovDs;
import net.nan21.dnet.module.hr.skill.domain.entity.Qualification;

public class QualificationLovDsConv extends
        AbstractDsConverter<QualificationLovDs, Qualification> implements
        IDsConverter<QualificationLovDs, Qualification> {

    protected void modelToEntityAttributes(QualificationLovDs ds,
            Qualification e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(QualificationLovDs ds,
            Qualification e) throws Exception {
    }

    @Override
    public void entityToModel(Qualification e, QualificationLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
