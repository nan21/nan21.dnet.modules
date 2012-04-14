/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.order.domain.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** PurchaseInventoryTransaction. */
@Entity
@CascadeOnDelete
@DiscriminatorValue("PO")
@Table(name = PurchaseInventoryTransaction.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = PurchaseInventoryTransaction.NQ_FIND_BY_ID, query = "SELECT e FROM PurchaseInventoryTransaction e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PurchaseInventoryTransaction.NQ_FIND_BY_IDS, query = "SELECT e FROM PurchaseInventoryTransaction e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class PurchaseInventoryTransaction extends InvTransaction implements
        Serializable, IModelWithId, IModelWithClientId {

    public static final String TABLE_NAME = "SC_PURCHASE_INV_TX";
    public static final String SEQUENCE_NAME = "SC_PURCHASE_INV_TX_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "PurchaseInventoryTransaction.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "PurchaseInventoryTransaction.findByIds";

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "ID")
    private BusinessPartner supplier;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PurchaseOrder.class)
    @JoinColumn(name = "PURCHASEORDER_ID", referencedColumnName = "ID")
    private PurchaseOrder purchaseOrder;

    /* ============== getters - setters ================== */

    public BusinessPartner getSupplier() {
        return this.supplier;
    }

    public void setSupplier(BusinessPartner supplier) {
        this.supplier = supplier;
    }

    public PurchaseOrder getPurchaseOrder() {
        return this.purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public void aboutToInsert(DescriptorEvent event) {
        super.aboutToInsert(event);
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);

    }

}
