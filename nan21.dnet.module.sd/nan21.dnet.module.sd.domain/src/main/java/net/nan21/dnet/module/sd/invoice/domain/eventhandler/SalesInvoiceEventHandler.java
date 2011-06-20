/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.domain.eventhandler;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityBaseEventHandler;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

public class SalesInvoiceEventHandler extends DomainEntityBaseEventHandler {
	
	@Override
    public void preInsert(DescriptorEvent event) {
        SalesInvoice e = (SalesInvoice)event.getSource();        
    } 
    
	@Override
    public void preUpdate(DescriptorEvent event) {
        SalesInvoice e = (SalesInvoice)event.getSource();		        
    } 
}
 
 