/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.service.IUomService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

public class UomService extends AbstractEntityService<Uom> implements
        IUomService {

    public UomService() {
        super();
    }

    public UomService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Uom> getEntityClass() {
        return Uom.class;
    }

    public Uom findByCode(Long clientId, String code) {
        return (Uom) this.em.createNamedQuery(Uom.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public Uom findByName(Long clientId, String name) {
        return (Uom) this.em.createNamedQuery(Uom.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
