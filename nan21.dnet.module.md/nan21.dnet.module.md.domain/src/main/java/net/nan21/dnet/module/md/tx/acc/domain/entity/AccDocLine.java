/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.acc.domain.entity;

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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.res.domain.entity.AssetBase;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** AccDocLine. */
@Entity
@Table(name = AccDocLine.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = AccDocLine.NQ_FIND_BY_ID, query = "SELECT e FROM AccDocLine e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AccDocLine.NQ_FIND_BY_IDS, query = "SELECT e FROM AccDocLine e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class AccDocLine extends AbstractAuditable {

    public static final String TABLE_NAME = "TX_ACC_DOC_LINE";
    public static final String SEQUENCE_NAME = "TX_ACC_DOC_LINE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "AccDocLine.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "AccDocLine.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** SequenceNo. */
    @Column(name = "SEQUENCENO")
    private Integer sequenceNo;

    /** HeaderLine. */
    @Column(name = "HEADERLINE", nullable = false)
    @NotNull
    private Boolean headerLine;

    /** DbAccount. */
    @Column(name = "DBACCOUNT", length = 255)
    private String dbAccount;

    /** CrAccount. */
    @Column(name = "CRACCOUNT", length = 255)
    private String crAccount;

    /** DbAmount. */
    @Column(name = "DBAMOUNT", scale = 2)
    private Float dbAmount;

    /** CrAmount. */
    @Column(name = "CRAMOUNT", scale = 2)
    private Float crAmount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccDoc.class)
    @JoinColumn(name = "ACCDOC_ID", referencedColumnName = "ID")
    private AccDoc accDoc;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AssetBase.class)
    @JoinColumn(name = "ASSET_ID", referencedColumnName = "ID")
    private AssetBase asset;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Boolean getHeaderLine() {
        return this.headerLine;
    }

    public void setHeaderLine(Boolean headerLine) {
        this.headerLine = headerLine;
    }

    public String getDbAccount() {
        return this.dbAccount;
    }

    public void setDbAccount(String dbAccount) {
        this.dbAccount = dbAccount;
    }

    public String getCrAccount() {
        return this.crAccount;
    }

    public void setCrAccount(String crAccount) {
        this.crAccount = crAccount;
    }

    public Float getDbAmount() {
        return this.dbAmount;
    }

    public void setDbAmount(Float dbAmount) {
        this.dbAmount = dbAmount;
    }

    public Float getCrAmount() {
        return this.crAmount;
    }

    public void setCrAmount(Float crAmount) {
        this.crAmount = crAmount;
    }

    public AccDoc getAccDoc() {
        return this.accDoc;
    }

    public void setAccDoc(AccDoc accDoc) {
        if (accDoc != null) {
            this.__validate_client_context__(accDoc.getClientId());
        }
        this.accDoc = accDoc;
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

    public AssetBase getAsset() {
        return this.asset;
    }

    public void setAsset(AssetBase asset) {
        if (asset != null) {
            this.__validate_client_context__(asset.getClientId());
        }
        this.asset = asset;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getHeaderLine() == null) {
            event.updateAttributeWithObject("headerLine", false);
        }
    }

}
