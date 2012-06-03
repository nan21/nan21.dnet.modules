/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.domain.entity;

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
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** SysDsField. */
@Entity
@Table(name = SysDsField.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = SysDsField.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "DATASOURCE_ID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = SysDsField.NQ_FIND_BY_ID, query = "SELECT e FROM SysDsField e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysDsField.NQ_FIND_BY_IDS, query = "SELECT e FROM SysDsField e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysDsField.NQ_FIND_BY_NAME, query = "SELECT e FROM SysDsField e WHERE e.clientId = :pClientId and  e.dataSource = :pDataSource and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysDsField.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM SysDsField e WHERE e.clientId = :pClientId and  e.dataSource.id = :pDataSourceId and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class SysDsField extends AbstractType {

    public static final String TABLE_NAME = "AD_SYS_DS_FLD";
    public static final String SEQUENCE_NAME = "AD_SYS_DS_FLD_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "SysDsField.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "SysDsField.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "SysDsField.findByName";

    /**
     * Named query find by unique key: Name using the ID field for references.
     */
    public static final String NQ_FIND_BY_NAME_PRIMITIVE = "SysDsField.findByName_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** DataType. */
    @Column(name = "DATATYPE", nullable = false, length = 255)
    @NotBlank
    private String dataType;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SysDataSource.class)
    @JoinColumn(name = "DATASOURCE_ID", referencedColumnName = "ID")
    private SysDataSource dataSource;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public SysDataSource getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(SysDataSource dataSource) {
        if (dataSource != null) {
            this.__validate_client_context__(dataSource.getClientId());
        }
        this.dataSource = dataSource;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
