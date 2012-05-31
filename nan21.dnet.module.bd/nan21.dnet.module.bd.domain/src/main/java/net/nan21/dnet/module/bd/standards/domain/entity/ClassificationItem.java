/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.standards.domain.entity;

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
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** ClassificationItem. */
@Entity
@Table(name = ClassificationItem.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = ClassificationItem.TABLE_NAME + "_UK1", columnNames = {
                "CLIENTID", "CLASSSYSTEM_ID", "CODE" }),
        @UniqueConstraint(name = ClassificationItem.TABLE_NAME + "_UK2", columnNames = {
                "CLIENTID", "CLASSSYSTEM_ID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ClassificationItem.NQ_FIND_BY_ID, query = "SELECT e FROM ClassificationItem e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ClassificationItem.NQ_FIND_BY_IDS, query = "SELECT e FROM ClassificationItem e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ClassificationItem.NQ_FIND_BY_SYSCODE, query = "SELECT e FROM ClassificationItem e WHERE e.clientId = :pClientId and  e.classSystem = :pClassSystem and e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ClassificationItem.findBySyscode_PRIMITIVE", query = "SELECT e FROM ClassificationItem e WHERE e.clientId = :pClientId and  e.classSystem.id = :pClassSystemId and e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ClassificationItem.NQ_FIND_BY_SYSNAME, query = "SELECT e FROM ClassificationItem e WHERE e.clientId = :pClientId and  e.classSystem = :pClassSystem and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ClassificationItem.findBySysname_PRIMITIVE", query = "SELECT e FROM ClassificationItem e WHERE e.clientId = :pClientId and  e.classSystem.id = :pClassSystemId and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ClassificationItem extends AbstractTypeWithCode {

    public static final String TABLE_NAME = "BD_CLSF_ITEM";
    public static final String SEQUENCE_NAME = "BD_CLSF_ITEM_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ClassificationItem.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ClassificationItem.findByIds";

    /**
     * Named query find by unique key: Syscode.
     */
    public static final String NQ_FIND_BY_SYSCODE = "ClassificationItem.findBySyscode";

    /**
     * Named query find by unique key: Syscode using the ID field for references.
     */
    public static final String NQ_FIND_BY_SYSCODE_PRIMITIVE = "ClassificationItem.findBySyscode_PRIMITIVE";

    /**
     * Named query find by unique key: Sysname.
     */
    public static final String NQ_FIND_BY_SYSNAME = "ClassificationItem.findBySysname";

    /**
     * Named query find by unique key: Sysname using the ID field for references.
     */
    public static final String NQ_FIND_BY_SYSNAME_PRIMITIVE = "ClassificationItem.findBySysname_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ClassificationSystem.class)
    @JoinColumn(name = "CLASSSYSTEM_ID", referencedColumnName = "ID")
    private ClassificationSystem classSystem;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassificationSystem getClassSystem() {
        return this.classSystem;
    }

    public void setClassSystem(ClassificationSystem classSystem) {
        this.classSystem = classSystem;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

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
