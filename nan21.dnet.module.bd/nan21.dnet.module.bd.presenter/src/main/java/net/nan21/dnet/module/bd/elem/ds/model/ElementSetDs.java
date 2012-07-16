/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSet;

@Ds(entity = ElementSet.class, sort = { @SortField(field = ElementSetDs.fNAME) })
public class ElementSetDs extends AbstractTypeDs<ElementSet> {

    public static final String fENGINEID = "engineId";
    public static final String fENGINE = "engine";
    public static final String fENGINETYPE = "engineType";

    @DsField(join = "left", path = "engine.id")
    private Long engineId;

    @DsField(join = "left", path = "engine.name")
    private String engine;

    @DsField(join = "left", path = "engine.type")
    private String engineType;

    public ElementSetDs() {
        super();
    }

    public ElementSetDs(ElementSet e) {
        super(e);
    }

    public Long getEngineId() {
        return this.engineId;
    }

    public void setEngineId(Long engineId) {
        this.engineId = engineId;
    }

    public String getEngine() {
        return this.engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getEngineType() {
        return this.engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

}
