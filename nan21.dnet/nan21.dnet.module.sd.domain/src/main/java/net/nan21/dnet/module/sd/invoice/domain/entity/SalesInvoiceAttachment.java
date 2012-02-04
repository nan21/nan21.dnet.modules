/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.domain.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.ad.data.domain.entity.Attachment;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** SalesInvoiceAttachment. */
@Entity
@DiscriminatorValue("SalesInvoice")
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = SalesInvoiceAttachment.NQ_FIND_BY_ID, query = "SELECT e FROM SalesInvoiceAttachment e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SalesInvoiceAttachment.NQ_FIND_BY_IDS, query = "SELECT e FROM SalesInvoiceAttachment e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class SalesInvoiceAttachment extends Attachment implements Serializable,
        IModelWithId, IModelWithClientId {

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "SalesInvoiceAttachment.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "SalesInvoiceAttachment.findByIds";

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SalesInvoice.class)
    @JoinColumn(name = "SALESINVOICE_ID", referencedColumnName = "ID")
    private SalesInvoice invoice;

    /* ============== getters - setters ================== */

    public SalesInvoice getInvoice() {
        return this.invoice;
    }

    public void setInvoice(SalesInvoice invoice) {
        this.invoice = invoice;
    }

    public void aboutToInsert(DescriptorEvent event) {
        super.aboutToInsert(event);
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);

    }

}
