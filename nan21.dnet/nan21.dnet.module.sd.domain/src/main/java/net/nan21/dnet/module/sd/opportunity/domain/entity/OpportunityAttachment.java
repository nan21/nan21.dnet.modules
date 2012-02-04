/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.domain.entity;

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
import net.nan21.dnet.module.sd.opportunity.domain.entity.Opportunity;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** OpportunityAttachment. */
@Entity
@DiscriminatorValue("Opportunity")
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = OpportunityAttachment.NQ_FIND_BY_ID, query = "SELECT e FROM OpportunityAttachment e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = OpportunityAttachment.NQ_FIND_BY_IDS, query = "SELECT e FROM OpportunityAttachment e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class OpportunityAttachment extends Attachment implements Serializable,
        IModelWithId, IModelWithClientId {

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "OpportunityAttachment.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "OpportunityAttachment.findByIds";

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Opportunity.class)
    @JoinColumn(name = "OPPORTUNITY_ID", referencedColumnName = "ID")
    private Opportunity opportunity;

    /* ============== getters - setters ================== */

    public Opportunity getOpportunity() {
        return this.opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    public void aboutToInsert(DescriptorEvent event) {
        super.aboutToInsert(event);
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);

    }

}
