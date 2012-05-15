/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.standards.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.standards.business.service.IClassificationSystemService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.standards.ds.model.ClassificationItemDs;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;

public class ClassificationItemDsConv extends
        AbstractDsConverter<ClassificationItemDs, ClassificationItem> implements
        IDsConverter<ClassificationItemDs, ClassificationItem> {

    @Override
    protected void modelToEntityReferences(ClassificationItemDs ds,
            ClassificationItem e, boolean isInsert) throws Exception {

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
            ClassificationItemDs ds, ClassificationItem e) throws Exception {
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
