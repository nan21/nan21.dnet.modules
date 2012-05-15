/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
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
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.md.bp.domain.entity.Bank;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Business partner bank accounts. */
@Entity
@Table(name = BpBankAccount.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = BpBankAccount.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "BPARTNER_ID", "ACCOUNTNO" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = BpBankAccount.NQ_FIND_BY_ID, query = "SELECT e FROM BpBankAccount e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = BpBankAccount.NQ_FIND_BY_IDS, query = "SELECT e FROM BpBankAccount e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = BpBankAccount.NQ_FIND_BY_ACCOUNT, query = "SELECT e FROM BpBankAccount e WHERE e.clientId = :pClientId and  e.bpartner = :pBpartner and e.accountNo = :pAccountNo ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "BpBankAccount.findByAccount_PRIMITIVE", query = "SELECT e FROM BpBankAccount e WHERE e.clientId = :pClientId and  e.bpartner.id = :pBpartnerId and e.accountNo = :pAccountNo ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class BpBankAccount extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_BP_BANKACCOUNT";
    public static final String SEQUENCE_NAME = "MD_BP_BANKACCOUNT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "BpBankAccount.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "BpBankAccount.findByIds";

    /**
     * Named query find by unique key: Account.
     */
    public static final String NQ_FIND_BY_ACCOUNT = "BpBankAccount.findByAccount";

    /**
     * Named query find by unique key: Account using the ID field for references.
     */
    public static final String NQ_FIND_BY_ACCOUNT_PRIMITIVE = "BpBankAccount.findByAccount_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Bank branch where this account is opened. */
    @Column(name = "BANKBRANCH", length = 255)
    private String bankBranch;

    /** Account number. */
    @Column(name = "ACCOUNTNO", nullable = false, length = 32)
    @NotBlank
    private String accountNo;

    /** Flag which indicates if the account number represents an IBAN account. */
    @Column(name = "IBANACCOUNT", nullable = false)
    @NotNull
    private Boolean ibanAccount;

    /** Notes. */
    @Column(name = "NOTES", length = 4000)
    private String notes;

    /** Active. */
    @Column(name = "ACTIVE", nullable = false)
    @NotNull
    private Boolean active;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "BPARTNER_ID", referencedColumnName = "ID")
    private BusinessPartner bpartner;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Bank.class)
    @JoinColumn(name = "BANK_ID", referencedColumnName = "ID")
    private Bank bank;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
    @JoinColumn(name = "CURRENCY_ID", referencedColumnName = "ID")
    private Currency currency;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankBranch() {
        return this.bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Boolean getIbanAccount() {
        return this.ibanAccount;
    }

    public void setIbanAccount(Boolean ibanAccount) {
        this.ibanAccount = ibanAccount;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public BusinessPartner getBpartner() {
        return this.bpartner;
    }

    public void setBpartner(BusinessPartner bpartner) {
        this.bpartner = bpartner;
    }

    public Bank getBank() {
        return this.bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getIbanAccount() == null) {
            event.updateAttributeWithObject("ibanAccount", false);
        }
        if (this.getActive() == null) {
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
