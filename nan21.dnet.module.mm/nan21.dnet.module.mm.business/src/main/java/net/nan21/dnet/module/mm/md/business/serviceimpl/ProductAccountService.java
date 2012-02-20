/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.mm.md.business.service.IProductAccountService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAccountGroup;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAccount;

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

    public ProductAccount findByCode(Product product, Organization organization) {
        return (ProductAccount) this.em
                .createNamedQuery(ProductAccount.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProduct", product)
                .setParameter("pOrganization", organization).getSingleResult();
    }

    public ProductAccount findByCode(Long productId, Long organizationId) {
        return (ProductAccount) this.em
                .createNamedQuery(ProductAccount.NQ_FIND_BY_CODE_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId)
                .setParameter("pOrganizationId", organizationId)
                .getSingleResult();
    }

    public List<ProductAccount> findByOrganization(Organization organization) {
        return this.findByOrganizationId(organization.getId());
    }

    public List<ProductAccount> findByOrganizationId(Long organizationId) {
        return (List<ProductAccount>) this.em
                .createQuery(
                        "select e from ProductAccount e where e.clientId = :pClientId and e.organization.id = :pOrganizationId",
                        ProductAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrganizationId", organizationId)
                .getResultList();
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
