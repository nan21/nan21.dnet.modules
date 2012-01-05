/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.filter;

import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class SkillLovDsFilter extends AbstractDsFilter implements IModelWithId,
        IModelWithClientId {

    private Long id;

    private Long id_From;
    private Long id_To;

    private Long clientId;

    private Long clientId_From;
    private Long clientId_To;

    private String name;

    private Boolean active;

    private Long ratingScaleId;

    private Long ratingScaleId_From;
    private Long ratingScaleId_To;

    public Long getId() {
        return this.id;
    }

    public Long getId_From() {
        return this.id_From;
    }

    public Long getId_To() {
        return this.id_To;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public Long getClientId_From() {
        return this.clientId_From;
    }

    public Long getClientId_To() {
        return this.clientId_To;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setClientId_From(Long clientId_From) {
        this.clientId_From = clientId_From;
    }

    public void setClientId_To(Long clientId_To) {
        this.clientId_To = clientId_To;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getRatingScaleId() {
        return this.ratingScaleId;
    }

    public Long getRatingScaleId_From() {
        return this.ratingScaleId_From;
    }

    public Long getRatingScaleId_To() {
        return this.ratingScaleId_To;
    }

    public void setRatingScaleId(Long ratingScaleId) {
        this.ratingScaleId = ratingScaleId;
    }

    public void setRatingScaleId_From(Long ratingScaleId_From) {
        this.ratingScaleId_From = ratingScaleId_From;
    }

    public void setRatingScaleId_To(Long ratingScaleId_To) {
        this.ratingScaleId_To = ratingScaleId_To;
    }

}
