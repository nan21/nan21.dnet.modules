/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActIdentityUserService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityGroup;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityUser;

public class ActIdentityUserService extends
        AbstractEntityService<ActIdentityUser> implements
        IActIdentityUserService {

    public ActIdentityUserService() {
        super();
    }

    public ActIdentityUserService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ActIdentityUser> getEntityClass() {
        return ActIdentityUser.class;
    }

    public List<ActIdentityUser> findByGroups(ActIdentityGroup groups) {
        return this.findByGroupsId(groups.getId());
    }

    public List<ActIdentityUser> findByGroupsId(String groupsId) {
        return (List<ActIdentityUser>) this.em
                .createQuery(
                        "select distinct e from ActIdentityUser e , IN (e.groups) c where  c.id = :pGroupsId",
                        ActIdentityUser.class)
                .setParameter("pGroupsId", groupsId).getResultList();
    }

}
