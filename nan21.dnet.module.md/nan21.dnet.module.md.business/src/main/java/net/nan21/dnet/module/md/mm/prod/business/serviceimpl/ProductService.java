/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeValue;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductCategory;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductManufacturer;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md._businessdelegates.mm.prod.ProductExpenseAcctBD;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md._businessdelegates.mm.prod.ProductRevenueAcctBD;

public class ProductService extends AbstractEntityService<Product> {

    public ProductService() {
        super();
    }

    public ProductService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    public Product findByCode(String code) {
        return (Product) this.em.createNamedQuery(Product.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public Product findByName(String name) {
        return (Product) this.em.createNamedQuery(Product.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<Product> findByDefaultUom(Uom defaultUom) {
        return this.findByDefaultUomId(defaultUom.getId());
    }

    public List<Product> findByDefaultUomId(Long defaultUomId) {
        return (List<Product>) this.em
                .createQuery(
                        "select e from Product e where e.clientId = :pClientId and e.defaultUom.id = :pDefaultUomId",
                        Product.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDefaultUomId", defaultUomId).getResultList();
    }

    public List<Product> findByWeightUom(Uom weightUom) {
        return this.findByWeightUomId(weightUom.getId());
    }

    public List<Product> findByWeightUomId(Long weightUomId) {
        return (List<Product>) this.em
                .createQuery(
                        "select e from Product e where e.clientId = :pClientId and e.weightUom.id = :pWeightUomId",
                        Product.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pWeightUomId", weightUomId).getResultList();
    }

    public List<Product> findByVolumeUom(Uom volumeUom) {
        return this.findByVolumeUomId(volumeUom.getId());
    }

    public List<Product> findByVolumeUomId(Long volumeUomId) {
        return (List<Product>) this.em
                .createQuery(
                        "select e from Product e where e.clientId = :pClientId and e.volumeUom.id = :pVolumeUomId",
                        Product.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pVolumeUomId", volumeUomId).getResultList();
    }

    public List<Product> findByDimUom(Uom dimUom) {
        return this.findByDimUomId(dimUom.getId());
    }

    public List<Product> findByDimUomId(Long dimUomId) {
        return (List<Product>) this.em
                .createQuery(
                        "select e from Product e where e.clientId = :pClientId and e.dimUom.id = :pDimUomId",
                        Product.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDimUomId", dimUomId).getResultList();
    }

    public List<Product> findByManufacturer(ProductManufacturer manufacturer) {
        return this.findByManufacturerId(manufacturer.getId());
    }

    public List<Product> findByManufacturerId(Long manufacturerId) {
        return (List<Product>) this.em
                .createQuery(
                        "select e from Product e where e.clientId = :pClientId and e.manufacturer.id = :pManufacturerId",
                        Product.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pManufacturerId", manufacturerId)
                .getResultList();
    }

    public List<Product> findByAttributeSet(AttributeSet attributeSet) {
        return this.findByAttributeSetId(attributeSet.getId());
    }

    public List<Product> findByAttributeSetId(Long attributeSetId) {
        return (List<Product>) this.em
                .createQuery(
                        "select e from Product e where e.clientId = :pClientId and e.attributeSet.id = :pAttributeSetId",
                        Product.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAttributeSetId", attributeSetId)
                .getResultList();
    }

    public List<Product> findByCategories(ProductCategory categories) {
        return this.findByCategoriesId(categories.getId());
    }

    public List<Product> findByCategoriesId(Long categoriesId) {
        return (List<Product>) this.em
                .createQuery(
                        "select distinct e from Product e , IN (e.categories) c where e.clientId = :pClientId and c.id = :pCategoriesId",
                        Product.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCategoriesId", categoriesId).getResultList();
    }

    public List<Product> findByAttributeValues(
            ProductAttributeValue attributeValues) {
        return this.findByAttributeValuesId(attributeValues.getId());
    }

    public List<Product> findByAttributeValuesId(Long attributeValuesId) {
        return (List<Product>) this.em
                .createQuery(
                        "select distinct e from Product e , IN (e.attributeValues) c where e.clientId = :pClientId and c.id = :pAttributeValuesId",
                        Product.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAttributeValuesId", attributeValuesId)
                .getResultList();
    }

    public String getExpenseAcct(Product product, Organization organization,
            AccSchema schema) throws Exception {
        return this.getBusinessDelegate(ProductExpenseAcctBD.class)
                .getPostingAcct(product, organization, schema);
    }

    public String getRevenueAcct(Product product, Organization organization,
            AccSchema schema) throws Exception {
        return this.getBusinessDelegate(ProductRevenueAcctBD.class)
                .getPostingAcct(product, organization, schema);
    }

}
