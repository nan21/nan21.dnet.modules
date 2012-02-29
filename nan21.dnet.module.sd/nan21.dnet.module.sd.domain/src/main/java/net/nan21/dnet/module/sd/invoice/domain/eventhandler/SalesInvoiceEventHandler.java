/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.domain.eventhandler;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

public class SalesInvoiceEventHandler extends DefaultEventHandler {
	
	@Override
    public void preInsert(DescriptorEvent event) {
        SalesInvoice e = (SalesInvoice)event.getSource();  
        this.calculateAmount(e);
    } 
    
	@Override
    public void preUpdate(DescriptorEvent event) {
        SalesInvoice e = (SalesInvoice)event.getSource();
        this.calculateAmount(e);
    } 
	
	private void calculateAmount(SalesInvoice e) {

	    if (e.getTotalNetAmount() == null ) {
            e.setTotalNetAmount( (float) 0 );
        } 
	    if (e.getTotalTaxAmount() == null ) {
            e.setTotalTaxAmount( (float) 0 );
        }
	    e.setTotalAmount(e.getTotalNetAmount() + e.getTotalTaxAmount());	                   
    }
}
 
 