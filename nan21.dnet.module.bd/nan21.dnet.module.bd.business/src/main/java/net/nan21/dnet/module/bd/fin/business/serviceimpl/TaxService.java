/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.fin.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.fin.business.service.ITaxService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.bd.fin.domain.entity.TaxCategory;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;

public class TaxService extends AbstractEntityService<Tax> implements
        ITaxService {

    public TaxService() {
        super();
    }

    public TaxService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Tax> getEntityClass() {
        return Tax.class;
    }

    public Tax findByName(String name) {
        return (Tax) this.em.createNamedQuery(Tax.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<Tax> findByCategory(TaxCategory category) {
        return this.findByCategoryId(category.getId());
    }

    public List<Tax> findByCategoryId(Long categoryId) {
        return (List<Tax>) this.em
                .createQuery(
                        "select e from Tax e where e.clientId = :pClientId and e.category.id = :pCategoryId",
                        Tax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCategoryId", categoryId).getResultList();
    }

    public List<Tax> findByParentTax(Tax parentTax) {
        return this.findByParentTaxId(parentTax.getId());
    }

    public List<Tax> findByParentTaxId(Long parentTaxId) {
        return (List<Tax>) this.em
                .createQuery(
                        "select e from Tax e where e.clientId = :pClientId and e.parentTax.id = :pParentTaxId",
                        Tax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pParentTaxId", parentTaxId).getResultList();
    }

    public List<Tax> findByChildren(Tax children) {
        return this.findByChildrenId(children.getId());
    }

    public List<Tax> findByChildrenId(Long childrenId) {
        return (List<Tax>) this.em
                .createQuery(
                        "select distinct e from Tax e , IN (e.children) c where e.clientId = :pClientId and c.id = :pChildrenId",
                        Tax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pChildrenId", childrenId).getResultList();
    }

}
