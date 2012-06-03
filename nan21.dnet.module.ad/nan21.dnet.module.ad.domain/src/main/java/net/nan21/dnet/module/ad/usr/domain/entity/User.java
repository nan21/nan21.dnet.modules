/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.domain.entity;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import net.nan21.dnet.module.ad.system.domain.entity.SysDateFormat;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;
import net.nan21.dnet.module.ad.usr.domain.eventhandler.UserEventHandler;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** User. */
@Entity
@Table(name = User.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = User.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "CODE" }) })
@Customizer(UserEventHandler.class)
@NamedQueries({
        @NamedQuery(name = User.NQ_FIND_BY_ID, query = "SELECT e FROM User e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = User.NQ_FIND_BY_IDS, query = "SELECT e FROM User e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = User.NQ_FIND_BY_CODE, query = "SELECT e FROM User e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class User extends AbstractTypeWithCode {

    public static final String TABLE_NAME = "AD_USR";
    public static final String SEQUENCE_NAME = "AD_USR_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "User.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "User.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "User.findByCode";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Flag which indicates that account is locked.*/
    @Column(name = "LOCKED", nullable = false)
    @NotNull
    private Boolean locked;

    /** User password.*/
    @Column(name = "PASSWORD", nullable = false, length = 255)
    @NotBlank
    private String password;

    /** DecimalSeparator. */
    @Column(name = "DECIMALSEPARATOR", length = 1)
    private String decimalSeparator;

    /** ThousandSeparator. */
    @Column(name = "THOUSANDSEPARATOR", length = 1)
    private String thousandSeparator;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SysDateFormat.class)
    @JoinColumn(name = "DATEFORMAT_ID", referencedColumnName = "ID")
    private SysDateFormat dateFormat;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserType.class)
    @JoinColumn(name = "ACCOUNTTYPE_ID", referencedColumnName = "ID")
    private UserType accountType;

    @ManyToMany
    @JoinTable(name = "AD_USR_ROLE")
    private Collection<Role> roles;

    @ManyToMany
    @JoinTable(name = "AD_USR_USRGRP")
    private Collection<UserGroup> groups;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getLocked() {
        return this.locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public void setDecimalSeparator(String decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    public String getThousandSeparator() {
        return this.thousandSeparator;
    }

    public void setThousandSeparator(String thousandSeparator) {
        this.thousandSeparator = thousandSeparator;
    }

    public SysDateFormat getDateFormat() {
        return this.dateFormat;
    }

    public void setDateFormat(SysDateFormat dateFormat) {
        if (dateFormat != null) {
            this.__validate_client_context__(dateFormat.getClientId());
        }
        this.dateFormat = dateFormat;
    }

    public UserType getAccountType() {
        return this.accountType;
    }

    public void setAccountType(UserType accountType) {
        if (accountType != null) {
            this.__validate_client_context__(accountType.getClientId());
        }
        this.accountType = accountType;
    }

    public Collection<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Collection<UserGroup> getGroups() {
        return this.groups;
    }

    public void setGroups(Collection<UserGroup> groups) {
        this.groups = groups;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getLocked() == null) {
            event.updateAttributeWithObject("locked", false);
        }
        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
