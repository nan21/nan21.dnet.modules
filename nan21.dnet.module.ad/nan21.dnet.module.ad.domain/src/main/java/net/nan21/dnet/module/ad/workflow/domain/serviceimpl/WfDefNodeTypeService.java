/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.domain.service.IWfDefNodeTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeType;

public class WfDefNodeTypeService extends AbstractEntityService<WfDefNodeType>
        implements IWfDefNodeTypeService {

    public WfDefNodeTypeService() {
        super();
    }

    public WfDefNodeTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<WfDefNodeType> getEntityClass() {
        return WfDefNodeType.class;
    }

    public WfDefNodeType findByName(Long clientId, String name) {
        return (WfDefNodeType) this.em
                .createNamedQuery(WfDefNodeType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
