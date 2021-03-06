/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.domain.entity;

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
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectCategory;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** ProjectType. */
@Entity
@Table(name = ProjectType.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = ProjectType.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ProjectType.NQ_FIND_BY_ID, query = "SELECT e FROM ProjectType e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProjectType.NQ_FIND_BY_IDS, query = "SELECT e FROM ProjectType e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProjectType.NQ_FIND_BY_NAME, query = "SELECT e FROM ProjectType e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ProjectType extends AbstractType {

    public static final String TABLE_NAME = "PJ_PRJ_TYPE";
    public static final String SEQUENCE_NAME = "PJ_PRJ_TYPE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ProjectType.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ProjectType.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "ProjectType.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProjectCategory.class)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private ProjectCategory category;

    @ManyToMany
    @JoinTable(name = "PJ_PRJTYPE_PRJROLE", joinColumns = { @JoinColumn(name = "PROJECTTYPES_ID") }, inverseJoinColumns = { @JoinColumn(name = "PROJECTROLES_ID") })
    private Collection<ProjectRole> projectRoles;

    @ManyToMany
    @JoinTable(name = "PJ_PRJTYPE_ISSUETYPE", joinColumns = { @JoinColumn(name = "PROJECTTYPES_ID") }, inverseJoinColumns = { @JoinColumn(name = "ITEMTYPES_ID") })
    private Collection<IssueType> itemTypes;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectCategory getCategory() {
        return this.category;
    }

    public void setCategory(ProjectCategory category) {
        if (category != null) {
            this.__validate_client_context__(category.getClientId());
        }
        this.category = category;
    }

    public Collection<ProjectRole> getProjectRoles() {
        return this.projectRoles;
    }

    public void setProjectRoles(Collection<ProjectRole> projectRoles) {
        this.projectRoles = projectRoles;
    }

    public Collection<IssueType> getItemTypes() {
        return this.itemTypes;
    }

    public void setItemTypes(Collection<IssueType> itemTypes) {
        this.itemTypes = itemTypes;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
