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

    protected void modelToEntityAttributes(SalesOrderItemDs ds, SalesOrderItem e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setQtyOrdered(ds.getQtyOrdered());
        e.setNetUnitPrice(ds.getNetUnitPrice());
        e.setNetAmount(ds.getNetAmount());
    }

    protected void modelToEntityReferences(SalesOrderItemDs ds, SalesOrderItem e)
            throws Exception {

        if (ds.getSalesOrderId() != null) {
            if (e.getSalesOrder() == null
                    || !e.getSalesOrder().getId().equals(ds.getSalesOrderId())) {
                e.setSalesOrder((SalesOrder) this.em.getReference(
                        SalesOrder.class, ds.getSalesOrderId()));
            }
        }
        if (ds.getUomId() != null) {
            if (e.getUom() == null || !e.getUom().getId().equals(ds.getUomId())) {
                e.setUom((Uom) this.em.getReference(Uom.class, ds.getUomId()));
            }
        }
        if (ds.getProductId() != null) {
            if (e.getProduct() == null
                    || !e.getProduct().getId().equals(ds.getProductId())) {
                e.setProduct((Product) this.em.getReference(Product.class,
                        ds.getProductId()));
            }
        } else {
            this.lookup_product_Product(ds, e);
        }
    }

    protected void lookup_product_Product(SalesOrderItemDs ds, SalesOrderItem e)
            throws Exception {
        if (ds.getProductCode() != null) {
            Product x = null;
            try {
                x = ((IProductService) getService(IProductService.class))
                        .findByCode(ds.getClientId(), ds.getProductCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Product` reference:  `productCode` = "
                                + ds.getProductCode() + "  ");
            }
            e.setProduct(x);
        }
    }

    @Override
    public void entityToModel(SalesOrderItem e, SalesOrderItemDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setQtyOrdered(e.getQtyOrdered());
        ds.setNetUnitPrice(e.getNetUnitPrice());
        ds.setNetAmount(e.getNetAmount());
        ds.setSalesOrderId(((e.getSalesOrder() != null)) ? e.getSalesOrder()
                .getId() : null);
        ds.setProductId(((e.getProduct() != null)) ? e.getProduct().getId()
                : null);
        ds.setProductCode(((e.getProduct() != null)) ? e.getProduct().getCode()
                : null);
        ds.setProductName(((e.getProduct() != null)) ? e.getProduct().getName()
                : null);
        ds.setUomId(((e.getUom() != null)) ? e.getUom().getId() : null);
        ds.setUomCode(((e.getUom() != null)) ? e.getUom().getCode() : null);
    }

}
