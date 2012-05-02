/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.tx.fin.business.service.IAccBalanceService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccBalance;

public class AccBalanceService extends AbstractEntityService<AccBalance>
        implements IAccBalanceService {

    public AccBalanceService() {
        super();
    }

    public AccBalanceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AccBalance> getEntityClass() {
        return AccBalance.class;
    }

}
