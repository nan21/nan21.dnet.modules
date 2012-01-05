/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.domain.entity;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAccountGroup;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Product accounts.*/
@Entity
@Table(name = ProductAccount.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = ProductAccount.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "PRODUCT_ID", "ORGANIZATION_ID" }) })
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = ProductAccount.NQ_FIND_BY_ID, query = "SELECT e FROM ProductAccount e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAccount.NQ_FIND_BY_IDS, query = "SELECT e FROM ProductAccount e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAccount.NQ_FIND_BY_CODE, query = "SELECT e FROM ProductAccount e WHERE e.clientId = :pClientId and  e.product = :pProduct and e.organization = :pOrganization ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ProductAccount.findByCode_PRIMITIVE", query = "SELECT e FROM ProductAccount e WHERE e.clientId = :pClientId and  e.product.id = :pProductId and e.organization.id = :pOrganizationId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ProductAccount implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "MM_PROD_ACCOUNT";
    public static final String SEQUENCE_NAME = "MM_PROD_ACCOUNT_SEQ";

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
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "ProductAccount.findByCode";

    /**
     * Named query find by unique key: Code using the ID field for references.
     */
    public static final String NQ_FIND_BY_CODE_PRIMITIVE = "ProductAccount.findByCode_PRIMITIVE";

    /** Owner client */
    @Column(name = "CLIENTID", nullable = false)
    @NotNull
    private Long clientId;

    /** Timestamp when this record was created.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDAT", nullable = false)
    @NotNull
    private Date createdAt;

    /** Timestamp when this record was last modified.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIEDAT", nullable = false)
    @NotNull
    private Date modifiedAt;

    /** User who created this record.*/
    @Column(name = "CREATEDBY", nullable = false, length = 32)
    @NotBlank
    private String createdBy;

    /** User who last modified this record.*/
    @Column(name = "MODIFIEDBY", nullable = false, length = 32)
    @NotBlank
    private String modifiedBy;

    @Version
    /** Record version number used by the persistence framework. */
    @Column(name = "VERSION", nullable = false)
    @NotNull
    private Long version;

    /** System generated unique identifier */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "ORGANIZATION_ID", referencedColumnName = "ID")
    private Organization organization;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductAccountGroup.class)
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
    private ProductAccountGroup group;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;

    /* ============== getters - setters ================== */

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    public String getClassName() {
        return this.getClass().getCanonicalName();
    }

    public void setClassName(String className) {

    }

    public Organization getOrganization() {
        return this.organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
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

        event.updateAttributeWithObject("createdAt", new Date());
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("createdBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("clientId", Session.user.get()
                .getClientId());
    }

    public void aboutToUpdate(DescriptorEvent event) {

        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());

    }

}
