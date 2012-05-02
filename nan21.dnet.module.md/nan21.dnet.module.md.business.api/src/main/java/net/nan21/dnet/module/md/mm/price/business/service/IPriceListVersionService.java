/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.price.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;

import net.nan21.dnet.module.md.mm.price.domain.entity.PriceListVersion;

public interface IPriceListVersionService extends
        IEntityService<PriceListVersion> {

    public PriceListVersion findByName(String name);

    public List<PriceListVersion> findByPriceList(PriceList priceList);

    public List<PriceListVersion> findByPriceListId(Long priceListId);

}
