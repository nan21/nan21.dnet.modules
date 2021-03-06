/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Product account groups.*/
@Entity
@Table(name = ProductAccountGroup.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = ProductAccountGroup.TABLE_NAME + "_UK1", columnNames = {
                "CLIENTID", "CODE" }),
        @UniqueConstraint(name = ProductAccountGroup.TABLE_NAME + "_UK2", columnNames = {
                "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ProductAccountGroup.NQ_FIND_BY_ID, query = "SELECT e FROM ProductAccountGroup e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAccountGroup.NQ_FIND_BY_IDS, query = "SELECT e FROM ProductAccountGroup e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAccountGroup.NQ_FIND_BY_CODE, query = "SELECT e FROM ProductAccountGroup e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAccountGroup.NQ_FIND_BY_NAME, query = "SELECT e FROM ProductAccountGroup e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ProductAccountGroup extends AbstractTypeWithCode {

    public static final String TABLE_NAME = "MD_PROD_ACNT_GRP";
    public static final String SEQUENCE_NAME = "MD_PROD_ACNT_GRP_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ProductAccountGroup.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ProductAccountGroup.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "ProductAccountGroup.findByCode";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "ProductAccountGroup.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ProductAccountGroupAcct.class, mappedBy = "group", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<ProductAccountGroupAcct> accounts;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<ProductAccountGroupAcct> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(Collection<ProductAccountGroupAcct> accounts) {
        this.accounts = accounts;
    }

    public void addToAccounts(ProductAccountGroupAcct e) {
        if (this.accounts == null) {
            this.accounts = new ArrayList<ProductAccountGroupAcct>();
        }
        e.setGroup(this);
        this.accounts.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
