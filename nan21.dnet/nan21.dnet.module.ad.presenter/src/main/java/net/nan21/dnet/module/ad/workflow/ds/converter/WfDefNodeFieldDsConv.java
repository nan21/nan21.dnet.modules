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

    protected void modelToEntityReferences(WfDefNodeFieldDs ds, WfDefNodeField e)
            throws Exception {
        if (ds.getNodeId() != null) {
            if (e.getNode() == null
                    || !e.getNode().getId().equals(ds.getNodeId())) {
                e.setNode((WfDefNode) this.em.find(WfDefNode.class,
                        ds.getNodeId()));
            }
        }
    }

}
