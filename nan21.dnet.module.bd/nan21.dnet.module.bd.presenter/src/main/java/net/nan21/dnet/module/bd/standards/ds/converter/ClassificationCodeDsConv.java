/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.standards.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.standards.business.service.IClassificationSystemService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.standards.ds.model.ClassificationCodeDs;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationCode;

public class ClassificationCodeDsConv extends
        AbstractDsConverter<ClassificationCodeDs, ClassificationCode> implements
        IDsConverter<ClassificationCodeDs, ClassificationCode> {

    protected void modelToEntityAttributes(ClassificationCodeDs ds,
            ClassificationCode e) throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(ClassificationCodeDs ds,
            ClassificationCode e) throws Exception {

        if (ds.getClassSystemId() != null) {
            if (e.getClassSystem() == null
                    || !e.getClassSystem().getId()
                            .equals(ds.getClassSystemId())) {
                e.setClassSystem((ClassificationSystem) this.em.find(
                        ClassificationSystem.class, ds.getClassSystemId()));
            }
        } else {
            this.lookup_classSystem_ClassificationSystem(ds, e);
        }
    }

    protected void lookup_classSystem_ClassificationSystem(
            ClassificationCodeDs ds, ClassificationCode e) throws Exception {
        if (ds.getClassSystem() != null && !ds.getClassSystem().equals("")) {
            ClassificationSystem x = null;
            try {
                x = ((IClassificationSystemService) getService(IClassificationSystemService.class))
                        .findByCode(ds.getClientId(), ds.getClassSystem());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ClassificationSystem` reference:  `classSystem` = "
                                + ds.getClassSystem() + "  ");
            }
            e.setClassSystem(x);
        } else {
            e.setClassSystem(null);
        }
    }

    @Override
    public void entityToModel(ClassificationCode e, ClassificationCodeDs ds)
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
        ds.setClassSystemId(((e.getClassSystem() != null)) ? e.getClassSystem()
                .getId() : null);
        ds.setClassSystem(((e.getClassSystem() != null)) ? e.getClassSystem()
                .getCode() : null);
    }

}
