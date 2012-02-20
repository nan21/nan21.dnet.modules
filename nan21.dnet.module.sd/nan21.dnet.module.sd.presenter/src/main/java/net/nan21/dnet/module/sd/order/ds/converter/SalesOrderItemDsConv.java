/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.business.service.IProductService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderItemDs;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;

public class SalesOrderItemDsConv extends
        AbstractDsConverter<SalesOrderItemDs, SalesOrderItem> implements
        IDsConverter<SalesOrderItemDs, SalesOrderItem> {

    @Override
    protected void modelToEntityReferences(SalesOrderItemDs ds,
            SalesOrderItem e, boolean isInsert) throws Exception {

        if (ds.getSalesOrderId() != null) {
            if (e.getSalesOrder() == null
                    || !e.getSalesOrder().getId().equals(ds.getSalesOrderId())) {
                e.setSalesOrder((SalesOrder) this.em.find(SalesOrder.class,
                        ds.getSalesOrderId()));
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

    protected void lookup_product_Product(SalesOrderItemDs ds, SalesOrderItem e)
            throws Exception {
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
