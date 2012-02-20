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

    @Override
    protected void modelToEntityReferences(ClassificationCodeDs ds,
            ClassificationCode e, boolean isInsert) throws Exception {

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
                x = ((IClassificationSystemService) findEntityService(ClassificationSystem.class))
                        .findByCode(ds.getClassSystem());
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

}
