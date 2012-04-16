/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.domain.entity;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Product categories. */
@Entity
@Table(name = ProductCategory.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = ProductCategory.TABLE_NAME + "_UK1", columnNames = {
                "CLIENTID", "CODE" }),
        @UniqueConstraint(name = ProductCategory.TABLE_NAME + "_UK2", columnNames = {
                "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ProductCategory.NQ_FIND_BY_ID, query = "SELECT e FROM ProductCategory e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductCategory.NQ_FIND_BY_IDS, query = "SELECT e FROM ProductCategory e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductCategory.NQ_FIND_BY_CODE, query = "SELECT e FROM ProductCategory e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductCategory.NQ_FIND_BY_NAME, query = "SELECT e FROM ProductCategory e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ProductCategory extends AbstractTypeWithCode {

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

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Parent category. */
    @Column(name = "FOLDER", nullable = false)
    @NotNull
    private Boolean folder;

    /** IconUrl. */
    @Column(name = "ICONURL", length = 255)
    private String iconUrl;

    @ManyToMany(mappedBy = "categories")
    private Collection<Product> products;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFolder() {
        return this.folder;
    }

    public void setFolder(Boolean folder) {
        this.folder = folder;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Collection<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.folder == null) {
            event.updateAttributeWithObject("folder", false);
        }
        if (this.active == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
