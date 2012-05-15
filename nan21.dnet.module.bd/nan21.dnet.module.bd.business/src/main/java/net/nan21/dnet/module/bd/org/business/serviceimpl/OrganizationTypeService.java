/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationType;

public class OrganizationTypeService extends
        AbstractEntityService<OrganizationType> implements
        IOrganizationTypeService {

    public OrganizationTypeService() {
        super();
    }

    public OrganizationTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<OrganizationType> getEntityClass() {
        return OrganizationType.class;
    }

    public OrganizationType findByName(String name) {
        return (OrganizationType) this.em
                .createNamedQuery(OrganizationType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
