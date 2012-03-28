/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.fin.business.service.ITaxService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderItemTaxDs;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;

public class SalesOrderItemTaxDsConv extends
        AbstractDsConverter<SalesOrderItemTaxDs, SalesOrderItemTax> implements
        IDsConverter<SalesOrderItemTaxDs, SalesOrderItemTax> {

    @Override
    protected void modelToEntityReferences(SalesOrderItemTaxDs ds,
            SalesOrderItemTax e, boolean isInsert) throws Exception {

        if (ds.getSalesOrderItemId() != null) {
            if (e.getSalesOrderItem() == null
                    || !e.getSalesOrderItem().getId()
                            .equals(ds.getSalesOrderItemId())) {
                e.setSalesOrderItem((SalesOrderItem) this.em.find(
                        SalesOrderItem.class, ds.getSalesOrderItemId()));
            }
        }

        if (ds.getTaxId() != null) {
            if (e.getTax() == null || !e.getTax().getId().equals(ds.getTaxId())) {
                e.setTax((Tax) this.em.find(Tax.class, ds.getTaxId()));
            }
        } else {
            this.lookup_tax_Tax(ds, e);
        }

    }

    protected void lookup_tax_Tax(SalesOrderItemTaxDs ds, SalesOrderItemTax e)
            throws Exception {
        if (ds.getTax() != null && !ds.getTax().equals("")) {
            Tax x = null;
            try {
                x = ((ITaxService) findEntityService(Tax.class)).findByName(ds
                        .getTax());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Tax` reference:  `tax` = "
                                + ds.getTax() + "  ");
            }
            e.setTax(x);

        } else {
            e.setTax(null);
        }
    }

}
