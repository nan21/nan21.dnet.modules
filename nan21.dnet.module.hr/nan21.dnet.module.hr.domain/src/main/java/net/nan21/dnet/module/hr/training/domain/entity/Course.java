/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.domain.entity;

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
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Course. */
@Entity
@Table(name = Course.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = Course.TABLE_NAME + "_UK1", columnNames = {
                "CLIENTID", "CODE" }),
        @UniqueConstraint(name = Course.TABLE_NAME + "_UK2", columnNames = {
                "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Course.NQ_FIND_BY_ID, query = "SELECT e FROM Course e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Course.NQ_FIND_BY_IDS, query = "SELECT e FROM Course e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Course.NQ_FIND_BY_CODE, query = "SELECT e FROM Course e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Course.NQ_FIND_BY_NAME, query = "SELECT e FROM Course e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Course extends AbstractTypeWithCode {

    public static final String TABLE_NAME = "HR_COURSE";
    public static final String SEQUENCE_NAME = "HR_COURSE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Course.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Course.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "Course.findByCode";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "Course.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** IntendedAudience. */
    @Column(name = "INTENDEDAUDIENCE", length = 4000)
    private String intendedAudience;

    /** Requirements. */
    @Column(name = "REQUIREMENTS", length = 4000)
    private String requirements;

    /** DeliveredCompetences. */
    @Column(name = "DELIVEREDCOMPETENCES", length = 4000)
    private String deliveredCompetences;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CourseType.class)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private CourseType type;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntendedAudience() {
        return this.intendedAudience;
    }

    public void setIntendedAudience(String intendedAudience) {
        this.intendedAudience = intendedAudience;
    }

    public String getRequirements() {
        return this.requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDeliveredCompetences() {
        return this.deliveredCompetences;
    }

    public void setDeliveredCompetences(String deliveredCompetences) {
        this.deliveredCompetences = deliveredCompetences;
    }

    public CourseType getType() {
        return this.type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.active == null) {
            event.updateAttributeWithObject("active", false);
        }
        if (this.code == null || this.code.equals("")) {
            event.updateAttributeWithObject("code", "CRS-" + this.getId());
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
