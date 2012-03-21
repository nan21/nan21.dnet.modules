/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.order.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.business.service.IProductService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderItemDs;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;

public class PurchaseOrderItemDsConv extends
        AbstractDsConverter<PurchaseOrderItemDs, PurchaseOrderItem> implements
        IDsConverter<PurchaseOrderItemDs, PurchaseOrderItem> {

    @Override
    protected void modelToEntityReferences(PurchaseOrderItemDs ds,
            PurchaseOrderItem e, boolean isInsert) throws Exception {

        if (ds.getPurchaseOrderId() != null) {
            if (e.getPurchaseOrder() == null
                    || !e.getPurchaseOrder().getId()
                            .equals(ds.getPurchaseOrderId())) {
                e.setPurchaseOrder((PurchaseOrder) this.em.find(
                        PurchaseOrder.class, ds.getPurchaseOrderId()));
            }
        }

        if (ds.getUomId() != null) {
            if (e.getUom() == null || !e.getUom().getId().equals(ds.getUomId())) {
                e.setUom((Uom) this.em.find(Uom.class, ds.getUomId()));
            }
        }

        if (ds.getProductId() != null) {
            if (e.getProduct() == null
                    || !e.getProduct().getId().equals(ds.getProductId())) {
                e.setProduct((Product) this.em.find(Product.class,
                        ds.getProductId()));
            }
        } else {
            this.lookup_product_Product(ds, e);
        }

    }

    protected void lookup_product_Product(PurchaseOrderItemDs ds,
            PurchaseOrderItem e) throws Exception {
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

}
