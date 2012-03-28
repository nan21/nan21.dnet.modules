/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.fin.business.service.ITaxService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderTaxDs;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderTax;

public class SalesOrderTaxDsConv extends
        AbstractDsConverter<SalesOrderTaxDs, SalesOrderTax> implements
        IDsConverter<SalesOrderTaxDs, SalesOrderTax> {

    @Override
    protected void modelToEntityReferences(SalesOrderTaxDs ds, SalesOrderTax e,
            boolean isInsert) throws Exception {

        if (ds.getSalesOrderId() != null) {
            if (e.getSalesOrder() == null
                    || !e.getSalesOrder().getId().equals(ds.getSalesOrderId())) {
                e.setSalesOrder((SalesOrder) this.em.find(SalesOrder.class,
                        ds.getSalesOrderId()));
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

    protected void lookup_tax_Tax(SalesOrderTaxDs ds, SalesOrderTax e)
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
