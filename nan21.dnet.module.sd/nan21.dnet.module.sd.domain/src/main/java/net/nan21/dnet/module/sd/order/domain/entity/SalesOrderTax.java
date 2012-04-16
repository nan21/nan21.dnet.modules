/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.domain.entity;

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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** SalesOrderTax. */
@Entity
@Table(name = SalesOrderTax.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = SalesOrderTax.NQ_FIND_BY_ID, query = "SELECT e FROM SalesOrderTax e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SalesOrderTax.NQ_FIND_BY_IDS, query = "SELECT e FROM SalesOrderTax e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class SalesOrderTax extends AbstractAuditable {

    public static final String TABLE_NAME = "SD_SO_TAX";
    public static final String SEQUENCE_NAME = "SD_SO_TAX_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "SalesOrderTax.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "SalesOrderTax.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** BaseAmount. */
    @Column(name = "BASEAMOUNT", nullable = false, scale = 2)
    @NotNull
    private Float baseAmount;

    /** TaxAmount. */
    @Column(name = "TAXAMOUNT", nullable = false, scale = 2)
    @NotNull
    private Float taxAmount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SalesOrder.class)
    @JoinColumn(name = "SALESORDER_ID", referencedColumnName = "ID")
    private SalesOrder salesOrder;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Tax.class)
    @JoinColumn(name = "TAX_ID", referencedColumnName = "ID")
    private Tax tax;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getBaseAmount() {
        return this.baseAmount;
    }

    public void setBaseAmount(Float baseAmount) {
        this.baseAmount = baseAmount;
    }

    public Float getTaxAmount() {
        return this.taxAmount;
    }

    public void setTaxAmount(Float taxAmount) {
        this.taxAmount = taxAmount;
    }

    public SalesOrder getSalesOrder() {
        return this.salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Tax getTax() {
        return this.tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
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
