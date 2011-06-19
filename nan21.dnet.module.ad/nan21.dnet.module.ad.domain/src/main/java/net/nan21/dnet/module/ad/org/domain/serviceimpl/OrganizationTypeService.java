/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.org.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.org.domain.service.IOrganizationTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.org.domain.entity.OrganizationType;

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

    public OrganizationType findByName(Long clientId, String name) {
        return (OrganizationType) this.em
                .createNamedQuery(OrganizationType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
