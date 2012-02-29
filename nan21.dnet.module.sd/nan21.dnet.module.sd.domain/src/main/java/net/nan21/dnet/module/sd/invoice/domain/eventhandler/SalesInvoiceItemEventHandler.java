/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.domain.eventhandler;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;

public class SalesInvoiceItemEventHandler extends DefaultEventHandler {
	
	@Override
    public void preInsert(DescriptorEvent event) {
        SalesInvoiceItem e = (SalesInvoiceItem)event.getSource(); 
        this.calculateLineAmount(e);
    } 
    
	@Override
    public void preUpdate(DescriptorEvent event) {
        SalesInvoiceItem e = (SalesInvoiceItem)event.getSource();
        this.calculateLineAmount(e);
    } 
	
	private void calculateLineAmount(SalesInvoiceItem e) {
        if (e.getUnitPrice() != null && e.getQuantity() != null ) {
            e.setNetAmount(e.getUnitPrice() * e.getQuantity());
        }      
    }
}
 
 