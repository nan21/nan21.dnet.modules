/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.fin.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.bd.fin.domain.entity.TaxCategory;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Tax definition.  */
@Entity
@Table(name = Tax.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = Tax.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Tax.NQ_FIND_BY_ID, query = "SELECT e FROM Tax e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Tax.NQ_FIND_BY_IDS, query = "SELECT e FROM Tax e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Tax.NQ_FIND_BY_NAME, query = "SELECT e FROM Tax e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Tax extends AbstractType {

    public static final String TABLE_NAME = "BD_TAX";
    public static final String SEQUENCE_NAME = "BD_TAX_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Tax.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Tax.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "Tax.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Rate. */
    @Column(name = "RATE", nullable = false, scale = 2)
    @NotNull
    private Float rate;

    /** Summary. */
    @Column(name = "SUMMARY", nullable = false)
    @NotNull
    private Boolean summary;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TaxCategory.class)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private TaxCategory category;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Tax.class)
    @JoinColumn(name = "PARENTTAX_ID", referencedColumnName = "ID")
    private Tax parentTax;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Tax.class, mappedBy = "parentTax")
    private Collection<Tax> children;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getRate() {
        return this.rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Boolean getSummary() {
        return this.summary;
    }

    public void setSummary(Boolean summary) {
        this.summary = summary;
    }

    public TaxCategory getCategory() {
        return this.category;
    }

    public void setCategory(TaxCategory category) {
        this.category = category;
    }

    public Tax getParentTax() {
        return this.parentTax;
    }

    public void setParentTax(Tax parentTax) {
        this.parentTax = parentTax;
    }

    public Collection<Tax> getChildren() {
        return this.children;
    }

    public void setChildren(Collection<Tax> children) {
        this.children = children;
    }

    public void addToChildren(Tax e) {
        if (this.children == null) {
            this.children = new ArrayList<Tax>();
        }
        e.setParentTax(this);
        this.children.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getSummary() == null) {
            event.updateAttributeWithObject("summary", false);
        }
        if (this.getActive() == null) {
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
