/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Product attribute. */
@Entity
@Table(name = ProductAttributeValue.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = ProductAttributeValue.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "PRODUCT_ID", "ATTRIBUTE_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ProductAttributeValue.NQ_FIND_BY_ID, query = "SELECT e FROM ProductAttributeValue e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAttributeValue.NQ_FIND_BY_IDS, query = "SELECT e FROM ProductAttributeValue e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAttributeValue.NQ_FIND_BY_NAME, query = "SELECT e FROM ProductAttributeValue e WHERE e.clientId = :pClientId and  e.product = :pProduct and e.attribute = :pAttribute ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAttributeValue.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM ProductAttributeValue e WHERE e.clientId = :pClientId and  e.product.id = :pProductId and e.attribute.id = :pAttributeId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ProductAttributeValue extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_PROD_ATTR_VAL";
    public static final String SEQUENCE_NAME = "MD_PROD_ATTR_VAL_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ProductAttributeValue.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ProductAttributeValue.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "ProductAttributeValue.findByName";

    /**
     * Named query find by unique key: Name using the ID field for references.
     */
    public static final String NQ_FIND_BY_NAME_PRIMITIVE = "ProductAttributeValue.findByName_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Value. */
    @Column(name = "VALUE", length = 400)
    private String value;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Attribute.class)
    @JoinColumn(name = "ATTRIBUTE_ID", referencedColumnName = "ID")
    private Attribute attribute;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        if (product != null) {
            this.__validate_client_context__(product.getClientId());
        }
        this.product = product;
    }

    public Attribute getAttribute() {
        return this.attribute;
    }

    public void setAttribute(Attribute attribute) {
        if (attribute != null) {
            this.__validate_client_context__(attribute.getClientId());
        }
        this.attribute = attribute;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

}
