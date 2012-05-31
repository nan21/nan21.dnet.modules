/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccount;

public class ProductAccountService extends
        AbstractEntityService<ProductAccount> implements IProductAccountService {

    public ProductAccountService() {
        super();
    }

    public ProductAccountService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductAccount> getEntityClass() {
        return ProductAccount.class;
    }

    public ProductAccount findByProd_org(Product product, Organization org) {
        return (ProductAccount) this.em
                .createNamedQuery(ProductAccount.NQ_FIND_BY_PROD_ORG)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProduct", product).setParameter("pOrg", org)
                .getSingleResult();
    }

    public ProductAccount findByProd_org(Long productId, Long orgId) {
        return (ProductAccount) this.em
                .createNamedQuery(ProductAccount.NQ_FIND_BY_PROD_ORG_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId)
                .setParameter("pOrgId", orgId).getSingleResult();
    }

    public List<ProductAccount> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<ProductAccount> findByOrgId(Long orgId) {
        return (List<ProductAccount>) this.em
                .createQuery(
                        "select e from ProductAccount e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        ProductAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

    public List<ProductAccount> findByGroup(ProductAccountGroup group) {
        return this.findByGroupId(group.getId());
    }

    public List<ProductAccount> findByGroupId(Long groupId) {
        return (List<ProductAccount>) this.em
                .createQuery(
                        "select e from ProductAccount e where e.clientId = :pClientId and e.group.id = :pGroupId",
                        ProductAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGroupId", groupId).getResultList();
    }

    public List<ProductAccount> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<ProductAccount> findByProductId(Long productId) {
        return (List<ProductAccount>) this.em
                .createQuery(
                        "select e from ProductAccount e where e.clientId = :pClientId and e.product.id = :pProductId",
                        ProductAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId).getResultList();
    }

}
