/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** SysFrameExtension. */
@Entity
@Table(name = SysFrameExtension.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = SysFrameExtension.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "FRAMEFQN", "FILELOCATION" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = SysFrameExtension.NQ_FIND_BY_ID, query = "SELECT e FROM SysFrameExtension e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysFrameExtension.NQ_FIND_BY_IDS, query = "SELECT e FROM SysFrameExtension e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysFrameExtension.NQ_FIND_BY_NAME, query = "SELECT e FROM SysFrameExtension e WHERE e.clientId = :pClientId and  e.frameFQN = :pFrameFQN and e.fileLocation = :pFileLocation ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class SysFrameExtension extends AbstractAuditable {

    public static final String TABLE_NAME = "AD_SYS_FRAME_EXT";
    public static final String SEQUENCE_NAME = "AD_SYS_FRAME_EXT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "SysFrameExtension.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "SysFrameExtension.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "SysFrameExtension.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** FrameFQN. */
    @Column(name = "FRAMEFQN", nullable = false, length = 255)
    @NotBlank
    private String frameFQN;

    /** SequenceNo. */
    @Column(name = "SEQUENCENO", nullable = false)
    @NotNull
    private Integer sequenceNo;

    /** FileLocation. */
    @Column(name = "FILELOCATION", nullable = false, length = 255)
    @NotBlank
    private String fileLocation;

    /** RelativePath. */
    @Column(name = "RELATIVEPATH", nullable = false)
    @NotNull
    private Boolean relativePath;

    /** Active. */
    @Column(name = "ACTIVE", nullable = false)
    @NotNull
    private Boolean active;

    /** Description. */
    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrameFQN() {
        return this.frameFQN;
    }

    public void setFrameFQN(String frameFQN) {
        this.frameFQN = frameFQN;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getFileLocation() {
        return this.fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Boolean getRelativePath() {
        return this.relativePath;
    }

    public void setRelativePath(Boolean relativePath) {
        this.relativePath = relativePath;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getRelativePath() == null) {
            event.updateAttributeWithObject("relativePath", false);
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
