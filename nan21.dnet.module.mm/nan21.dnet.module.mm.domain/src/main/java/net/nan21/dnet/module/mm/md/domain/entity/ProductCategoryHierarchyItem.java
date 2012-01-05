/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.domain.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductCategoryHierarchy;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** ProductCategoryHierarchyItem. */
@Entity
@Table(name = ProductCategoryHierarchyItem.TABLE_NAME)
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({})
public class ProductCategoryHierarchyItem implements Serializable {

    public static final String TABLE_NAME = "MM_PRODCATEGHRCH_ITEM";
    public static final String SEQUENCE_NAME = "MM_PRODCATEGHRCH_ITEM_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductCategoryHierarchy.class)
    @JoinColumn(name = "HIERARCHY_ID", referencedColumnName = "ID")
    private ProductCategoryHierarchy hierarchy;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
    private Product parent;

    /* ============== getters - setters ================== */

    public ProductCategoryHierarchy getHierarchy() {
        return this.hierarchy;
    }

    public void setHierarchy(ProductCategoryHierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getParent() {
        return this.parent;
    }

    public void setParent(Product parent) {
        this.parent = parent;
    }

    public void aboutToInsert(DescriptorEvent event) {

    }

    public void aboutToUpdate(DescriptorEvent event) {

    }

}
