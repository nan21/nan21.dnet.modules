/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** ActIdentityUser. */
@Entity
@Table(name = ActIdentityUser.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ActIdentityUser.NQ_FIND_BY_ID, query = "SELECT e FROM ActIdentityUser e WHERE  e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ActIdentityUser.NQ_FIND_BY_IDS, query = "SELECT e FROM ActIdentityUser e WHERE  e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
@Cache(type = CacheType.NONE)
public class ActIdentityUser implements IModelWithId {

    public static final String TABLE_NAME = "ACT_ID_USER";
    public static final String SEQUENCE_NAME = "ACT_ID_USER_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ActIdentityUser.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ActIdentityUser.findByIds";

    /** Id. */
    @Column(name = "ID_", nullable = false, length = 64)
    @NotBlank
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private String id;

    /** Revision. */
    @Column(name = "REV_")
    private Integer revision;

    /** First. */
    @Column(name = "FIRST_", nullable = false, length = 255)
    @NotBlank
    private String first;

    /** Last. */
    @Column(name = "LAST_", nullable = false, length = 255)
    @NotBlank
    private String last;

    /** Email. */
    @Column(name = "EMAIL_", nullable = false, length = 255)
    @NotBlank
    private String email;

    /** Password. */
    @Column(name = "PWD_", nullable = false, length = 255)
    @NotBlank
    private String password;

    /** PictureId. */
    @Column(name = "PICTURE_ID_", length = 64)
    private String pictureId;

    @ManyToMany
    @JoinTable(name = "ACT_ID_MEMBERSHIP", joinColumns = { @JoinColumn(name = "USER_ID_") }, inverseJoinColumns = { @JoinColumn(name = "GROUP_ID_") })
    private Collection<ActIdentityGroup> groups;

    /* ============== getters - setters ================== */

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRevision() {
        return this.revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getFirst() {
        return this.first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return this.last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPictureId() {
        return this.pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    @Transient
    public Long getVersion() {
        return 1L;
    }

    public void setVersion(Long version) {

    }

    public Collection<ActIdentityGroup> getGroups() {
        return this.groups;
    }

    public void setGroups(Collection<ActIdentityGroup> groups) {
        this.groups = groups;
    }

    public void aboutToInsert(DescriptorEvent event) {

    }

    public void aboutToUpdate(DescriptorEvent event) {

    }

}
