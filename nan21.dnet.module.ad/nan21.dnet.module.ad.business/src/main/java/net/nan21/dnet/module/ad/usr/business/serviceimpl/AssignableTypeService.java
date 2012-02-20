/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IAssignableTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;

public class AssignableTypeService extends
        AbstractEntityService<AssignableType> implements IAssignableTypeService {

    public AssignableTypeService() {
        super();
    }

    public AssignableTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AssignableType> getEntityClass() {
        return AssignableType.class;
    }

    public AssignableType findByName(String name) {
        return (AssignableType) this.em
                .createNamedQuery(AssignableType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
