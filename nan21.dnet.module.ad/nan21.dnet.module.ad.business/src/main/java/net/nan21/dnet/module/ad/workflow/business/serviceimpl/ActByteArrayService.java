/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActByteArrayService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActByteArray;

public class ActByteArrayService extends AbstractEntityService<ActByteArray>
        implements IActByteArrayService {

    public ActByteArrayService() {
        super();
    }

    public ActByteArrayService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ActByteArray> getEntityClass() {
        return ActByteArray.class;
    }

    public List<ActByteArray> findByDeployment(ActDeployment deployment) {
        return this.findByDeploymentId(deployment.getId());
    }

    public List<ActByteArray> findByDeploymentId(String deploymentId) {
        return (List<ActByteArray>) this.em
                .createQuery(
                        "select e from ActByteArray e where  e.deployment.id = :pDeploymentId",
                        ActByteArray.class)
                .setParameter("pDeploymentId", deploymentId).getResultList();
    }

}
