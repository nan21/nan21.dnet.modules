/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeTypeLovDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeType;

public class WfDefNodeTypeLovDsConv extends
        AbstractDsConverter<WfDefNodeTypeLovDs, WfDefNodeType> implements
        IDsConverter<WfDefNodeTypeLovDs, WfDefNodeType> {

    protected void modelToEntityAttributes(WfDefNodeTypeLovDs ds,
            WfDefNodeType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(WfDefNodeTypeLovDs ds,
            WfDefNodeType e) throws Exception {
    }

    @Override
    public void entityToModel(WfDefNodeType e, WfDefNodeTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
