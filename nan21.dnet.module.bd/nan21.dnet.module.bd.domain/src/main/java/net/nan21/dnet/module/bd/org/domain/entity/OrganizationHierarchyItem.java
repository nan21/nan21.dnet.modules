/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.domain.entity;

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
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchy;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** OrganizationHierarchyItem. */
@Entity
@Table(name = OrganizationHierarchyItem.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = OrganizationHierarchyItem.NQ_FIND_BY_ID, query = "SELECT e FROM OrganizationHierarchyItem e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = OrganizationHierarchyItem.NQ_FIND_BY_IDS, query = "SELECT e FROM OrganizationHierarchyItem e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class OrganizationHierarchyItem extends AbstractAuditable {

    public static final String TABLE_NAME = "BD_ORG_HIERARCHY_ITEM";
    public static final String SEQUENCE_NAME = "BD_ORG_HIERARCHY_ITEM_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "OrganizationHierarchyItem.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "OrganizationHierarchyItem.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = OrganizationHierarchy.class)
    @JoinColumn(name = "HIERARCHY_ID", referencedColumnName = "ID")
    private OrganizationHierarchy hierarchy;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "ORGANIZATION_ID", referencedColumnName = "ID")
    private Organization organization;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
    private Organization parent;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrganizationHierarchy getHierarchy() {
        return this.hierarchy;
    }

    public void setHierarchy(OrganizationHierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Organization getOrganization() {
        return this.organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Organization getParent() {
        return this.parent;
    }

    public void setParent(Organization parent) {
        this.parent = parent;
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
