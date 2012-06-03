/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.res.domain.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/**
 Base asset definition. It is meant to be extended by the asset management in the accounting module.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ENTITYTYPE", discriminatorType = DiscriminatorType.STRING, length = 32)
@Table(name = AssetBase.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = AssetBase.TABLE_NAME + "_UK1", columnNames = {
                "CLIENTID", "CODE" }),
        @UniqueConstraint(name = AssetBase.TABLE_NAME + "_UK2", columnNames = {
                "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = AssetBase.NQ_FIND_BY_ID, query = "SELECT e FROM AssetBase e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AssetBase.NQ_FIND_BY_IDS, query = "SELECT e FROM AssetBase e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AssetBase.NQ_FIND_BY_CODE, query = "SELECT e FROM AssetBase e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AssetBase.NQ_FIND_BY_NAME, query = "SELECT e FROM AssetBase e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class AssetBase extends AbstractTypeWithCode {

    public static final String TABLE_NAME = "MD_RES_ASSET";
    public static final String SEQUENCE_NAME = "MD_RES_ASSET_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "AssetBase.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "AssetBase.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "AssetBase.findByCode";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "AssetBase.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** EntityType. */
    @Column(name = "ENTITYTYPE", length = 32)
    private String entityType;

    /** InitialValue. */
    @Column(name = "INITIALVALUE", scale = 2)
    private Float initialValue;

    /** ResidualValue. */
    @Column(name = "RESIDUALVALUE", scale = 2)
    private Float residualValue;

    /** DepreciationAmount. */
    @Column(name = "DEPRECIATIONAMOUNT", scale = 2)
    private Float depreciationAmount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
    private Organization org;
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

    public String getEntityType() {
        return this.entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Float getInitialValue() {
        return this.initialValue;
    }

    public void setInitialValue(Float initialValue) {
        this.initialValue = initialValue;
    }

    public Float getResidualValue() {
        return this.residualValue;
    }

    public void setResidualValue(Float residualValue) {
        this.residualValue = residualValue;
    }

    public Float getDepreciationAmount() {
        return this.depreciationAmount;
    }

    public void setDepreciationAmount(Float depreciationAmount) {
        this.depreciationAmount = depreciationAmount;
    }

    public Organization getOrg() {
        return this.org;
    }

    public void setOrg(Organization org) {
        if (org != null) {
            this.__validate_client_context__(org.getClientId());
        }
        this.org = org;
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

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
