/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeFieldDs;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeField;

public class WfDefNodeFieldDsConv extends
        AbstractDsConverter<WfDefNodeFieldDs, WfDefNodeField> implements
        IDsConverter<WfDefNodeFieldDs, WfDefNodeField> {

    protected void modelToEntityAttributes(WfDefNodeFieldDs ds, WfDefNodeField e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setType(ds.getType());
        e.setRequired(ds.getRequired());
    }

    protected void modelToEntityReferences(WfDefNodeFieldDs ds, WfDefNodeField e)
            throws Exception {

        if (ds.getNodeId() != null) {
            if (e.getNode() == null
                    || !e.getNode().getId().equals(ds.getNodeId())) {
                e.setNode((WfDefNode) this.em.getReference(WfDefNode.class,
                        ds.getNodeId()));
            }
        }
    }

    @Override
    public void entityToModel(WfDefNodeField e, WfDefNodeFieldDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setType(e.getType());
        ds.setRequired(e.getRequired());
        ds.setNodeId(((e.getNode() != null)) ? e.getNode().getId() : null);
    }

}
