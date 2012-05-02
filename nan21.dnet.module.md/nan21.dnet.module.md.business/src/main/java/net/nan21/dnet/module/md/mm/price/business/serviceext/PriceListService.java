/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.price.business.serviceext;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.module.md.mm.price.business.service.IPriceListService;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;

public class PriceListService extends
		net.nan21.dnet.module.md.mm.price.business.serviceimpl.PriceListService
		implements IPriceListService {
	public PriceList findDefaultPriceList(boolean salesList) throws Exception {
		String eql = "select e from "
				+ PriceList.class.getSimpleName()
				+ " e "
				+ " where e.salesList = :pSalesList and e.active=true and e.clientId = :pClientId ";
		return (PriceList) this.em.createQuery(eql, PriceList.class)
				.setParameter("pSalesList", salesList).setParameter(
						"pClientId", Session.user.get().getClientId())
				.getResultList().get(0);
	}
}
