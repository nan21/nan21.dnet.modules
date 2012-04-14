/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.standards.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class ClassificationCodeDsFilter extends AbstractTypeWithCodeDsFilter {

    private Long classSystemId;

    private Long classSystemId_From;
    private Long classSystemId_To;

    private String classSystem;

    public Long getClassSystemId() {
        return this.classSystemId;
    }

    public Long getClassSystemId_From() {
        return this.classSystemId_From;
    }

    public Long getClassSystemId_To() {
        return this.classSystemId_To;
    }

    public void setClassSystemId(Long classSystemId) {
        this.classSystemId = classSystemId;
    }

    public void setClassSystemId_From(Long classSystemId_From) {
        this.classSystemId_From = classSystemId_From;
    }

    public void setClassSystemId_To(Long classSystemId_To) {
        this.classSystemId_To = classSystemId_To;
    }

    public String getClassSystem() {
        return this.classSystem;
    }

    public void setClassSystem(String classSystem) {
        this.classSystem = classSystem;
    }

}
