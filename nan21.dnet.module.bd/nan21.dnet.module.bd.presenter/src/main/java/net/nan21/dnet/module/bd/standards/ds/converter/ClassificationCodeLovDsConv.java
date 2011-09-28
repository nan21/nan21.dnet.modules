/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.standards.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.standards.ds.model.ClassificationCodeLovDs;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationCode;

public class ClassificationCodeLovDsConv extends
        AbstractDsConverter<ClassificationCodeLovDs, ClassificationCode>
        implements IDsConverter<ClassificationCodeLovDs, ClassificationCode> {

    protected void modelToEntityAttributes(ClassificationCodeLovDs ds,
            ClassificationCode e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ClassificationCodeLovDs ds,
            ClassificationCode e) throws Exception {
    }

    @Override
    public void entityToModel(ClassificationCode e, ClassificationCodeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setClassSystemId(((e.getClassSystem() != null)) ? e.getClassSystem()
                .getId() : null);
    }

}
