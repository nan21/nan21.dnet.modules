/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.standards.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.standards.ds.model.ClassificationSystemLovDs;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;

public class ClassificationSystemLovDsConv extends
        AbstractDsConverter<ClassificationSystemLovDs, ClassificationSystem>
        implements
        IDsConverter<ClassificationSystemLovDs, ClassificationSystem> {

    protected void modelToEntityAttributes(ClassificationSystemLovDs ds,
            ClassificationSystem e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ClassificationSystemLovDs ds,
            ClassificationSystem e) throws Exception {
    }

    @Override
    public void entityToModel(ClassificationSystem e,
            ClassificationSystemLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
