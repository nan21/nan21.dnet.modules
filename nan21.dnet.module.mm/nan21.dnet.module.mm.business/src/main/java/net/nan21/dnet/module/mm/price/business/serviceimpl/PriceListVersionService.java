/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.price.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.price.business.service.IPriceListVersionService;
import net.nan21.dnet.module.mm.price.domain.entity.PriceList;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.price.domain.entity.PriceListVersion;

public class PriceListVersionService extends
        AbstractEntityService<PriceListVersion> implements
        IPriceListVersionService {

    public PriceListVersionService() {
        super();
    }

    public PriceListVersionService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PriceListVersion> getEntityClass() {
        return PriceListVersion.class;
    }

    public PriceListVersion findByName(Long clientId, String name) {
        return (PriceListVersion) this.em
                .createNamedQuery(PriceListVersion.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<PriceListVersion> findByPriceList(PriceList priceList) {
        return this.findByPriceListId(priceList.getId());
    }

    public List<PriceListVersion> findByPriceListId(Long priceListId) {
        return (List<PriceListVersion>) this.em
                .createQuery(
                        "select e from PriceListVersion e where e.priceList.id = :pPriceListId",
                        PriceListVersion.class)
                .setParameter("pPriceListId", priceListId).getResultList();
    }

}
