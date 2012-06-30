/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActVariableService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActByteArray;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActVariable;

public class ActVariableService extends AbstractEntityService<ActVariable>
        implements IActVariableService {

    public ActVariableService() {
        super();
    }

    public ActVariableService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ActVariable> getEntityClass() {
        return ActVariable.class;
    }

    public List<ActVariable> findByByteArray(ActByteArray byteArray) {
        return this.findByByteArrayId(byteArray.getId());
    }

    public List<ActVariable> findByByteArrayId(String byteArrayId) {
        return (List<ActVariable>) this.em
                .createQuery(
                        "select e from ActVariable e where  e.byteArray.id = :pByteArrayId",
                        ActVariable.class)
                .setParameter("pByteArrayId", byteArrayId).getResultList();
    }

}
