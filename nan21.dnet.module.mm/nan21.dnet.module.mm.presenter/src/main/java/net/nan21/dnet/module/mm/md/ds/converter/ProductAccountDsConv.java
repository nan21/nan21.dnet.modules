/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.org.business.service.IOrganizationService;
import net.nan21.dnet.module.ad.org.domain.entity.Organization;
import net.nan21.dnet.module.mm.md.business.service.IProductAccountGroupService;
import net.nan21.dnet.module.mm.md.business.service.IProductService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAccountGroup;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductAccountDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAccount;

public class ProductAccountDsConv extends
        AbstractDsConverter<ProductAccountDs, ProductAccount> implements
        IDsConverter<ProductAccountDs, ProductAccount> {

    protected void modelToEntityAttributes(ProductAccountDs ds, ProductAccount e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(ProductAccountDs ds, ProductAccount e)
            throws Exception {

        if (ds.getOrganizationId() != null) {
            if (e.getOrganization() == null
                    || !e.getOrganization().getId()
                            .equals(ds.getOrganizationId())) {
                e.setOrganization((Organization) this.em.getReference(
                        Organization.class, ds.getOrganizationId()));
            }
        } else {
            this.lookup_organization_Organization(ds, e);
        }
        if (ds.getGroupId() != null) {
            if (e.getGroup() == null
                    || !e.getGroup().getId().equals(ds.getGroupId())) {
                e.setGroup((ProductAccountGroup) this.em.getReference(
                        ProductAccountGroup.class, ds.getGroupId()));
            }
        } else {
            this.lookup_group_ProductAccountGroup(ds, e);
        }
        if (ds.getProductId() != null) {
            if (e.getProduct() == null
                    || !e.getProduct().getId().equals(ds.getProductId())) {
                e.setProduct((Product) this.em.getReference(Product.class,
                        ds.getProductId()));
            }
        } else {
            this.lookup_product_Product(ds, e);
        }
    }

    protected void lookup_organization_Organization(ProductAccountDs ds,
            ProductAccount e) throws Exception {
        Organization x = null;
        try {
            x = ((IOrganizationService) getService(IOrganizationService.class))
                    .findByCode(ds.getClientId(), ds.getOrganizationCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setOrganization(x);
    }

    protected void lookup_group_ProductAccountGroup(ProductAccountDs ds,
            ProductAccount e) throws Exception {
        ProductAccountGroup x = null;
        try {
            x = ((IProductAccountGroupService) getService(IProductAccountGroupService.class))
                    .findByCode(ds.getClientId(), ds.getGroupCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setGroup(x);
    }

    protected void lookup_product_Product(ProductAccountDs ds, ProductAccount e)
            throws Exception {
        Product x = null;
        try {
            x = ((IProductService) getService(IProductService.class))
                    .findByCode(ds.getClientId(), ds.getProductCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setProduct(x);
    }

    @Override
    public void entityToModel(ProductAccount e, ProductAccountDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setOrganizationId(((e.getOrganization() != null)) ? e
                .getOrganization().getId() : null);
        ds.setOrganizationCode(((e.getOrganization() != null)) ? e
                .getOrganization().getCode() : null);
        ds.setGroupId(((e.getGroup() != null)) ? e.getGroup().getId() : null);
        ds.setGroupCode(((e.getGroup() != null)) ? e.getGroup().getCode()
                : null);
        ds.setProductId(((e.getProduct() != null)) ? e.getProduct().getId()
                : null);
        ds.setProductCode(((e.getProduct() != null)) ? e.getProduct().getCode()
                : null);
    }

}
