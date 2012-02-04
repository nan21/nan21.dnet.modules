/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;

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

    public List<Uom> findByType(UomType type) {
        return this.findByTypeId(type.getId());
    }

    public List<Uom> findByTypeId(Long typeId) {
        return (List<Uom>) this.em
                .createQuery("select e from Uom e where e.type.id = :pTypeId",
                        Uom.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

}
