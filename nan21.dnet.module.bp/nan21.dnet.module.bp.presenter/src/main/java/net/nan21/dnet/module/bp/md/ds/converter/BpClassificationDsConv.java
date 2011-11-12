/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.standards.business.service.IClassificationCodeService;
import net.nan21.dnet.module.bd.standards.business.service.IClassificationSystemService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationCode;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.bp.md.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.md.ds.model.BpClassificationDs;
import net.nan21.dnet.module.bp.md.domain.entity.BpClassification;

public class BpClassificationDsConv extends
        AbstractDsConverter<BpClassificationDs, BpClassification> implements
        IDsConverter<BpClassificationDs, BpClassification> {

    protected void modelToEntityAttributes(BpClassificationDs ds,
            BpClassification e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(BpClassificationDs ds,
            BpClassification e) throws Exception {

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
                e.setClassCode((ClassificationCode) this.em.find(
                        ClassificationCode.class, ds.getClassificationId()));
            }
        } else {
            this.lookup_classCode_ClassificationCode(ds, e);
        }
    }

    protected void lookup_bp_BusinessPartner(BpClassificationDs ds,
            BpClassification e) throws Exception {
        if (ds.getBusinessPartner() != null
                && !ds.getBusinessPartner().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) getService(IBusinessPartnerService.class))
                        .findByCode(ds.getClientId(), ds.getBusinessPartner());
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
                x = ((IClassificationSystemService) getService(IClassificationSystemService.class))
                        .findByCode(ds.getClientId(),
                                ds.getClassificationSystem());
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

    protected void lookup_classCode_ClassificationCode(BpClassificationDs ds,
            BpClassification e) throws Exception {
        if (ds.getClassificationSystemId() != null
                && !ds.getClassificationSystemId().equals("")
                && ds.getClassificationCode() != null
                && !ds.getClassificationCode().equals("")) {
            ClassificationCode x = null;
            try {
                x = ((IClassificationCodeService) getService(IClassificationCodeService.class))
                        .findBySyscode(ds.getClientId(),
                                ds.getClassificationSystemId(),
                                ds.getClassificationCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ClassificationCode` reference:  `classificationSystemId` = "
                                + ds.getClassificationSystemId()
                                + " , `classificationCode` = "
                                + ds.getClassificationCode() + "  ");
            }
            e.setClassCode(x);
        } else {
            e.setClassCode(null);
        }
    }

    @Override
    public void entityToModel(BpClassification e, BpClassificationDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setBusinessPartnerId(((e.getBp() != null)) ? e.getBp().getId()
                : null);
        ds.setBusinessPartner(((e.getBp() != null)) ? e.getBp().getCode()
                : null);
        ds.setBusinessPartnerBO(((e.getBp() != null)) ? e.getBp()
                .getBusinessObject() : null);
        ds.setClassificationSystemId(((e.getClassSystem() != null)) ? e
                .getClassSystem().getId() : null);
        ds.setClassificationSystem(((e.getClassSystem() != null)) ? e
                .getClassSystem().getCode() : null);
        ds.setClassificationId(((e.getClassCode() != null)) ? e.getClassCode()
                .getId() : null);
        ds.setClassificationCode(((e.getClassCode() != null)) ? e
                .getClassCode().getCode() : null);
        ds.setClassificationName(((e.getClassCode() != null)) ? e
                .getClassCode().getName() : null);
    }

}
