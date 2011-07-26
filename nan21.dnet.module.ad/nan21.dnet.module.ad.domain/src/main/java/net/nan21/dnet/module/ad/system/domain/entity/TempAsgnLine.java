/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** TempAsgnLine. */
@Entity
@Table(name = "AD_TEMP_ASGN_LINE")
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({})
@ReadOnly
public class TempAsgnLine implements Serializable {

    private static final long serialVersionUID = -8865917134914502125L;

    /** ItemId. */
    @Column(name = "ITEMID", nullable = false)
    @NotNull
    @Id
    private Long itemId;

    /** SelectionId. */
    @Column(name = "SELECTION_UUID", nullable = false)
    @NotBlank
    @Id
    private String selectionId;

    /* ============== getters - setters ================== */

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getSelectionId() {
        return this.selectionId;
    }

    public void setSelectionId(String selectionId) {
        this.selectionId = selectionId;
    }

    public void aboutToInsert(DescriptorEvent event) {
    }

    public void aboutToUpdate(DescriptorEvent event) {
        TempAsgnLine e = (TempAsgnLine) event.getSource();

    }

}
