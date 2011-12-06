/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.domain.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Product categories. */
@Entity
@Table(name = ProductCategory.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = "MM_PROD_CATEGORY_UK1", columnNames = {
                "CLIENTID", "CODE" }),
        @UniqueConstraint(name = "MM_PROD_CATEGORY_UK2", columnNames = {
                "CLIENTID", "NAME" }) })
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = "ProductCategory.findById", query = "SELECT e FROM ProductCategory e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ProductCategory.findByIds", query = "SELECT e FROM ProductCategory e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ProductCategory.findByCode", query = "SELECT e FROM ProductCategory e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ProductCategory.findByName", query = "SELECT e FROM ProductCategory e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ProductCategory implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "MM_PROD_CATEGORY";
    public static final String SEQUENCE_NAME = "MM_PROD_CATEGORY_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ProductCategory.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ProductCategory.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "ProductCategory.findByCode";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "ProductCategory.findByName";

    /** Parent category. */
    @Column(name = "FOLDER", nullable = false)
    @NotNull
    private Boolean folder;

    /** Name. */
    @Column(name = "NAME", nullable = false, length = 255)
    @NotBlank
    private String name;

    /** Code. */
    @Column(name = "CODE", nullable = false, length = 32)
    @NotBlank
    private String code;

    /** Flag which indicates if this record is used.*/
    @Column(name = "ACTIVE", nullable = false)
    @NotNull
    private Boolean active;

    /** Notes about this record. */
    @Column(name = "NOTES", length = 4000)
    private String notes;

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

    @ManyToMany(mappedBy = "categories")
    private Collection<Product> products;

    /* ============== getters - setters ================== */

    public Boolean getFolder() {
        return this.folder;
    }

    public void setFolder(Boolean folder) {
        this.folder = folder;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

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

    public Collection<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
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
        if (this.folder == null) {
            event.updateAttributeWithObject("folder", false);
        }
        if (this.active == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {

        ProductCategory e = (ProductCategory) event.getSource();
        e.setModifiedAt(new Date());
        e.setModifiedBy(Session.user.get().getUsername());

    }

}
