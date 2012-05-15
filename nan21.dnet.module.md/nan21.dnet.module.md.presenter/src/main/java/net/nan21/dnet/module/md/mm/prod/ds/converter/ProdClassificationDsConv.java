/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.standards.business.service.IClassificationItemService;
import net.nan21.dnet.module.bd.standards.business.service.IClassificationSystemService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationItem;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProdClassificationDs;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProdClassification;

public class ProdClassificationDsConv extends
        AbstractDsConverter<ProdClassificationDs, ProdClassification> implements
        IDsConverter<ProdClassificationDs, ProdClassification> {

    @Override
    protected void modelToEntityReferences(ProdClassificationDs ds,
            ProdClassification e, boolean isInsert) throws Exception {

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
                e.setClassCode((ClassificationItem) this.em.find(
                        ClassificationItem.class, ds.getClassificationId()));
            }
        } else {
            this.lookup_classCode_ClassificationItem(ds, e);
        }

    }

    protected void lookup_product_Product(ProdClassificationDs ds,
            ProdClassification e) throws Exception {
        if (ds.getProductCode() != null && !ds.getProductCode().equals("")) {
            Product x = null;
            try {
                x = ((IProductService) findEntityService(Product.class))
                        .findByCode(ds.getProductCode());
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

    protected void lookup_classCode_ClassificationItem(ProdClassificationDs ds,
            ProdClassification e) throws Exception {
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
