/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.acc.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.AccountGroup;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Accounting schema definition.  */
@Entity
@Table(name = Account.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = Account.TABLE_NAME + "_UK1", columnNames = {
                "CLIENTID", "CODE" }),
        @UniqueConstraint(name = Account.TABLE_NAME + "_UK2", columnNames = {
                "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Account.NQ_FIND_BY_ID, query = "SELECT e FROM Account e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Account.NQ_FIND_BY_IDS, query = "SELECT e FROM Account e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Account.NQ_FIND_BY_CODE, query = "SELECT e FROM Account e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Account.NQ_FIND_BY_NAME, query = "SELECT e FROM Account e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Account extends AbstractTypeWithCode {

    public static final String TABLE_NAME = "BD_ACC_ACCOUNT";
    public static final String SEQUENCE_NAME = "BD_ACC_ACCOUNT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Account.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Account.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "Account.findByCode";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "Account.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Sign. */
    @Column(name = "SIGN", nullable = false, length = 16)
    @NotBlank
    private String sign;

    /** Summary. */
    @Column(name = "SUMMARY", nullable = false)
    @NotNull
    private Boolean summary;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccSchema.class)
    @JoinColumn(name = "ACCSCHEMA_ID", referencedColumnName = "ID")
    private AccSchema accSchema;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccountGroup.class)
    @JoinColumn(name = "ACCGROUP_ID", referencedColumnName = "ID")
    private AccountGroup accGroup;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Boolean getSummary() {
        return this.summary;
    }

    public void setSummary(Boolean summary) {
        this.summary = summary;
    }

    public AccSchema getAccSchema() {
        return this.accSchema;
    }

    public void setAccSchema(AccSchema accSchema) {
        this.accSchema = accSchema;
    }

    public AccountGroup getAccGroup() {
        return this.accGroup;
    }

    public void setAccGroup(AccountGroup accGroup) {
        this.accGroup = accGroup;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.summary == null) {
            event.updateAttributeWithObject("summary", false);
        }
        if (this.active == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
