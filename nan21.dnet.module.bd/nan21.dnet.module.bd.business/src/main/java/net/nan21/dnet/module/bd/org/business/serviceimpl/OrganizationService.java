/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;

public class OrganizationService extends AbstractEntityService<Organization>
        implements IOrganizationService {

    public OrganizationService() {
        super();
    }

    public OrganizationService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Organization> getEntityClass() {
        return Organization.class;
    }

    public Organization findByCode(Long clientId, String code) {
        return (Organization) this.em
                .createNamedQuery(Organization.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public Organization findByName(Long clientId, String name) {
        return (Organization) this.em
                .createNamedQuery(Organization.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<Organization> findByType(OrganizationType type) {
        return this.findByTypeId(type.getId());
    }

    public List<Organization> findByTypeId(Long typeId) {
        return (List<Organization>) this.em
                .createQuery(
                        "select e from Organization e where e.type.id = :pTypeId",
                        Organization.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

}
