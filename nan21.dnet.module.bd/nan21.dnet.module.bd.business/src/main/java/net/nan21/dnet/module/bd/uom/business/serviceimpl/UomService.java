/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
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

    public Uom findByCode(String code) {
        return (Uom) this.em.createNamedQuery(Uom.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public Uom findByName(String name) {
        return (Uom) this.em.createNamedQuery(Uom.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<Uom> findByType(UomType type) {
        return this.findByTypeId(type.getId());
    }

    public List<Uom> findByTypeId(Long typeId) {
        return (List<Uom>) this.em
                .createQuery(
                        "select e from Uom e where e.clientId = :pClientId and e.type.id = :pTypeId",
                        Uom.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTypeId", typeId).getResultList();
    }

}
