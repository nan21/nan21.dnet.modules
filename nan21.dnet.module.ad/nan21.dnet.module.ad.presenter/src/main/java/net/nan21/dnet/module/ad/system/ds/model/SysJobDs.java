/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysJob;

@Ds(entity = SysJob.class, sort = { @SortField(field = SysJobDs.fNAME) })
public class SysJobDs extends AbstractTypeDs<SysJob> {

    public static final String fJAVACLASS = "javaClass";

    @DsField()
    private String javaClass;

    public SysJobDs() {
        super();
    }

    public SysJobDs(SysJob e) {
        super(e);
    }

    public String getJavaClass() {
        return this.javaClass;
    }

    public void setJavaClass(String javaClass) {
        this.javaClass = javaClass;
    }

}
