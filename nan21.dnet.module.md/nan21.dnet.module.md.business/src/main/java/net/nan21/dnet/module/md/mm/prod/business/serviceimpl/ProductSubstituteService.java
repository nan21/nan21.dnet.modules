/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductSubstituteService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductSubstitute;

public class ProductSubstituteService extends
        AbstractEntityService<ProductSubstitute> implements
        IProductSubstituteService {

    public ProductSubstituteService() {
        super();
    }

    public ProductSubstituteService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductSubstitute> getEntityClass() {
        return ProductSubstitute.class;
    }

    public List<ProductSubstitute> findByRefProduct(Product refProduct) {
        return this.findByRefProductId(refProduct.getId());
    }

    public List<ProductSubstitute> findByRefProductId(Long refProductId) {
        return (List<ProductSubstitute>) this.em
                .createQuery(
                        "select e from ProductSubstitute e where e.clientId = :pClientId and e.refProduct.id = :pRefProductId",
                        ProductSubstitute.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pRefProductId", refProductId).getResultList();
    }

    public List<ProductSubstitute> findByEquivalence(Product equivalence) {
        return this.findByEquivalenceId(equivalence.getId());
    }

    public List<ProductSubstitute> findByEquivalenceId(Long equivalenceId) {
        return (List<ProductSubstitute>) this.em
                .createQuery(
                        "select e from ProductSubstitute e where e.clientId = :pClientId and e.equivalence.id = :pEquivalenceId",
                        ProductSubstitute.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEquivalenceId", equivalenceId).getResultList();
    }

}
