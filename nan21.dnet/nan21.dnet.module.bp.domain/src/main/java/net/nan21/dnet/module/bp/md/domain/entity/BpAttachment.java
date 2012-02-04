/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.domain.entity;

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
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** BpAttachment. */
@Entity
@DiscriminatorValue("BPartner")
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = BpAttachment.NQ_FIND_BY_ID, query = "SELECT e FROM BpAttachment e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = BpAttachment.NQ_FIND_BY_IDS, query = "SELECT e FROM BpAttachment e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class BpAttachment extends Attachment implements Serializable,
        IModelWithId, IModelWithClientId {

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "BpAttachment.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "BpAttachment.findByIds";

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "BPARTNER_ID", referencedColumnName = "ID")
    private BusinessPartner bpartner;

    /* ============== getters - setters ================== */

    public BusinessPartner getBpartner() {
        return this.bpartner;
    }

    public void setBpartner(BusinessPartner bpartner) {
        this.bpartner = bpartner;
    }

    public void aboutToInsert(DescriptorEvent event) {
        super.aboutToInsert(event);
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);

    }

}
