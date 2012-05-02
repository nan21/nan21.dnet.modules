/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.business.service.ICustomerGroupAcctService;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroupAcct;

public class CustomerGroupAcctService extends
        AbstractEntityService<CustomerGroupAcct> implements
        ICustomerGroupAcctService {

    public CustomerGroupAcctService() {
        super();
    }

    public CustomerGroupAcctService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CustomerGroupAcct> getEntityClass() {
        return CustomerGroupAcct.class;
    }

    public CustomerGroupAcct findByGroup_schema(CustomerGroup custGroup,
            AccSchema accSchema) {
        return (CustomerGroupAcct) this.em
                .createNamedQuery(CustomerGroupAcct.NQ_FIND_BY_GROUP_SCHEMA)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCustGroup", custGroup)
                .setParameter("pAccSchema", accSchema).getSingleResult();
    }

    public CustomerGroupAcct findByGroup_schema(Long custGroupId,
            Long accSchemaId) {
        return (CustomerGroupAcct) this.em
                .createNamedQuery(
                        CustomerGroupAcct.NQ_FIND_BY_GROUP_SCHEMA_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCustGroupId", custGroupId)
                .setParameter("pAccSchemaId", accSchemaId).getSingleResult();
    }

    public List<CustomerGroupAcct> findByCustGroup(CustomerGroup custGroup) {
        return this.findByCustGroupId(custGroup.getId());
    }

    public List<CustomerGroupAcct> findByCustGroupId(Long custGroupId) {
        return (List<CustomerGroupAcct>) this.em
                .createQuery(
                        "select e from CustomerGroupAcct e where e.clientId = :pClientId and e.custGroup.id = :pCustGroupId",
                        CustomerGroupAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCustGroupId", custGroupId).getResultList();
    }

    public List<CustomerGroupAcct> findByAccSchema(AccSchema accSchema) {
        return this.findByAccSchemaId(accSchema.getId());
    }

    public List<CustomerGroupAcct> findByAccSchemaId(Long accSchemaId) {
        return (List<CustomerGroupAcct>) this.em
                .createQuery(
                        "select e from CustomerGroupAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
                        CustomerGroupAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccSchemaId", accSchemaId).getResultList();
    }

    public List<CustomerGroupAcct> findBySalesAccount(Account salesAccount) {
        return this.findBySalesAccountId(salesAccount.getId());
    }

    public List<CustomerGroupAcct> findBySalesAccountId(Long salesAccountId) {
        return (List<CustomerGroupAcct>) this.em
                .createQuery(
                        "select e from CustomerGroupAcct e where e.clientId = :pClientId and e.salesAccount.id = :pSalesAccountId",
                        CustomerGroupAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSalesAccountId", salesAccountId)
                .getResultList();
    }

    public List<CustomerGroupAcct> findByPrepayAccount(Account prepayAccount) {
        return this.findByPrepayAccountId(prepayAccount.getId());
    }

    public List<CustomerGroupAcct> findByPrepayAccountId(Long prepayAccountId) {
        return (List<CustomerGroupAcct>) this.em
                .createQuery(
                        "select e from CustomerGroupAcct e where e.clientId = :pClientId and e.prepayAccount.id = :pPrepayAccountId",
                        CustomerGroupAcct.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPrepayAccountId", prepayAccountId)
                .getResultList();
    }

}
