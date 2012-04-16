/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.domain.entity;

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
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** WfDefTransition. */
@Entity
@Table(name = WfDefTransition.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = WfDefTransition.NQ_FIND_BY_ID, query = "SELECT e FROM WfDefTransition e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = WfDefTransition.NQ_FIND_BY_IDS, query = "SELECT e FROM WfDefTransition e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class WfDefTransition extends AbstractAuditable {

    public static final String TABLE_NAME = "AD_WFDEF_TRANSITION";
    public static final String SEQUENCE_NAME = "AD_WFDEF_TRANSITION_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "WfDefTransition.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "WfDefTransition.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Condition. */
    @Column(name = "COND", length = 4000)
    private String condition;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = WfDefProcess.class)
    @JoinColumn(name = "PROCESS_ID", referencedColumnName = "ID")
    private WfDefProcess process;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = WfDefNode.class)
    @JoinColumn(name = "SOURCE_ID", referencedColumnName = "ID")
    private WfDefNode source;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = WfDefNode.class)
    @JoinColumn(name = "TARGET_ID", referencedColumnName = "ID")
    private WfDefNode target;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public WfDefProcess getProcess() {
        return this.process;
    }

    public void setProcess(WfDefProcess process) {
        this.process = process;
    }

    public WfDefNode getSource() {
        return this.source;
    }

    public void setSource(WfDefNode source) {
        this.source = source;
    }

    public WfDefNode getTarget() {
        return this.target;
    }

    public void setTarget(WfDefNode target) {
        this.target = target;
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
