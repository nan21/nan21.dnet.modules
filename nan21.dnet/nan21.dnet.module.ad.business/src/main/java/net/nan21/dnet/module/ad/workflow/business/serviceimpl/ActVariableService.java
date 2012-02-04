/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActVariableService;

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

}
