/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.domain.entity;

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
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobParam;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** SysJobCtxParam. */
@Entity
@Table(name = SysJobCtxParam.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = SysJobCtxParam.NQ_FIND_BY_ID, query = "SELECT e FROM SysJobCtxParam e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysJobCtxParam.NQ_FIND_BY_IDS, query = "SELECT e FROM SysJobCtxParam e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class SysJobCtxParam extends AbstractAuditable {

    public static final String TABLE_NAME = "AD_SYS_JOBCTX_PARAM";
    public static final String SEQUENCE_NAME = "AD_SYS_JOBCTX_PARAM_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "SysJobCtxParam.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "SysJobCtxParam.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Value. */
    @Column(name = "VALUE", length = 400)
    private String value;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SysJobCtx.class)
    @JoinColumn(name = "JOBCTX_ID", referencedColumnName = "ID")
    private SysJobCtx jobCtx;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SysJobParam.class)
    @JoinColumn(name = "JOBPARAM_ID", referencedColumnName = "ID")
    private SysJobParam jobParam;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SysJobCtx getJobCtx() {
        return this.jobCtx;
    }

    public void setJobCtx(SysJobCtx jobCtx) {
        this.jobCtx = jobCtx;
    }

    public SysJobParam getJobParam() {
        return this.jobParam;
    }

    public void setJobParam(SysJobParam jobParam) {
        this.jobParam = jobParam;
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
