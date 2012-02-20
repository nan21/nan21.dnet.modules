/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.acc.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.acc.business.service.IAccountGroupService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.acc.domain.entity.AccountGroup;

public class AccountGroupService extends AbstractEntityService<AccountGroup>
        implements IAccountGroupService {

    public AccountGroupService() {
        super();
    }

    public AccountGroupService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AccountGroup> getEntityClass() {
        return AccountGroup.class;
    }

    public AccountGroup findByCode(String code) {
        return (AccountGroup) this.em
                .createNamedQuery(AccountGroup.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public AccountGroup findByName(String name) {
        return (AccountGroup) this.em
                .createNamedQuery(AccountGroup.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<AccountGroup> findByAccSchema(AccSchema accSchema) {
        return this.findByAccSchemaId(accSchema.getId());
    }

    public List<AccountGroup> findByAccSchemaId(Long accSchemaId) {
        return (List<AccountGroup>) this.em
                .createQuery(
                        "select e from AccountGroup e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
                        AccountGroup.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccSchemaId", accSchemaId).getResultList();
    }

}
