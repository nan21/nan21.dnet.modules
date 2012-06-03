/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.domain.entity;

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
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** PayrollElement. */
@Entity
@CascadeOnDelete
@Table(name = PayrollElement.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = PayrollElement.NQ_FIND_BY_ID, query = "SELECT e FROM PayrollElement e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PayrollElement.NQ_FIND_BY_IDS, query = "SELECT e FROM PayrollElement e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PayrollElement.NQ_FIND_BY_ENGINE_CODE, query = "SELECT e FROM PayrollElement e WHERE e.clientId = :pClientId and  e.engine = :pEngine and e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PayrollElement.NQ_FIND_BY_ENGINE_CODE_PRIMITIVE, query = "SELECT e FROM PayrollElement e WHERE e.clientId = :pClientId and  e.engine.id = :pEngineId and e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class PayrollElement extends Element {

    public static final String TABLE_NAME = "HR_PAYROLL_ELEM";
    public static final String SEQUENCE_NAME = "HR_PAYROLL_ELEM_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "PayrollElement.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "PayrollElement.findByIds";

    /**
     * Named query find by unique key: Engine_code.
     */
    public static final String NQ_FIND_BY_ENGINE_CODE = "PayrollElement.findByEngine_code";

    /**
     * Named query find by unique key: Engine_code using the ID field for references.
     */
    public static final String NQ_FIND_BY_ENGINE_CODE_PRIMITIVE = "PayrollElement.findByEngine_code_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Balance. */
    @Column(name = "BALANCE", nullable = false)
    @NotNull
    private Boolean balance;

    /** BalanceFunction. */
    @Column(name = "BALANCEFUNCTION", length = 16)
    private String balanceFunction;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccItem.class)
    @JoinColumn(name = "ACCITEM_ID", referencedColumnName = "ID")
    private AccItem accItem;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PayrollElement.class)
    @JoinColumn(name = "SOURCEELEMENT_ID", referencedColumnName = "ID")
    private PayrollElement sourceElement;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getBalance() {
        return this.balance;
    }

    public void setBalance(Boolean balance) {
        this.balance = balance;
    }

    public String getBalanceFunction() {
        return this.balanceFunction;
    }

    public void setBalanceFunction(String balanceFunction) {
        this.balanceFunction = balanceFunction;
    }

    public AccItem getAccItem() {
        return this.accItem;
    }

    public void setAccItem(AccItem accItem) {
        if (accItem != null) {
            this.__validate_client_context__(accItem.getClientId());
        }
        this.accItem = accItem;
    }

    public PayrollElement getSourceElement() {
        return this.sourceElement;
    }

    public void setSourceElement(PayrollElement sourceElement) {
        if (sourceElement != null) {
            this.__validate_client_context__(sourceElement.getClientId());
        }
        this.sourceElement = sourceElement;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getBalance() == null) {
            event.updateAttributeWithObject("balance", false);
        }
    }

}
