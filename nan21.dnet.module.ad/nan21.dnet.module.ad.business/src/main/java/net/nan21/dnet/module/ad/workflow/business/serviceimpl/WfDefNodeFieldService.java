/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IWfDefNodeFieldService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeField;

public class WfDefNodeFieldService extends
        AbstractEntityService<WfDefNodeField> implements IWfDefNodeFieldService {

    public WfDefNodeFieldService() {
        super();
    }

    public WfDefNodeFieldService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<WfDefNodeField> getEntityClass() {
        return WfDefNodeField.class;
    }

    public WfDefNodeField findByName(Long clientId, String name) {
        return (WfDefNodeField) this.em
                .createNamedQuery(WfDefNodeField.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<WfDefNodeField> findByNode(WfDefNode node) {
        return this.findByNodeId(node.getId());
    }

    public List<WfDefNodeField> findByNodeId(Long nodeId) {
        return (List<WfDefNodeField>) this.em
                .createQuery(
                        "select e from WfDefNodeField e where e.node.id = :pNodeId",
                        WfDefNodeField.class).setParameter("pNodeId", nodeId)
                .getResultList();
    }

}
