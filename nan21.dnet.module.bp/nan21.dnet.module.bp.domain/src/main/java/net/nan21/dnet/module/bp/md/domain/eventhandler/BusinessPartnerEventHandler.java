/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.domain.eventhandler;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityBaseEventHandler;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

public class BusinessPartnerEventHandler extends DomainEntityBaseEventHandler {

    @Override
    public void preInsert(DescriptorEvent event) {
        BusinessPartner e = (BusinessPartner) event.getSource();
        if(e.getCode() == null || e.getCode().equals("")) {
        	if (e.getType().equals("person")) {
        		e.setCode("P-"+e.getId());
        	} else {
        		e.setCode("C-"+e.getId());
        	}
        }
    }

    @Override
    public void preUpdate(DescriptorEvent event) {
        BusinessPartner e = (BusinessPartner) event.getSource();
    }
}
