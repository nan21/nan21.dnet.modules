/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.business.service.IProductSubstituteService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductSubstitute;

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
                        "select e from ProductSubstitute e where e.refProduct.id = :pRefProductId",
                        ProductSubstitute.class)
                .setParameter("pRefProductId", refProductId).getResultList();
    }

    public List<ProductSubstitute> findByEquivalence(Product equivalence) {
        return this.findByEquivalenceId(equivalence.getId());
    }

    public List<ProductSubstitute> findByEquivalenceId(Long equivalenceId) {
        return (List<ProductSubstitute>) this.em
                .createQuery(
                        "select e from ProductSubstitute e where e.equivalence.id = :pEquivalenceId",
                        ProductSubstitute.class)
                .setParameter("pEquivalenceId", equivalenceId).getResultList();
    }

}
