/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.standards.business.service.IClassificationItemService;
import net.nan21.dnet.module.bd.standards.business.service.IClassificationSystemService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.md.bp.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.bp.ds.model.BpClassificationDs;
import net.nan21.dnet.module.md.bp.domain.entity.BpClassification;

public class BpClassificationDsConv extends
        AbstractDsConverter<BpClassificationDs, BpClassification> implements
        IDsConverter<BpClassificationDs, BpClassification> {

    @Override
    protected void modelToEntityReferences(BpClassificationDs ds,
            BpClassification e, boolean isInsert) throws Exception {

        if (ds.getBusinessPartnerId() != null) {
            if (e.getBp() == null
                    || !e.getBp().getId().equals(ds.getBusinessPartnerId())) {
                e.setBp((BusinessPartner) this.em.find(BusinessPartner.class,
                        ds.getBusinessPartnerId()));
            }
        } else {
            this.lookup_bp_BusinessPartner(ds, e);
        }

        if (ds.getClassificationSystemId() != null) {
            if (e.getClassSystem() == null
                    || !e.getClassSystem().getId()
                            .equals(ds.getClassificationSystemId())) {
                e.setClassSystem((ClassificationSystem) this.em.find(
                        ClassificationSystem.class,
                        ds.getClassificationSystemId()));
            }
        } else {
            this.lookup_classSystem_ClassificationSystem(ds, e);
        }

        if (ds.getClassificationId() != null) {
            if (e.getClassCode() == null
                    || !e.getClassCode().getId()
                            .equals(ds.getClassificationId())) {
                e.setClassCode((ClassificationItem) this.em.find(
                        ClassificationItem.class, ds.getClassificationId()));
            }
        } else {
            this.lookup_classCode_ClassificationItem(ds, e);
        }

    }

    protected void lookup_bp_BusinessPartner(BpClassificationDs ds,
            BpClassification e) throws Exception {
        if (ds.getBusinessPartner() != null
                && !ds.getBusinessPartner().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) findEntityService(BusinessPartner.class))
                        .findByCode(ds.getBusinessPartner());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `BusinessPartner` reference:  `businessPartner` = "
                                + ds.getBusinessPartner() + "  ");
            }
            e.setBp(x);

        } else {
            e.setBp(null);
        }
    }

    protected void lookup_classSystem_ClassificationSystem(
            BpClassificationDs ds, BpClassification e) throws Exception {
        if (ds.getClassificationSystem() != null
                && !ds.getClassificationSystem().equals("")) {
            ClassificationSystem x = null;
            try {
                x = ((IClassificationSystemService) findEntityService(ClassificationSystem.class))
                        .findByCode(ds.getClassificationSystem());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ClassificationSystem` reference:  `classificationSystem` = "
                                + ds.getClassificationSystem() + "  ");
            }
            e.setClassSystem(x);

        } else {
            e.setClassSystem(null);
        }
    }

    protected void lookup_classCode_ClassificationItem(BpClassificationDs ds,
            BpClassification e) throws Exception {
        if (ds.getClassificationSystemId() != null
                && !ds.getClassificationSystemId().equals("")
                && ds.getClassificationCode() != null
                && !ds.getClassificationCode().equals("")) {
            ClassificationItem x = null;
            try {
                x = ((IClassificationItemService) findEntityService(ClassificationItem.class))
                        .findBySyscode(ds.getClassificationSystemId(),
                                ds.getClassificationCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ClassificationItem` reference:  `classificationSystemId` = "
                                + ds.getClassificationSystemId()
                                + " , `classificationCode` = "
                                + ds.getClassificationCode() + "  ");
            }
            e.setClassCode(x);

        } else {
            e.setClassCode(null);
        }
    }

}
