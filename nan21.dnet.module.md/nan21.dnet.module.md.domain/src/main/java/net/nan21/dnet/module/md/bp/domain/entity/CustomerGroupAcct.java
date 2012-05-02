/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.domain.entity;

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
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** CustomerGroupAcct. */
@Entity
@Table(name = CustomerGroupAcct.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = CustomerGroupAcct.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "CUSTGROUP_ID", "ACCSCHEMA_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = CustomerGroupAcct.NQ_FIND_BY_ID, query = "SELECT e FROM CustomerGroupAcct e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = CustomerGroupAcct.NQ_FIND_BY_IDS, query = "SELECT e FROM CustomerGroupAcct e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = CustomerGroupAcct.NQ_FIND_BY_GROUP_SCHEMA, query = "SELECT e FROM CustomerGroupAcct e WHERE e.clientId = :pClientId and  e.custGroup = :pCustGroup and e.accSchema = :pAccSchema ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "CustomerGroupAcct.findByGroup_schema_PRIMITIVE", query = "SELECT e FROM CustomerGroupAcct e WHERE e.clientId = :pClientId and  e.custGroup.id = :pCustGroupId and e.accSchema.id = :pAccSchemaId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class CustomerGroupAcct extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_BP_CUSTGROUP_ACCT";
    public static final String SEQUENCE_NAME = "MD_BP_CUSTGROUP_ACCT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "CustomerGroupAcct.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "CustomerGroupAcct.findByIds";

    /**
     * Named query find by unique key: Group_schema.
     */
    public static final String NQ_FIND_BY_GROUP_SCHEMA = "CustomerGroupAcct.findByGroup_schema";

    /**
     * Named query find by unique key: Group_schema using the ID field for references.
     */
    public static final String NQ_FIND_BY_GROUP_SCHEMA_PRIMITIVE = "CustomerGroupAcct.findByGroup_schema_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CustomerGroup.class)
    @JoinColumn(name = "CUSTGROUP_ID", referencedColumnName = "ID")
    private CustomerGroup custGroup;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccSchema.class)
    @JoinColumn(name = "ACCSCHEMA_ID", referencedColumnName = "ID")
    private AccSchema accSchema;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "SALESACCOUNT_ID", referencedColumnName = "ID")
    private Account salesAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "PREPAYACCOUNT_ID", referencedColumnName = "ID")
    private Account prepayAccount;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerGroup getCustGroup() {
        return this.custGroup;
    }

    public void setCustGroup(CustomerGroup custGroup) {
        this.custGroup = custGroup;
    }

    public AccSchema getAccSchema() {
        return this.accSchema;
    }

    public void setAccSchema(AccSchema accSchema) {
        this.accSchema = accSchema;
    }

    public Account getSalesAccount() {
        return this.salesAccount;
    }

    public void setSalesAccount(Account salesAccount) {
        this.salesAccount = salesAccount;
    }

    public Account getPrepayAccount() {
        return this.prepayAccount;
    }

    public void setPrepayAccount(Account prepayAccount) {
        this.prepayAccount = prepayAccount;
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
