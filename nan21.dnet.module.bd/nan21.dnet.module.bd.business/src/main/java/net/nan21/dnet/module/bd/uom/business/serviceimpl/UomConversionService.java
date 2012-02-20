/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.business.service.IUomConversionService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.uom.domain.entity.UomConversion;

public class UomConversionService extends AbstractEntityService<UomConversion>
        implements IUomConversionService {

    public UomConversionService() {
        super();
    }

    public UomConversionService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<UomConversion> getEntityClass() {
        return UomConversion.class;
    }

    public List<UomConversion> findBySource(Uom source) {
        return this.findBySourceId(source.getId());
    }

    public List<UomConversion> findBySourceId(Long sourceId) {
        return (List<UomConversion>) this.em
                .createQuery(
                        "select e from UomConversion e where e.clientId = :pClientId and  e.source.id = :pSourceId",
                        UomConversion.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSourceId", sourceId).getResultList();
    }

    public List<UomConversion> findByTarget(Uom target) {
        return this.findByTargetId(target.getId());
    }

    public List<UomConversion> findByTargetId(Long targetId) {
        return (List<UomConversion>) this.em
                .createQuery(
                        "select e from UomConversion e where e.clientId = :pClientId and  e.target.id = :pTargetId",
                        UomConversion.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTargetId", targetId).getResultList();
    }

}
