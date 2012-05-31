/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.domain.entity;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** PayAccountMethod. */
@Entity
@Table(name = PayAccountMethod.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = PayAccountMethod.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "PAYACCOUNT_ID", "PAYMETHOD_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = PayAccountMethod.NQ_FIND_BY_ID, query = "SELECT e FROM PayAccountMethod e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PayAccountMethod.NQ_FIND_BY_IDS, query = "SELECT e FROM PayAccountMethod e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PayAccountMethod.NQ_FIND_BY_ACCOUNT_MTD, query = "SELECT e FROM PayAccountMethod e WHERE e.clientId = :pClientId and  e.payAccount = :pPayAccount and e.payMethod = :pPayMethod ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "PayAccountMethod.findByAccount_mtd_PRIMITIVE", query = "SELECT e FROM PayAccountMethod e WHERE e.clientId = :pClientId and  e.payAccount.id = :pPayAccountId and e.payMethod.id = :pPayMethodId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class PayAccountMethod extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_FINACNT_MTD";
    public static final String SEQUENCE_NAME = "MD_FINACNT_MTD_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "PayAccountMethod.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "PayAccountMethod.findByIds";

    /**
     * Named query find by unique key: Account_mtd.
     */
    public static final String NQ_FIND_BY_ACCOUNT_MTD = "PayAccountMethod.findByAccount_mtd";

    /**
     * Named query find by unique key: Account_mtd using the ID field for references.
     */
    public static final String NQ_FIND_BY_ACCOUNT_MTD_PRIMITIVE = "PayAccountMethod.findByAccount_mtd_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** AllowPayIn. */
    @Column(name = "ALLOWPAYIN", nullable = false)
    @NotNull
    private Boolean allowPayIn;

    /** AllowPayOut. */
    @Column(name = "ALLOWPAYOUT", nullable = false)
    @NotNull
    private Boolean allowPayOut;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PayAccount.class)
    @JoinColumn(name = "PAYACCOUNT_ID", referencedColumnName = "ID")
    private PayAccount payAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentMethod.class)
    @JoinColumn(name = "PAYMETHOD_ID", referencedColumnName = "ID")
    private PaymentMethod payMethod;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAllowPayIn() {
        return this.allowPayIn;
    }

    public void setAllowPayIn(Boolean allowPayIn) {
        this.allowPayIn = allowPayIn;
    }

    public Boolean getAllowPayOut() {
        return this.allowPayOut;
    }

    public void setAllowPayOut(Boolean allowPayOut) {
        this.allowPayOut = allowPayOut;
    }

    public PayAccount getPayAccount() {
        return this.payAccount;
    }

    public void setPayAccount(PayAccount payAccount) {
        this.payAccount = payAccount;
    }

    public PaymentMethod getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(PaymentMethod payMethod) {
        this.payMethod = payMethod;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getAllowPayIn() == null) {
            event.updateAttributeWithObject("allowPayIn", false);
        }
        if (this.getAllowPayOut() == null) {
            event.updateAttributeWithObject("allowPayOut", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
