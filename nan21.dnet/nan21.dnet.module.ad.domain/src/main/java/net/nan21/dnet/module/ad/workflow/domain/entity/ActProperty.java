/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** ActProperty. */
@Entity
@Table(name = ActProperty.TABLE_NAME)
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({})
@ReadOnly
@Cache(type = CacheType.NONE)
public class ActProperty implements Serializable {

    public static final String TABLE_NAME = "ACT_GE_PROPERTY";
    public static final String SEQUENCE_NAME = "ACT_GE_PROPERTY_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /** Name. */
    @Column(name = "NAME_", nullable = false, length = 255)
    @NotBlank
    @Id
    private String name;

    /** Revision. */
    @Column(name = "REV_", nullable = false)
    @NotNull
    private Integer revision;

    /** Value. */
    @Column(name = "VALUE", length = 400)
    private String value;

    /* ============== getters - setters ================== */

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRevision() {
        return this.revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Transient
    public Long getVersion() {
        return 1L;
    }

    public void setVersion(Long version) {

    }

    public void aboutToInsert(DescriptorEvent event) {

    }

    public void aboutToUpdate(DescriptorEvent event) {

    }

}
