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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.training.domain.entity.Course;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** JobCourse. */
@Entity
@Table(name = JobCourse.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = JobCourse.NQ_FIND_BY_ID, query = "SELECT e FROM JobCourse e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = JobCourse.NQ_FIND_BY_IDS, query = "SELECT e FROM JobCourse e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class JobCourse extends AbstractAuditable {

    public static final String TABLE_NAME = "HR_JOB_COURSE";
    public static final String SEQUENCE_NAME = "HR_JOB_COURSE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "JobCourse.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "JobCourse.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Mandatory. */
    @Column(name = "MANDATORY", nullable = false)
    @NotNull
    private Boolean mandatory;

    /** The number of days the course is valid for. 
    		If it is not null this course should be attended by the employee occupyping this position after the specified number of days. 
     */
    @Column(name = "VALIDFOR")
    private Integer validFor;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Job.class)
    @JoinColumn(name = "JOB_ID", referencedColumnName = "ID")
    private Job job;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Course.class)
    @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID")
    private Course course;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getMandatory() {
        return this.mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Integer getValidFor() {
        return this.validFor;
    }

    public void setValidFor(Integer validFor) {
        this.validFor = validFor;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getMandatory() == null) {
            event.updateAttributeWithObject("mandatory", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
