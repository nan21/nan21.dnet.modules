/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.domain.eventhandler;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;

public class PurchaseInvoiceEventHandler extends DefaultEventHandler {

	@Override
    public void preInsert(DescriptorEvent event) {
        PurchaseInvoice e = (PurchaseInvoice)event.getSource();  
        this.calculateAmount(e);
    } 
    
	@Override
    public void preUpdate(DescriptorEvent event) {
		PurchaseInvoice e = (PurchaseInvoice)event.getSource();
        this.calculateAmount(e);
    } 
	
	private void calculateAmount(PurchaseInvoice e) {

	    if (e.getTotalNetAmount() == null ) {
            e.setTotalNetAmount( (float) 0 );
        } 
	    if (e.getTotalTaxAmount() == null ) {
            e.setTotalTaxAmount( (float) 0 );
        }
	    e.setTotalAmount(e.getTotalNetAmount() + e.getTotalTaxAmount());	                   
    }
}
