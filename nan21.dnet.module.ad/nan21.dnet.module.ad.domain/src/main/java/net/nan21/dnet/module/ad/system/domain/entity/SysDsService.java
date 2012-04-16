/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** SysDsService. */
@Entity
@Table(name = SysDsService.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = SysDsService.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "DATASOURCE_ID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = SysDsService.NQ_FIND_BY_ID, query = "SELECT e FROM SysDsService e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysDsService.NQ_FIND_BY_IDS, query = "SELECT e FROM SysDsService e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysDsService.NQ_FIND_BY_NAME, query = "SELECT e FROM SysDsService e WHERE e.clientId = :pClientId and  e.dataSource = :pDataSource and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "SysDsService.findByName_PRIMITIVE", query = "SELECT e FROM SysDsService e WHERE e.clientId = :pClientId and  e.dataSource.id = :pDataSourceId and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class SysDsService extends AbstractType {

    public static final String TABLE_NAME = "AD_SYSDSSERVICE";
    public static final String SEQUENCE_NAME = "AD_SYSDSSERVICE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "SysDsService.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "SysDsService.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "SysDsService.findByName";

    /**
     * Named query find by unique key: Name using the ID field for references.
     */
    public static final String NQ_FIND_BY_NAME_PRIMITIVE = "SysDsService.findByName_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

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

    public SysDataSource getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(SysDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.active == null) {
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
