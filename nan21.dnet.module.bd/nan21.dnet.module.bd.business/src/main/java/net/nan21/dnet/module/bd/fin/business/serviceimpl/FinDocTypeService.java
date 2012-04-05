/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.fin.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.fin.business.service.IFinDocTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.fin.domain.entity.FinDocType;

public class FinDocTypeService extends AbstractEntityService<FinDocType>
        implements IFinDocTypeService {

    public FinDocTypeService() {
        super();
    }

    public FinDocTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<FinDocType> getEntityClass() {
        return FinDocType.class;
    }

    public FinDocType findByName(String name) {
        return (FinDocType) this.em
                .createNamedQuery(FinDocType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
