/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.acc.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.acc.business.service.IAccSchemaService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;

public class AccSchemaService extends AbstractEntityService<AccSchema>
        implements IAccSchemaService {

    public AccSchemaService() {
        super();
    }

    public AccSchemaService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AccSchema> getEntityClass() {
        return AccSchema.class;
    }

    public AccSchema findByCode(Long clientId, String code) {
        return (AccSchema) this.em.createNamedQuery(AccSchema.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public AccSchema findByName(Long clientId, String name) {
        return (AccSchema) this.em.createNamedQuery(AccSchema.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
