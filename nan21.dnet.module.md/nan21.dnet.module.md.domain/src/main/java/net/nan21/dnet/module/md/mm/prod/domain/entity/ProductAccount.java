/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.domain.entity;

import java.util.Date;
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
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Product accounts.*/
@Entity
@Table(name = ProductAccount.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = ProductAccount.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "PRODUCT_ID", "ORG_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ProductAccount.NQ_FIND_BY_ID, query = "SELECT e FROM ProductAccount e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAccount.NQ_FIND_BY_IDS, query = "SELECT e FROM ProductAccount e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAccount.NQ_FIND_BY_PROD_ORG, query = "SELECT e FROM ProductAccount e WHERE e.clientId = :pClientId and  e.product = :pProduct and e.org = :pOrg ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ProductAccount.findByProd_org_PRIMITIVE", query = "SELECT e FROM ProductAccount e WHERE e.clientId = :pClientId and  e.product.id = :pProductId and e.org.id = :pOrgId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ProductAccount extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_PROD_ACNT";
    public static final String SEQUENCE_NAME = "MD_PROD_ACNT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ProductAccount.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ProductAccount.findByIds";

    /**
     * Named query find by unique key: Prod_org.
     */
    public static final String NQ_FIND_BY_PROD_ORG = "ProductAccount.findByProd_org";

    /**
     * Named query find by unique key: Prod_org using the ID field for references.
     */
    public static final String NQ_FIND_BY_PROD_ORG_PRIMITIVE = "ProductAccount.findByProd_org_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** AnaliticSegment. */
    @Column(name = "ANALITICSEGMENT", length = 32)
    private String analiticSegment;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
    private Organization org;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductAccountGroup.class)
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
    private ProductAccountGroup group;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnaliticSegment() {
        return this.analiticSegment;
    }

    public void setAnaliticSegment(String analiticSegment) {
        this.analiticSegment = analiticSegment;
    }

    public Organization getOrg() {
        return this.org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }

    public ProductAccountGroup getGroup() {
        return this.group;
    }

    public void setGroup(ProductAccountGroup group) {
        this.group = group;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
