/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/**  
 * System parameters.
 */
@Entity
@Table(name = SysParam.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = SysParam.TABLE_NAME + "_UK1", columnNames = {
                "CLIENTID", "CODE" }),
        @UniqueConstraint(name = SysParam.TABLE_NAME + "_UK2", columnNames = {
                "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = SysParam.NQ_FIND_BY_ID, query = "SELECT e FROM SysParam e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysParam.NQ_FIND_BY_IDS, query = "SELECT e FROM SysParam e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysParam.NQ_FIND_BY_CODE, query = "SELECT e FROM SysParam e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysParam.NQ_FIND_BY_NAME, query = "SELECT e FROM SysParam e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class SysParam extends AbstractTypeWithCode {

    public static final String TABLE_NAME = "AD_SYSPARAM";
    public static final String SEQUENCE_NAME = "AD_SYSPARAM_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "SysParam.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "SysParam.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "SysParam.findByCode";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "SysParam.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** DefaultValue. */
    @Column(name = "DEFAULTVALUE", length = 400)
    private String defaultValue;

    /** Value. */
    @Column(name = "VALUE", length = 400)
    private String value;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
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
