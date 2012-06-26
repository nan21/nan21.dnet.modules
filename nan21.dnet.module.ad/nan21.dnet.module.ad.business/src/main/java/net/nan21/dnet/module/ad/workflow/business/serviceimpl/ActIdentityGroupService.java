/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActIdentityGroupService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityUser;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityGroup;

public class ActIdentityGroupService extends
        AbstractEntityService<ActIdentityGroup> implements
        IActIdentityGroupService {

    public ActIdentityGroupService() {
        super();
    }

    public ActIdentityGroupService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ActIdentityGroup> getEntityClass() {
        return ActIdentityGroup.class;
    }

    public List<ActIdentityGroup> findByUsers(ActIdentityUser users) {
        return this.findByUsersId(users.getId());
    }

    public List<ActIdentityGroup> findByUsersId(String usersId) {
        return (List<ActIdentityGroup>) this.em
                .createQuery(
                        "select distinct e from ActIdentityGroup e , IN (e.users) c where  c.id = :pUsersId",
                        ActIdentityGroup.class)
                .setParameter("pUsersId", usersId).getResultList();
    }

}
