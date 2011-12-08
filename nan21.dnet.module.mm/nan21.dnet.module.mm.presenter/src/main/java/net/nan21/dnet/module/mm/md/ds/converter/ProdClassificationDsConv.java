/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.standards.business.service.IClassificationCodeService;
import net.nan21.dnet.module.bd.standards.business.service.IClassificationSystemService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationCode;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.mm.md.business.service.IProductService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProdClassificationDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProdClassification;

public class ProdClassificationDsConv extends
        AbstractDsConverter<ProdClassificationDs, ProdClassification> implements
        IDsConverter<ProdClassificationDs, ProdClassification> {

    protected void modelToEntityReferences(ProdClassificationDs ds,
            ProdClassification e) throws Exception {
        if (ds.getProductId() != null) {
            if (e.getProduct() == null
                    || !e.getProduct().getId().equals(ds.getProductId())) {
                e.setProduct((Product) this.em.find(Product.class,
                        ds.getProductId()));
            }
        } else {
            this.lookup_product_Product(ds, e);
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

    protected void lookup_product_Product(ProdClassificationDs ds,
            ProdClassification e) throws Exception {
        if (ds.getProductCode() != null && !ds.getProductCode().equals("")) {
            Product x = null;
            try {
                x = ((IProductService) findEntityService(Product.class))
                        .findByCode(ds.getClientId(), ds.getProductCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Product` reference:  `productCode` = "
                                + ds.getProductCode() + "  ");
            }
            e.setProduct(x);

        } else {
            e.setProduct(null);
        }
    }

    protected void lookup_classSystem_ClassificationSystem(
            ProdClassificationDs ds, ProdClassification e) throws Exception {
        if (ds.getClassificationSystem() != null
                && !ds.getClassificationSystem().equals("")) {
            ClassificationSystem x = null;
            try {
                x = ((IClassificationSystemService) findEntityService(ClassificationSystem.class))
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

    protected void lookup_classCode_ClassificationCode(ProdClassificationDs ds,
            ProdClassification e) throws Exception {
        if (ds.getClassificationSystemId() != null
                && !ds.getClassificationSystemId().equals("")
                && ds.getClassificationCode() != null
                && !ds.getClassificationCode().equals("")) {
            ClassificationCode x = null;
            try {
                x = ((IClassificationCodeService) findEntityService(ClassificationCode.class))
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

}
