/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.domain.eventhandler;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;

public class PurchaseInvoiceItemEventHandler extends DefaultEventHandler {

	@Override
    public void preInsert(DescriptorEvent event) {
        PurchaseInvoiceItem e = (PurchaseInvoiceItem)event.getSource(); 
        this.calculateLineAmount(e);
    } 
    
	@Override
    public void preUpdate(DescriptorEvent event) {
		PurchaseInvoiceItem e = (PurchaseInvoiceItem)event.getSource();
        this.calculateLineAmount(e);
    } 
	
	private void calculateLineAmount(PurchaseInvoiceItem e) {
        if (e.getUnitPrice() != null && e.getQuantity() != null ) {
            e.setNetAmount(e.getUnitPrice() * e.getQuantity());
        }      
    }
}
