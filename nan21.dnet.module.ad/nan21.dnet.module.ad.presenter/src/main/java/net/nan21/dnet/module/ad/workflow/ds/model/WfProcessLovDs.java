/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.ad.workflow.domain.entity.WfProcess;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = WfProcess.class)
public class WfProcessLovDs extends AbstractDsModel<WfProcess> implements
        IModelWithId {

    public static final String fID = "id";
    public static final String fNAME = "name";
    public static final String fFULLNAME = "fullName";

    @DsField()
    private String id;

    @DsField()
    private String name;

    @DsField(fetch = false)
    private String fullName;

    public WfProcessLovDs() {
        super();
    }

    public WfProcessLovDs(WfProcess e) {
        super(e);
    }

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
