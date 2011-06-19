/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.org.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.org.domain.service.IOrganizationHierarchyService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.org.domain.entity.OrganizationHierarchy;

public class OrganizationHierarchyService extends
        AbstractEntityService<OrganizationHierarchy> implements
        IOrganizationHierarchyService {

    public OrganizationHierarchyService() {
        super();
    }

    public OrganizationHierarchyService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<OrganizationHierarchy> getEntityClass() {
        return OrganizationHierarchy.class;
    }

    public OrganizationHierarchy findByName(Long clientId, String name) {
        return (OrganizationHierarchy) this.em
                .createNamedQuery(OrganizationHierarchy.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
