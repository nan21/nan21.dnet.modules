/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IWfDefNodeService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeField;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;

public class WfDefNodeService extends AbstractEntityService<WfDefNode>
        implements IWfDefNodeService {

    public WfDefNodeService() {
        super();
    }

    public WfDefNodeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<WfDefNode> getEntityClass() {
        return WfDefNode.class;
    }

    public WfDefNode findByName(String name) {
        return (WfDefNode) this.em.createNamedQuery(WfDefNode.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<WfDefNode> findByProcess(WfDefProcess process) {
        return this.findByProcessId(process.getId());
    }

    public List<WfDefNode> findByProcessId(Long processId) {
        return (List<WfDefNode>) this.em
                .createQuery(
                        "select e from WfDefNode e where e.clientId = :pClientId and e.process.id = :pProcessId",
                        WfDefNode.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProcessId", processId).getResultList();
    }

    public List<WfDefNode> findByFields(WfDefNodeField fields) {
        return this.findByFieldsId(fields.getId());
    }

    public List<WfDefNode> findByFieldsId(Long fieldsId) {
        return (List<WfDefNode>) this.em
                .createQuery(
                        "select distinct e from WfDefNode e , IN (e.fields) c where e.clientId = :pClientId and c.id = :pFieldsId",
                        WfDefNode.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pFieldsId", fieldsId).getResultList();
    }

}
