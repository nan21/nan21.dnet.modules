/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActPropertyService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProperty;

public class ActPropertyService extends AbstractEntityService<ActProperty>
        implements IActPropertyService {

    public ActPropertyService() {
        super();
    }

    public ActPropertyService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ActProperty> getEntityClass() {
        return ActProperty.class;
    }

}
