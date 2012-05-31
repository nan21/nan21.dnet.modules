/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountGroupService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountDs;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccount;

public class ProductAccountDsConv extends
        AbstractDsConverter<ProductAccountDs, ProductAccount> implements
        IDsConverter<ProductAccountDs, ProductAccount> {

    @Override
    protected void modelToEntityReferences(ProductAccountDs ds,
            ProductAccount e, boolean isInsert) throws Exception {

        if (ds.getOrgId() != null) {
            if (e.getOrg() == null || !e.getOrg().getId().equals(ds.getOrgId())) {
                e.setOrg((Organization) this.em.find(Organization.class,
                        ds.getOrgId()));
            }
        } else {
            this.lookup_org_Organization(ds, e);
        }

        if (ds.getGroupId() != null) {
            if (e.getGroup() == null
                    || !e.getGroup().getId().equals(ds.getGroupId())) {
                e.setGroup((ProductAccountGroup) this.em.find(
                        ProductAccountGroup.class, ds.getGroupId()));
            }
        } else {
            this.lookup_group_ProductAccountGroup(ds, e);
        }

        if (ds.getProductId() != null) {
            if (e.getProduct() == null
                    || !e.getProduct().getId().equals(ds.getProductId())) {
                e.setProduct((Product) this.em.find(Product.class,
                        ds.getProductId()));
            }
        } else {
            this.lookup_product_Product(ds, e);
        }

    }

    protected void lookup_org_Organization(ProductAccountDs ds, ProductAccount e)
            throws Exception {
        if (ds.getOrg() != null && !ds.getOrg().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByCode(ds.getOrg());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `org` = "
                                + ds.getOrg() + "  ");
            }
            e.setOrg(x);

        } else {
            e.setOrg(null);
        }
    }

    protected void lookup_group_ProductAccountGroup(ProductAccountDs ds,
            ProductAccount e) throws Exception {
        if (ds.getGroupCode() != null && !ds.getGroupCode().equals("")) {
            ProductAccountGroup x = null;
            try {
                x = ((IProductAccountGroupService) findEntityService(ProductAccountGroup.class))
                        .findByCode(ds.getGroupCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProductAccountGroup` reference:  `groupCode` = "
                                + ds.getGroupCode() + "  ");
            }
            e.setGroup(x);

        } else {
            e.setGroup(null);
        }
    }

    protected void lookup_product_Product(ProductAccountDs ds, ProductAccount e)
            throws Exception {
        if (ds.getProductCode() != null && !ds.getProductCode().equals("")) {
            Product x = null;
            try {
                x = ((IProductService) findEntityService(Product.class))
                        .findByCode(ds.getProductCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Product` reference:  `productCode` = "
                                + ds.getProductCode() + "  ");
            }
            e.setProduct(x);

        } else {
            e.setProduct(null);
        }
    }

}
