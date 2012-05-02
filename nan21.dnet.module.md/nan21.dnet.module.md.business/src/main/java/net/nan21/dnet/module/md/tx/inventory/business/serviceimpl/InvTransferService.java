/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.inventory.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.tx.inventory.business.service.IInvTransferService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransfer;

public class InvTransferService extends AbstractEntityService<InvTransfer>
        implements IInvTransferService {

    public InvTransferService() {
        super();
    }

    public InvTransferService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<InvTransfer> getEntityClass() {
        return InvTransfer.class;
    }

}
