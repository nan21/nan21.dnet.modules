/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.price.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.mm.price.business.service.IPriceListService;
import net.nan21.dnet.module.mm.price.domain.entity.PriceList;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.price.ds.model.PriceListVersionDs;
import net.nan21.dnet.module.mm.price.domain.entity.PriceListVersion;

public class PriceListVersionDsConv extends
        AbstractDsConverter<PriceListVersionDs, PriceListVersion> implements
        IDsConverter<PriceListVersionDs, PriceListVersion> {

    protected void modelToEntityReferences(PriceListVersionDs ds,
            PriceListVersion e) throws Exception {
        if (ds.getPriceListId() != null) {
            if (e.getPriceList() == null
                    || !e.getPriceList().getId().equals(ds.getPriceListId())) {
                e.setPriceList((PriceList) this.em.find(PriceList.class,
                        ds.getPriceListId()));
            }
        } else {
            this.lookup_priceList_PriceList(ds, e);
        }
    }

    protected void lookup_priceList_PriceList(PriceListVersionDs ds,
            PriceListVersion e) throws Exception {
        if (ds.getPriceList() != null && !ds.getPriceList().equals("")) {
            PriceList x = null;
            try {
                x = ((IPriceListService) findEntityService(PriceList.class))
                        .findByName(ds.getClientId(), ds.getPriceList());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PriceList` reference:  `priceList` = "
                                + ds.getPriceList() + "  ");
            }
            e.setPriceList(x);

        } else {
            e.setPriceList(null);
        }
    }

}
