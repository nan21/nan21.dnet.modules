/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.standards.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.standards.ds.model.ClassificationSystemDs;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;

public class ClassificationSystemDsConv extends
        AbstractDsConverter<ClassificationSystemDs, ClassificationSystem>
        implements IDsConverter<ClassificationSystemDs, ClassificationSystem> {

    protected void modelToEntityAttributes(ClassificationSystemDs ds,
            ClassificationSystem e) throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setInternal(ds.getInternal());
        e.setTag(ds.getTag());
        e.setUseInContext(ds.getUseInContext());
    }

    protected void modelToEntityReferences(ClassificationSystemDs ds,
            ClassificationSystem e) throws Exception {
    }

    @Override
    public void entityToModel(ClassificationSystem e, ClassificationSystemDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setCode(e.getCode());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setInternal(e.getInternal());
        ds.setTag(e.getTag());
        ds.setUseInContext(e.getUseInContext());
    }

}
