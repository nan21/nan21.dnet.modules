/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.filter;

import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class ActProcessDefinitionLovDsFilter extends AbstractDsFilter implements
        IModelWithId {

    private String id;

    private String name;

    private String fullName;

    public String getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (String) id;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
