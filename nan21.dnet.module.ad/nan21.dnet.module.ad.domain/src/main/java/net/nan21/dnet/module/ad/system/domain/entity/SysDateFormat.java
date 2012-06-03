/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.domain.entity;

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
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/**
 * Define date formats available to users.
 *  
 */
@Entity
@Table(name = SysDateFormat.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = SysDateFormat.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = SysDateFormat.NQ_FIND_BY_ID, query = "SELECT e FROM SysDateFormat e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysDateFormat.NQ_FIND_BY_IDS, query = "SELECT e FROM SysDateFormat e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysDateFormat.NQ_FIND_BY_NAME, query = "SELECT e FROM SysDateFormat e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class SysDateFormat extends AbstractType {

    public static final String TABLE_NAME = "AD_SYS_DTFMT";
    public static final String SEQUENCE_NAME = "AD_SYS_DTFMT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "SysDateFormat.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "SysDateFormat.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "SysDateFormat.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** ExtjsDateFormat. */
    @Column(name = "EXTJSDATEFORMAT", length = 255)
    private String extjsDateFormat;

    /** ExtjsTimeFormat. */
    @Column(name = "EXTJSTIMEFORMAT", length = 255)
    private String extjsTimeFormat;

    /** ExtjsDateTimeFormat. */
    @Column(name = "EXTJSDATETIMEFORMAT", length = 255)
    private String extjsDateTimeFormat;

    /** ExtjsAltFormats. */
    @Column(name = "EXTJSALTFORMATS", length = 400)
    private String extjsAltFormats;

    /** JavaDateFormat. */
    @Column(name = "JAVADATEFORMAT", length = 255)
    private String javaDateFormat;

    /** JavaTimeFormat. */
    @Column(name = "JAVATIMEFORMAT", length = 255)
    private String javaTimeFormat;

    /** JavaDateTimeFormat. */
    @Column(name = "JAVADATETIMEFORMAT", length = 255)
    private String javaDateTimeFormat;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExtjsDateFormat() {
        return this.extjsDateFormat;
    }

    public void setExtjsDateFormat(String extjsDateFormat) {
        this.extjsDateFormat = extjsDateFormat;
    }

    public String getExtjsTimeFormat() {
        return this.extjsTimeFormat;
    }

    public void setExtjsTimeFormat(String extjsTimeFormat) {
        this.extjsTimeFormat = extjsTimeFormat;
    }

    public String getExtjsDateTimeFormat() {
        return this.extjsDateTimeFormat;
    }

    public void setExtjsDateTimeFormat(String extjsDateTimeFormat) {
        this.extjsDateTimeFormat = extjsDateTimeFormat;
    }

    public String getExtjsAltFormats() {
        return this.extjsAltFormats;
    }

    public void setExtjsAltFormats(String extjsAltFormats) {
        this.extjsAltFormats = extjsAltFormats;
    }

    public String getJavaDateFormat() {
        return this.javaDateFormat;
    }

    public void setJavaDateFormat(String javaDateFormat) {
        this.javaDateFormat = javaDateFormat;
    }

    public String getJavaTimeFormat() {
        return this.javaTimeFormat;
    }

    public void setJavaTimeFormat(String javaTimeFormat) {
        this.javaTimeFormat = javaTimeFormat;
    }

    public String getJavaDateTimeFormat() {
        return this.javaDateTimeFormat;
    }

    public void setJavaDateTimeFormat(String javaDateTimeFormat) {
        this.javaDateTimeFormat = javaDateTimeFormat;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
